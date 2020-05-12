package FunctionLayer;

import java.util.ArrayList;

public class UpdateOrder {
    public static Order updateOrderData(Order order) throws LoginSampleException {


        ArrayList<Material> ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(
                order.getConstruction(), order.getConstruction().getOverlay());
        System.out.println(ovarlayMaterialList.size() + "elements on material list for overlay");
        order.getConstruction().getShed().setMaterials(ovarlayMaterialList);


        //................Materials for roof...........//
        //todo create ArrayList with materials for roof and set it on order.construction.roof

        ArrayList<Material> roofMaterialList = new ArrayList<>(); // = call the method her
        order.getConstruction().getRoof().setTagMaterialList(roofMaterialList);


        //................Materials for construction...........//
        //todo create ArrayList with materials for construction and set it on order.construction

        ArrayList<Material> constructionMaterialList = new ArrayList<>(); // = call the method here
        order.getConstruction().setFundamentMaterials(constructionMaterialList);
Order order1 = order;

        return order1;
    }
}
