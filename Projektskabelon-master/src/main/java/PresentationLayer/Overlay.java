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
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Construction construction = (Construction) session.getAttribute("carportBase");

        ArrayList<Material> ovarlayMaterialList;



        String overlayComponents = request.getParameter("overlayName");
        String right = request.getParameter("right");
        String left = request.getParameter("left");
        String back = request.getParameter("back");
        String noWalls = request.getParameter("noWalls");
        String coverWalls = request.getParameter("coverWalls");
        ArrayList<String> wallsToCover = new ArrayList<>();
        String overlayName=null;
        String color=null;
        if (overlayComponents!=null){
            String[] components= overlayComponents.split(";");
            System.out.println("Data om beklædning fra request: "+overlayComponents);
            overlayName=components[0];
            color=components[1];
           
        }



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
            if (overlayComponents == null || wallsToCover.size() == 0) {
                overlayMSG = "Vælg beklædning og de ønskede vægger ";
            } else {
                construction.setOverlay(overlayName);
                construction.setColor(color);
                construction.setWallSides(wallsToCover);
                construction.setWalls(WallBuilder.createCarportWalls(construction, wallsToCover));
                //OverlayMaterialList(construction, overlayName);
                //request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }
        } else

        if (shedDepth>0 && noWalls!=null){
            if (overlayComponents == null) {
                overlayMSG = "Vælg beklædning for at fortsætte";
            } else {
                construction.setOverlay(overlayName);
                construction.setColor(color);
                //OverlayMaterialList(construction, overlayName);
                //request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }

        } else
        if (shedDepth>0 && coverWalls!=null){
            if (overlayComponents == null || wallsToCover.size() == 0) {
                overlayMSG = "Vælg beklædning og de ønskede vægger ";
            } else {
                construction.setOverlay(overlayName);
                construction.setColor(color);
                construction.setWalls(WallBuilder.createCarportWalls(construction, wallsToCover));
                //OverlayMaterialList(construction, overlayName);
                //request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);
                return targetPage;
            }

        }

        request.setAttribute("overlayMSG", overlayMSG);
        return "overlay";
    }
}

