package FunctionLayer;

import java.util.ArrayList;

public class Carport {
    private int width;
    private int length;
    private Shed shed;
    private Roof roof;
    private ArrayList<Material> tagMaterialList;
    private ArrayList<Material> woodMaterialList;
    private ArrayList<Material> otherMaterialList;
    private double cost;
    private double salePrice;

    public Carport() {
        this.woodMaterialList= new ArrayList<>();
        this.otherMaterialList = new ArrayList<>();
        this.tagMaterialList = roof.getTagMaterialList();
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
        return shed.getDepth();
    }

    public void setShedDepth(int shedDepth) {
        shed.setDepth(shedDepth);
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

    @Override
    public String toString() {
        return "Carport{" +
                "width=" + width +
                ", length=" + length +
                ", shed=" + shed.getWidth()+"x"+shed.getDepth()+shed.getSide() +
                ", pitchedroof? :" + roof.isPitched() +
                '}';
    }
}