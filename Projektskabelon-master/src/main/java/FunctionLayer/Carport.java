package FunctionLayer;

import java.util.ArrayList;

public class Carport {
    private int width;
    private int length;
    private int shedDepth;
    private int angle;

    private ArrayList<Material> materialList;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getShedDepth() {
        return shedDepth;
    }

    public void setShedDepth(int shedDepth) {
        this.shedDepth = shedDepth;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public ArrayList<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(ArrayList<Material> materialList) {
        this.materialList = materialList;
    }
}