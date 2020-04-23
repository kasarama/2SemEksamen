package FunctionLayer;

public class Shed {

    private int width;
    private int depth;
    private String side;
    private String corner;

    public Shed(int width, int depth) {
        this.width = width;
        this.depth = depth;

    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getCorner() {
        return corner;
    }

    public void setCorner(String corner) {
        this.corner = corner;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
