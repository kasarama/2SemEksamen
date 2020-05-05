package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Material;
import FunctionLayer.OverlayCalculator;
import FunctionLayer.WallBuilder;

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

        String overlayName=request.getParameter("overlayName");





        ArrayList<String> coveredWalls = new ArrayList<>();
        String[] walls = new String[3];

        if(request.getParameter("right")!=null){
            walls[0]="right";
        }
        if(request.getParameter("left")!=null){
            walls[1]="left";
        }
        if(request.getParameter("back")!=null){
            walls[2]="back";
        }
/*

            for (int i = 0; i < 3; i++) {
                if (request.getParameter(walls[i]) != null)
                    System.out.println(request.getParameter(walls[i]));
                    coveredWalls.add(walls[i]);
                System.out.println("added wall on side: " + walls[i]);
            }

*/
        construction.setOverlay(overlayName);
        if (coveredWalls.size()!=0) {
            String[] wallSides = new String[coveredWalls.size()];
            for (int i = 0; i <coveredWalls.size() ; i++) {
                wallSides[i]=coveredWalls.get(i);
            }
        }

        System.out.println("shed walls in construction: "+construction.getShed().getWalls().size());
        System.out.println("construction walls: "+construction.getWalls().size());

        ArrayList<Material> ovarlayMaterialList = OverlayCalculator.shedOverlayMaterialList(construction, overlayName);
        request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);

        if (request.getParameter("justShed") != null) {
            System.out.println("click on ");
            return "customerChoiceResult";
        } else if (request.getParameter("shedOverlay") != null) {
            return "itemList";
        } else
            request.setAttribute("notReady", "The next phase is  not ready yet");
        return "overlay";


    }
}

