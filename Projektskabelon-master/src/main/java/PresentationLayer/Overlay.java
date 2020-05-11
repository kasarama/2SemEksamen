package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * @author Magdalena
 */
public class Overlay extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Construction construction = (Construction) session.getAttribute("carportBase");

        ArrayList<Material> ovarlayMaterialList;


        String overlayName = request.getParameter("overlayName");
        String right = request.getParameter("right");
        String left = request.getParameter("left");
        String back = request.getParameter("back");
        String noWalls = request.getParameter("noWalls");
        String coverWalls = request.getParameter("coverWalls");
        ArrayList<String> wallsToCover = new ArrayList<>();
        if (right != null) {
            wallsToCover.add(right);
        }
        if (left != null) {
            wallsToCover.add(left);

        }
        if (back != null) {
            wallsToCover.add(back);
        }
        construction.setWallSides(wallsToCover);

        int shedDepth = construction.getShedDepth();
        String overlayMSG = "Prøv igen";
        String targetPage = "customerChoiceResult";


        if (shedDepth == 0 && noWalls != null) {
            return targetPage;
        }

        if (shedDepth == 0 && coverWalls != null) {
            if (overlayName == null || wallsToCover.size() == 0) {
                overlayMSG = "Vælg beklædning og de ønskede vægger ";
            } else {
                construction.setOverlay(overlayName);
                construction.setWalls(WallBuilder.createCarportWalls(construction, wallsToCover));
                ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
                request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }
        }

        if (shedDepth>0 && noWalls!=null){
            if (overlayName == null) {
                overlayMSG = "Vælg beklædning for at fortsætte";
            } else {
                construction.setOverlay(overlayName);
                ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
                request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }
        }
        if (shedDepth>0 && coverWalls!=null){
            if (overlayName == null || wallsToCover.size() == 0) {
                overlayMSG = "Vælg beklædning og de ønskede vægger ";
            } else {
                construction.setOverlay(overlayName);
                construction.setWalls(WallBuilder.createCarportWalls(construction, wallsToCover));
                ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
                request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }

        }

        request.setAttribute("overlayMSG", overlayMSG);
        return "overlay";
    }
}

