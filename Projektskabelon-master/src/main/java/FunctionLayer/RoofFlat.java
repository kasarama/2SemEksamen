package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    ArrayList<Material> tagMaterialList;
    boolean pitched;
    private String faldeTilSide;

    public RoofFlat(int height, int length, int width, int degree) {
        super(height, length, width, degree);
        tagMaterialList = new ArrayList();
        pitched = false;
    }

    public String getFaldeTilSide() {
        return faldeTilSide;
    }

    public void setFaldeTilSide(String faldeTilSide) {
        this.faldeTilSide = faldeTilSide;
    }
}
