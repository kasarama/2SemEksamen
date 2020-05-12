package FunctionLayer;

import java.util.ArrayList;

public abstract class Roof {
    private int height;
    private int length;
    private int width;
    private int degree;
    ArrayList<Material> tagMaterialList;
    private boolean pitched;
    private int tilt;
    private String color;
    private String cover;


    public Roof(int height, int length, int width, int degree, boolean pitched, int tilt) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.degree = degree;
        this.pitched = pitched;
        tagMaterialList = new ArrayList();
        this.tilt = tilt;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTilt() {
        return tilt;
    }

    public void setTilt(int tilt) {
        this.tilt = tilt;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
