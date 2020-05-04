package FunctionLayer;

import java.util.ArrayList;

public class RoofFlat extends Roof {

    private ArrayList<Material> tagMaterialList;
    private double roofRaisedCmPrCmLength = 3.0/100.0; //TODO - Final fordi det er en konstant?
    private int roofTiltInMiliMeters = 3;

    public RoofFlat(int height, int length, int width) {
        //Math.round() fordi ellers vil det være 1 grad og den skal mindst være 3 cm pr 100cm i stigning hvilket svarer
        // til 1,7... grader
        super(height, length, width, (int) Math.round(Math.toDegrees(Math.atan(3.0 / 100.0))), false);
        tagMaterialList = new ArrayList();
    }

    //Beregner af fladt tags hældning i grader
    public int flatRoofDegreeCalculator() {
        int roofTiltDegree = (int) Math.round(Math.toDegrees(Math.atan(roofRaisedCmPrCmLength))) ;
        return roofTiltDegree;
    }

    public double getRoofRaisedCmPrCmLength() {
        return roofRaisedCmPrCmLength;
    }

    public int getRoofTiltInMiliMeters() {
        return roofTiltInMiliMeters;
    }

    @Override
    public ArrayList<Material> getTagMaterialList() {
        return tagMaterialList;
    }

    @Override
    public void setTagMaterialList(ArrayList<Material> tagMaterialList) {
        this.tagMaterialList = tagMaterialList;
    }



}
