package PresentationLayer;

import FunctionLayer.Construction;
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
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Construction construction= (Construction) session.getAttribute("carportBase");
        String overlayName = construction.getOverlay();
        ArrayList<Material> ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
        request.setAttribute("overlayMaterials", ovarlayMaterialList);
        return "itemList";
    }
}
