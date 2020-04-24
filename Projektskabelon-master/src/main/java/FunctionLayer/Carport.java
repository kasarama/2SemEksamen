package FunctionLayer;

import java.util.ArrayList;

public class Carport {
    private int width;
    private int length;
    private int shedDepth;
    private int angle;
    private ArrayList<Material> woodMaterialList;
    private ArrayList<Material> otherMaterialList;
    private ArrayList<Material> tagMaterialList;
    private double cost;
    private double salePrice;

    public Carport() {
        this.woodMaterialList= new ArrayList<>();
        this.otherMaterialList = new ArrayList<>();
        this.tagMaterialList = new ArrayList<>();
    }

    public void addWoodMaterial (Material material){
        woodMaterialList.add(material);
    }
    public void addOtherMaterial (Material material){
        otherMaterialList.add(material);
    }
    public void addTagMaterial (Material material){
        tagMaterialList.add(material);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

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

    public ArrayList<Material> getWoodMaterialList() {
        return woodMaterialList;
    }

    public void setMaterialList(ArrayList<Material> woodMaterialList) {
        this.woodMaterialList = woodMaterialList;
    }

    public ArrayList<Material> getOtherMaterialList() {
        return otherMaterialList;
    }
    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }
}