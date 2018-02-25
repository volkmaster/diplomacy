package svg;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import java.io.IOException;

public class Image {
    private JSVGCanvas canvas;
    private String uri;
    private SVGDocument document;

    public Image(JSVGCanvas canvas, String uri) {
        this.canvas = canvas;
        this.uri = uri;

        this.setupCanvas();
        this.loadDocument();
    }

    public JSVGCanvas getCanvas() {
        return canvas;
    }

    public SVGDocument getDocument() {
        return document;
    }

    private void setupCanvas() {
        canvas.setDocumentState(JSVGCanvas.ALWAYS_INTERACTIVE);
    }

    private void loadDocument() {
        document = null;
        try {
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory documentFactory = new SAXSVGDocumentFactory(parser);
            document = documentFactory.createSVGDocument(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Element findProvince(String tag) {
        return document.getElementById(tag);
    }

    public void repaint() {
        canvas.setDocument(document);
    }
}
