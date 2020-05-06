package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    private ArrayList<Material> tagMaterialList;
    private int tilt;

    public RoofFlat(int height, int length, int width, int tilt) {
        //Math.round() fordi ellers vil det være 1 grad og den skal mindst være 3 cm pr 100cm i stigning hvilket svarer
        // til 1,7... grader
        super(height, length, width, (int) Math.round(Math.toDegrees(Math.atan(3.0 / 100.0))), false);
        tagMaterialList = new ArrayList();
    }

    @Override
    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }

    @Override
    public void setTagMaterialList(ArrayList<Material> tagMaterialList) {
        this.tagMaterialList = tagMaterialList;
    }

    /*//Constructor used by Magda
    public RoofFlat(int height, int length, int width, int degree, boolean pitched) {
        super(height, length, width, degree, pitched);
    }
*/

    public int getTilt() {
        return tilt;
    }

    public void setTilt(int tilt) {
        this.tilt = tilt;
    }
}
