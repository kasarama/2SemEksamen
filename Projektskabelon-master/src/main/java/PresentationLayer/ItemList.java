package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.OverlayMaterialCalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class ItemList  extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Construction construction= (Construction) session.getAttribute("carportBase");

        //................Materials for construction...........//
        //todo create ArrayList with materials for construction and set it on request

        ArrayList<Material> constructionMaterialList = new ArrayList<>(); // = call the method her
        request.setAttribute("constructionMaterials", constructionMaterialList);


        //................Materials for roof...........//
        //todo create ArrayList with materials for roof and set it on request

        ArrayList<Material> roofMaterialList = new ArrayList<>(); // = call the method her
        request.setAttribute("roofMaterials", constructionMaterialList);

        //................Materials for overlay...........//
        String overlayName = construction.getOverlay();
        ArrayList<Material> ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
        request.setAttribute("overlayMaterials", ovarlayMaterialList);





        return "itemList";
    }
}
