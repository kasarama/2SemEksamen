package FunctionLayer;

import java.util.ArrayList;

public class Carport {
    private int width;
    private int length;
    private int shedDepth;
    private int angle;
    private Shed shed;
    private Roof roof;
    private ArrayList<Material> materialList;
    private double cost;
    private double salePrice;

    public Shed getShed() {
        return shed;
    }

    public void setShed(Shed shed) {
        this.shed = shed;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public Carport() {
        this.materialList= new ArrayList<>();

    }

    public void addMaterial (Material material){
        materialList.add(material);
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

    public ArrayList<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(ArrayList<Material> materialList) {
        this.materialList = materialList;
    }
}