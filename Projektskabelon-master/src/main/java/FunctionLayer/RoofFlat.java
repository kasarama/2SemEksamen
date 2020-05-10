package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    private ArrayList<Material> roofMaterialList;

    public RoofFlat(int height, int length, int width, int tilt) {
        //Math.round() fordi ellers vil det være 1 grad og den skal mindst være 3 cm pr 100cm i stigning hvilket svarer
        // til 1,7... grader
        super(height, length, width, tiltToDegree,false, tilt);
        roofMaterialList = new ArrayList();
    }

    static int tiltToDegree=(int) Math.round(Math.toDegrees(Math.atan(3.0 / 100.0)));

    @Override
    public ArrayList<Material> getRoofMaterialList() {
        return roofMaterialList;
    }

    @Override
    public void setRoofMaterialList(ArrayList<Material> roofMaterialList) {
        this.roofMaterialList = roofMaterialList;
    }

}
