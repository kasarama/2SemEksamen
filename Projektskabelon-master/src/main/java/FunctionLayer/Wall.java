package FunctionLayer;

import java.util.ArrayList;

public class Wall {
    private String side;
    private int raising;
    private int length;
    private int minHeight;
    private ArrayList<Material> materials;

    public Wall() {
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getRaising() {
        return raising;
    }

    public void setRaising(int raising) {
        this.raising = raising;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return side+" wall that falls "+raising+"cm/m";
                    }
}
