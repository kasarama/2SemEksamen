package FunctionLayer;

import com.sun.javafx.binding.StringFormatter;

public class Svg {

    private int width;
    private int height;
    private String viewbox;
    private int x;
    private int y;
    private StringBuilder svg = new StringBuilder();

    private final String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"%s\" width=\"%s\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:black; fill: #ffffff\" />";
    private final String bandTemplate = "<line x1=\"%d\"  y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:black; stroke-dasharray: 10 5\"/>";
    private final String arrow = "<defs>\n" +
            "        <marker\n" +
            "            id=\"beginArrow\"\n" +
            "            markerWidth=\"8\"\n" +
            "            markerHeight=\"8\"\n" +
            "            refX=\"4\"\n" +
            "            refY=\"4\"\n" +
            "            orient=\"auto\">\n" +
            "            <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: black;\" />\n" +
            "        </marker>\n" +
            "        <marker\n" +
            "                id=\"endArrow\"\n" +
            "                markerWidth=\"8\"\n" +
            "                markerHeight=\"8\"\n" +
            "                refX=\"8\"\n" +
            "                refY=\"4\"\n" +
            "                orient=\"auto\">\n" +
            "            <path d=\"M0,0 L8,4 L0,8 L0,0 \" style=\"fill: black;\" />\n" +
            "        </marker>\n" +
            "    </defs>\n" +
            "    <line x1=\"%d\"  y1=\"%d\" x2=\"%d\"   y2=\"%d\"\n" +
            "          style=\"stroke: black;\n" +
            "\tmarker-start: url(#beginArrow);\n" +
            "\tmarker-end: url(#endArrow);\"/>\n" +
            "    <text style=\"text-anchor: middle; font-size: 12;\" transform=\"translate(%d,%d) rotate(%d)\">%s</text>\n";

    public Svg(int width, int height, String viewbox, int x, int y) {
        this.width = width;
        this.height = height;
        this.viewbox = viewbox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewbox));
    }

    public void addRect(int x, int y, int height, int width){
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addBand(int x1, int y1, int x2, int y2){
        svg.append(String.format(bandTemplate, x1, y1, x2, y2));
    }
    public void addArrows(int x1, int y1, int x2, int y2, int trans1, int trans2, int rotation, String text){
        svg.append(String.format(arrow, x1, y1, x2, y2, trans1, trans2, rotation, text));
    }
    /*
    public void addText(){
        "<text style=\"text-anchor: middle; font-size: 12;\" transform=\"translate(%d,%d) rotate(%d)\">%s</text>";
    }

     */

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getViewbox() {
        return viewbox;
    }

    public void setViewbox(String viewbox) {
        this.viewbox = viewbox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}