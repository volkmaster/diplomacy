import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import common.Constants;
import country.Country;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventTarget;
import province.LandProvince;
import province.Province;
import province.SupplyCenter;
import svg.Image;
import unit.Army;
import unit.Navy;
import unit.Unit;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class GUI {
    private Game game;
    private Image image;
    private Map<String, Element> provinceElements;
    private Map<String, Element> armyElements;
    private Map<String, Element> navyElements;
    private Map<String, Element> supplyCenterElements;
    private Province sourceProvince;

    private JPanel panel;
    private JSVGCanvas canvas;
    private JPanel commandPanel;
    private JButton button;

    public GUI() {
        game = new Game();
        $$$setupUI$$$();
        setup();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Diplomacy");
        frame.setContentPane(new GUI().panel);
        frame.setSize(1200, 1200);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation(screenDimension.width / 2 - frameDimension.width / 2,
                screenDimension.height / 2 - frameDimension.height / 2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setup() {
        String uri = GUI.class.getResource("images/map.svg").toString();
        image = new Image(canvas, uri);
        getElements();

        Element element;
        for (Province province : game.listProvinces()) {
            element = provinceElements.get(province.getTag());
            drawSupplyCenter(province);
            drawArmy(province);
            drawNavy(province);
            setOnClickListener(province, element);
        }

        setNextTurnListener();

        image.repaint();
        sourceProvince = null;
    }

    private void getElements() {
        provinceElements = new HashMap<>();
        armyElements = new HashMap<>();
        navyElements = new HashMap<>();
        supplyCenterElements = new HashMap<>();

        String tag;
        Element element;
        for (Province province : game.listProvinces()) {
            tag = province.getTag();
            element = image.findProvince(tag);
            provinceElements.put(tag, element);

            NodeList nodes = element.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    switch (node.getNodeName()) {
                        case "use":
                            switch (el.getAttributeNS("http://www.w3.org/1999/xlink", "href")) {
                                case "#army":
                                    armyElements.put(tag, el);
                                    break;
                                case "#navy":
                                    navyElements.put(tag, el);
                                    break;
                            }
                            break;
                        case "circle":
                            supplyCenterElements.put(tag, el);
                            break;
                    }
                }
            }
        }
    }

    private void drawSupplyCenter(Province province) {
        Element element = supplyCenterElements.get(province.getTag());
        if (element != null) {
            SupplyCenter supplyCenter = ((LandProvince) province).getSupplyCenter();
            Country occupier = supplyCenter.getOccupier();
            String color = occupier != null ? occupier.getProvinceColor() : Province.COLOR_NEUTRAL;
            element.setAttribute("fill", color);
        }
    }

    private void drawArmy(Province province) {
        Element element = armyElements.get(province.getTag());
        if (element != null) {
            Unit unit = province.getUnit();
            if (unit != null && unit instanceof Army) {
                element.setAttribute("visibility", "visible");
                element.setAttribute("fill", unit.getOwner().getUnitColor());
            } else {
                element.setAttribute("visibility", "hidden");
            }
        }
    }

    private void drawNavy(Province province) {
        Element element = navyElements.get(province.getTag());
        if (element != null) {
            Unit unit = province.getUnit();
            if (unit != null && unit instanceof Navy) {
                element.setAttribute("visibility", "visible");
                element.setAttribute("fill", unit.getOwner().getUnitColor());
            } else {
                element.setAttribute("visibility", "hidden");
            }
        }
    }

    private void setOnClickListener(Province targetProvince, Element root) {
        ((EventTarget) root).addEventListener("click", e -> {
            if (sourceProvince != null) {
                System.out.println(sourceProvince.getTag() + "-" + targetProvince.getTag());
                moveUnit(sourceProvince, targetProvince);
                sourceProvince = null;
            } else {
                sourceProvince = targetProvince;
            }
        }, false);
    }

    private void setNextTurnListener() {
        button.addActionListener(e -> {
            for (Province province : game.listProvinces()) {
                Unit unit = province.getUnit();
                if (unit != null) {
                    if (province instanceof LandProvince) {
                        SupplyCenter supplyCenter = ((LandProvince) province).getSupplyCenter();
                        if (supplyCenter != null) {
                            supplyCenter.setOccupier(unit.getOwner());
                        }
                    }
                }
                drawSupplyCenter(province);
            }

            image.repaint();
            sourceProvince = null;
        });
    }

    private void moveUnit(Province source, Province target) {
        Unit sourceUnit = source.getUnit();
        if (sourceUnit == null) {
            System.out.println("\t- no source unit");
            return;
        }

        Unit targetUnit = getUnit(target);
        if (targetUnit != null) {
            System.out.println("\t- target unit present");
            return;
        }

        if (!isMoveAllowed(source, target)) {
            System.out.println("\t- not allowed");
            return;
        }

        sourceUnit.setLocation(target);
        target.setUnit(sourceUnit);
        source.setUnit(targetUnit);

        if (sourceUnit instanceof Army) {
            drawArmy(source);
            drawArmy(target);
        } else if (sourceUnit instanceof Navy) {
            drawNavy(source);
            drawNavy(target);
        }
        image.repaint();
    }

    private Unit getUnit(Province province) {
        if (isSpecialProvince(province)) {
            for (String tag : Constants.SPECIAL_PROVINCES.get(province.getTag())) {
                Unit unit = game.getProvinces().get(tag).getUnit();
                if (unit != null) {
                    return unit;
                }
            }
        }
        return province.getUnit();
    }

    private boolean isSpecialProvince(Province province) {
        return Constants.SPECIAL_PROVINCES.containsKey(province.getTag());
    }

    private boolean isMoveAllowed(Province source, Province target) {
        boolean success = false;
        Unit unit = source.getUnit();
        if (unit instanceof Army) {
            success = Constants.ARMY_MOVES.get(source.getTag()).contains(target.getTag());
        } else if (unit instanceof Navy) {
            success = Constants.NAVY_MOVES.get(source.getTag()).contains(target.getTag());
        }
        return success;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        panel.setBackground(new Color(-4473925));
        panel.setEnabled(true);
        canvas = new JSVGCanvas();
        canvas.setBackground(new Color(-4473925));
        canvas.setOpaque(false);
        canvas.setRecenterOnResize(true);
        canvas.setSelectionOverlayColor(new Color(-4473925));
        canvas.setSelectionOverlayStrokeColor(new Color(-4473925));
        panel.add(canvas, BorderLayout.CENTER);
        commandPanel = new JPanel();
        commandPanel.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        commandPanel.setBackground(new Color(-4473925));
        panel.add(commandPanel, BorderLayout.SOUTH);
        button = new JButton();
        button.setBackground(new Color(-1578260));
        button.setHorizontalAlignment(0);
        button.setHorizontalTextPosition(0);
        button.setMargin(new Insets(20, 20, 20, 20));
        button.setText("Next turn");
        button.setVerticalAlignment(0);
        button.setVerticalTextPosition(0);
        commandPanel.add(button, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        commandPanel.add(spacer1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        commandPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        commandPanel.add(spacer3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(10, 10), null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        commandPanel.add(spacer4, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(10, 10), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
