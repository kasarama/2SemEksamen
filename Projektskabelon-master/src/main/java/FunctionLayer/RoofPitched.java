package FunctionLayer;

import java.util.ArrayList;

public class RoofPitched extends Roof {

    ArrayList<Material> tagMaterialList;
    boolean pitched;

    public RoofPitched(int height, int length, int width, int degree) {
        super(height, length, width, degree);
        tagMaterialList = new ArrayList();
        pitched = true;
    }

}
