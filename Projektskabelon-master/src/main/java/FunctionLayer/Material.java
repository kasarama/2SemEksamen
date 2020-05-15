package FunctionLayer;

import java.util.Objects;

public class Material {

    private int id;
    private String name;
    private int size;//actual
    private int availablesize;
    private int width;
    private int thickness;
    private String unit;
    private int amount;
    private double price;
    private String comment;
    private String keyword;
    private String category;
    private String picture;
    private double spending; // bruges til beregninger af beklædning
    private String color;


    public Material() {

    }
    // Bruges i MaterialMapper
    public Material(int id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }
    public Material(int id, int integer) {
        this.id = id;
        this.size = integer;
        this.width = integer;
        this.thickness = integer;
    }
    public Material(int id, double price) {
        this.id = id;
        this.price = price;
    }
    public Material(int id, String name, int integer) {
        this.id = id;
        this.name = name;
        this.width = integer;
        this.thickness = integer;
    }

    public Material(int id, String name, int size, String unit, String keyword, String category) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.unit = unit;
        this.keyword = keyword;
        this.category = category;
    }
    //...........Constructor for Magda's Test.................................//
    public Material(String name, int size, int availablesize, String unit, int amount, String comment) {
        this.name = name;
        this.size = size;
        this.availablesize = availablesize;
        this.unit = unit;
        this.amount = amount;
        this.comment = comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;

        return
                getAvailablesize() == material.getAvailablesize() &&
                getName().equals(material.getName()) &&
                getUnit().equals(material.getUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAvailablesize(), getUnit());
    }

    public double getSpending() {
        return spending;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }

    public int getAvailablesize() {
        return availablesize;
    }

    public void setAvailablesize(int availablesize) {
        this.availablesize = availablesize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

  /*  @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", comment=" + comment +
                ", amount=" + amount + " " +unit +
                '}';
    }
*/

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", availablesize=" + availablesize +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
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
