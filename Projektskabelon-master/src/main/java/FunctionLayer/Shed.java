package FunctionLayer;

import java.util.ArrayList;

public class Shed {

    private int width;
    private int depth;
    private String side;
    private ArrayList<Wall> walls;

    public Shed(int width, int depth, String side) {
        this.width = width;
        this.depth = depth;
        this.side = side;
        this.walls= new ArrayList<>();
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void setWalls(ArrayList<Wall> walls) {
        this.walls = walls;
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
