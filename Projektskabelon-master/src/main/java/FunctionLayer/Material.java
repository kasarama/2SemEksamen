package FunctionLayer;

public class Material {
    private int id;
    private String name;
    private int size;
    private String unit;
    private double price;
    private String comment;

    public Material(String name, int size, String unit) {
        this.name = name;
        this.size = size;
        this.unit = unit;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stolpe: " + name + " " + size;
    }
}
