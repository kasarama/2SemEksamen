package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    ArrayList<Material> tagMaterialList;
    boolean pitched;

    public RoofFlat(int height, int length, int width, int degree) {
        super(height, length, width, degree);
        tagMaterialList = new ArrayList();
        pitched = false;
    }

}
