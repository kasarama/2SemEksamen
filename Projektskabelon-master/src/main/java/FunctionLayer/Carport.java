package FunctionLayer;

import java.util.ArrayList;

public class Carport {
    private int width;
    private int length;
    private Shed shed;
    private Roof roof;
    private int constructionHeight;
    private ArrayList<Material> constructionMaterials;
    private ArrayList<Material> roofMaterials;
    private ArrayList<Material> shedMaterials;
    private ArrayList<Material> overlayMaterials;
    private double cost;
    private double salePrice;

    public int getConstructionHeight() {
        return constructionHeight;
    }

    public void setConstructionHeight(int constructionHeight) {
        this.constructionHeight = constructionHeight;
    }



    public Carport() {

        this.constructionMaterials= new ArrayList<>();
        this.roofMaterials = new ArrayList<>();
        this.shedMaterials = new ArrayList<>();
        this.overlayMaterials = new ArrayList<>();

    }

    public void addConstructionMaterial (Material material){
        constructionMaterials.add(material);
    }
    public void addRoofMaterial (Material material){
        roofMaterials.add(material);
    }
    public void addShedMaterial (Material material){
        shedMaterials.add(material);
    }
    public void addOverlayMaterials (Material material){
        overlayMaterials.add(material);
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

    public ArrayList<Material> getConstructionMaterials() {
        return constructionMaterials;
    }

    public ArrayList<Material> getRoofMaterials() {
        return roofMaterials;
    }

    public ArrayList<Material> getShedMaterials() {
        return shedMaterials;
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