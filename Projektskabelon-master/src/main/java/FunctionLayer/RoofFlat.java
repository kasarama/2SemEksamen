package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    private ArrayList<Material> tagMaterialList;

    public RoofFlat(int height, int length, int width, int tilt) {
        //Math.round() fordi ellers vil det være 1 grad og den skal mindst være 3 cm pr 100cm i stigning hvilket svarer
        // til 1,7... grader
        super(height, length, width, tiltToDegree,false, tilt);
        tagMaterialList = new ArrayList();
    }

    static int tiltToDegree=(int) Math.round(Math.toDegrees(Math.atan(3.0 / 100.0)));

    @Override
    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }

    @Override
    public void setTagMaterialList(ArrayList<Material> tagMaterialList) {
        this.tagMaterialList = tagMaterialList;
    }

}
