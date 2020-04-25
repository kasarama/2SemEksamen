package FunctionLayer;

import java.util.ArrayList;

public abstract class Roof {
    private int height;
    private int length;
    private int width;
    private int degree;
    ArrayList<Material> tagMaterialList;
    private boolean pitched;

    public Roof(int height, int length, int width, int degree) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.degree = degree;
        tagMaterialList = new ArrayList();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDegree() {
        return degree;
    }


    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }


    public boolean isPitched() {
        return pitched;
    }

}
