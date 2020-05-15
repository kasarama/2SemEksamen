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
    private ArrayList<Wall> walls;
    private String overlay;
    private ArrayList<String> wallSides;
    private String color;
    final private int POSTWIDTH = 100;


    public Construction(int carportWidth, int carportLength, int constructionLength, int constructionWidth,
                        Shed shed, Roof roof, int constructionHeight, double cost, double salePrice,
                        String overlay, ArrayList<String> wallSides, String color) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.constructionLength = constructionLength;
        this.constructionWidth = constructionWidth;
        this.shed = shed;
        this.roof = roof;
        this.constructionHeight = constructionHeight;
        this.cost = cost;
        this.salePrice = salePrice;
        this.overlay = overlay;
        this.wallSides = wallSides;
        this.color = color;
    }


    public Construction() {
        this.fundamentMaterials = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.wallSides = new ArrayList<>();
    }

    public int getConstructionLength() {
        return constructionLength;
    }

    public void setCarportWidth() {
        if(this.shed.getDepth()==0){
            this.constructionLength=this.carportLength;
        } else
        this.constructionLength = this.carportLength+this.shed.getDepth()-POSTWIDTH;
    }

    public int getConstructionWidth() {
        return constructionWidth;
    }

    public void setCarportLength() {
        this.constructionWidth = this.carportWidth+150;
    }

    public void setFundamentMaterials(ArrayList<Material> fundamentMaterials) {
        this.fundamentMaterials = fundamentMaterials;
    }

    public void addConstructionMaterial(Material material) {
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

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void setWalls(ArrayList<Wall> walls) {
        this.walls = walls;
    }

    public String getOverlay() {
        return overlay;
    }

    public void setOverlay(String overlay) {
        this.overlay = overlay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getWallSides() {
        return wallSides;
    }

    public void setWallSides(ArrayList<String> wallSides) {
        this.wallSides = wallSides;
    }

    public ArrayList<String> wallsToDanish()
    {
        ArrayList<String> wallsToDanish = new ArrayList();
        for (String side : this.wallSides) {
            if (side.equals("left")){
                wallsToDanish.add("venstre");
            }
            if (side.equals("right")){
                wallsToDanish.add("højre");
            }
            if (side.equals("back")){
                wallsToDanish.add("bagside");
            }
        }
        return wallsToDanish;
    }


    /*@Override
    public String toString() {
        return "Carport{" +
                "width=" + carportWidth +
                ", length=" + carportLength +
                ", shed=" + shed.getWidth()+"x"+shed.getDepth()+shed.getSide() +
                ", pitchedroof? :" + roof.getIsPitched() +
                '}';
    }*/
}