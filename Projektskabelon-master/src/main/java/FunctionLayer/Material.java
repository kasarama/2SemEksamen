package FunctionLayer;

public class Material {

    private int id;
    private String name;
    private int size;//actual
    private int availablesize; //beregned fra Katarzyna metode
    private String unit;
    private int amount;
    private double price;
    private String comment;
    private String keyword;
    private String category;
    private String picture;
 //189 200
    // 254 100 500 skre
    //120  374


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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", unit='" + unit + '\'' +
                ", antal=" + amount +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", keyword='" + keyword + '\'' +
                ", category='" + category + '\'' +
                ", picture='" + picture + '\'' +
                '}';
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


}
