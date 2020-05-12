package FunctionLayer;

import java.util.ArrayList;

public class RoofPitched extends Roof {

    private ArrayList<Material> roofMaterialList;



    public RoofPitched(int height, int length, int width, int degree) {
        super(height, length, width, degree, true, 0);
        roofMaterialList = new ArrayList();
    }


    @Override
    public ArrayList<Material> getRoofMaterialList() {
        return roofMaterialList;
    }

    @Override
    public void setRoofMaterialList(ArrayList<Material> roofMaterialList) {
        this.roofMaterialList = roofMaterialList;
    }


}
