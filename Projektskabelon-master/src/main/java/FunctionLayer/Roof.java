package FunctionLayer;

import java.util.ArrayList;

public abstract class Roof {
    private int height;
    private int length;
    private int width;
    private int degree;
    private ArrayList<Material> roofMaterialList;
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
        roofMaterialList = new ArrayList();
        this.tilt = tilt;

    }

    public String optionForFlatRoof(){
        return "";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDegree(int degree) { this.degree = degree;
    }

    public void setRoofMaterialList(ArrayList<Material> roofMaterialList) {
        this.roofMaterialList = roofMaterialList;
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

    public ArrayList<Material> getRoofMaterialList() {
        return roofMaterialList;
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
    public String typeToString() {
        if (this.pitched){
            return "med rejsning";
        } else return "fladt";
    }
}
