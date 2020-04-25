package FunctionLayer;

public class Shed {

    private int width;
    private int depth;
    private String side;

    public Shed(int width, int depth, String side) {
        this.width = width;
        this.depth = depth;
        this.side = side;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
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
