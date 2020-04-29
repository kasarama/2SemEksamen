package FunctionLayer;

public class Material {

    private int id;
    private String name;
    private int size;
    private String unit;
    private int antal;
    private double price;
    private String comment;
    private String keyword;
    private String category;
    private String picture;


    public Material() {

    }

    public Material(int id, String name, int size, String unit, String keyword, String category) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.unit = unit;
        this.keyword = keyword;
        this.category = category;
    }

    public double cost(){
       return this.size*this.price;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Materiale: " + name + " " + size;
    }
}
