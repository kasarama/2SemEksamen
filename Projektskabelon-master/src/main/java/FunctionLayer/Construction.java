package FunctionLayer;

import java.util.ArrayList;

public class Construction {
    private int carportWidth;
    private int carportLength;
    private int constructionLength;
    private int constructionWidth;
    private Shed shed;
    private Roof roof;
    private int constructionHeight;
    private ArrayList<Material> fundamentMaterials; // stolper, rem, spær, over- og under- stern plus de metal elementer
    private double cost; //samlet pris på hver material fra hver liste
    private double salePrice; //cost pris plus VAT eller + det employee vil tilføje eller give som rabat


    public Construction() {
        this.fundamentMaterials = new ArrayList<>();
    }

    public int getConstructionLength() {
        return constructionLength;
    }

    public void setConstructionLength(int constructionLength) {
        this.constructionLength = constructionLength;
    }

    public int getConstructionWidth() {
        return constructionWidth;
    }

    public void setConstructionWidth(int constructionWidth) {
        this.constructionWidth = constructionWidth;
    }

    public void setFundamentMaterials(ArrayList<Material> fundamentMaterials) {
        this.fundamentMaterials = fundamentMaterials;
    }

    public void addConstructionMaterial (Material material){
        fundamentMaterials.add(material);
    }

    public int getConstructionHeight() {
        return constructionHeight;
    }

    public void setConstructionHeight(int constructionHeight) {
        this.constructionHeight = constructionHeight;
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

    public int getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(int carportWidth) {
        this.carportWidth = carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(int carportLength) {
        this.carportLength = carportLength;
    }

    public int getShedDepth() {
        return shed.getDepth();
    }

    public ArrayList<Material> getFundamentMaterials() {
        return fundamentMaterials;
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
                "width=" + carportWidth +
                ", length=" + carportLength +
                ", shed=" + shed.getWidth()+"x"+shed.getDepth()+shed.getSide() +
                ", pitchedroof? :" + roof.getIsPitched() +
                '}';
    }
}