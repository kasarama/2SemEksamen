package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    private ArrayList<Material> tagMaterialList;
    private int roofTiltDegree;
    private double roofRaisedCmPrCmLength = 3.0 / 100.0; //TODO - Final fordi det er en konstant?

    public RoofFlat(int height, int length, int width) {
        super(height, length, width, 0, false);
        super.setDegree(roofTiltDegree);
        tagMaterialList = new ArrayList();
    }


    //Beregner af fladt tags hældning i grader
    public int flatRoofDegreeCalculator() {
        roofTiltDegree = (int) Math.atan(roofRaisedCmPrCmLength);
        return roofTiltDegree;
    }

    public double getRoofRaisedCmPrCmLength() {
        return roofRaisedCmPrCmLength;
    }

    @Override
    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }

    @Override
    public void setTagMaterialList(ArrayList<Material> tagMaterialList) {
        this.tagMaterialList = tagMaterialList;
    }

    //Constructor used by Magda
    public RoofFlat(int height, int length, int width, int degree, boolean pitched) {
        super(height, length, width, degree, pitched);
    }

}
