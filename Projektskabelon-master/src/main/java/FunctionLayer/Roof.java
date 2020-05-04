package FunctionLayer;

import java.util.ArrayList;

public abstract class Roof {
    private int height;
    private int length;
    private int width;
    private int degree;
    ArrayList<Material> tagMaterialList;
    private boolean pitched;


    public Roof(int height, int length, int width, int degree, boolean pitched) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.degree = degree;
        this.pitched = pitched;
        tagMaterialList = new ArrayList();

    }

    public Roof() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int setDegree(int degree) {
        return degree;
    }

    public void setTagMaterialList(ArrayList<Material> tagMaterialList) {
        this.tagMaterialList = tagMaterialList;
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

    public void setPitched(boolean pitched) {
        this.pitched = pitched;
    }

    public boolean getIsPitched() {
        return pitched;
    }

    public void calculateWidth(Construction construction){
        this.width=construction.getConstructionWidth();
    }

}
