package country;

import unit.Unit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Country {
    private boolean human;
    private String name;
    private String tag;
    private String provinceColor;
    private String unitColor;
    private Map<String, Unit> units;

    public Country(String name, String tag, String provinceColor, String unitColor) {
        this.human = false;
        this.name = name;
        this.tag = tag;
        this.provinceColor = provinceColor;
        this.unitColor = unitColor;
        this.units = new HashMap<>();
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public String getProvinceColor() {
        return provinceColor;
    }

    public String getUnitColor() {
        return unitColor;
    }

    public Map<String, Unit> getUnits() {
        return units;
    }

    public Collection<Unit> listUnits() {
        return units.values();
    }

    public void addUnit(Unit unit) {
        units.put(unit.getLocation().getTag(), unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit.getLocation().getTag());
    }

    @Override
    public String toString() {
        return String.format("%s/%s (%s)", name, tag, human ? "human" : "AI");
    }
}
