package FunctionLayer;

import java.util.ArrayList;

public class RoofPitched extends Roof {

    private ArrayList<Material> tagMaterialList;


    public RoofPitched(int height, int length, int width, int degree) {
        super(height, length, width, degree, true);
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

}
