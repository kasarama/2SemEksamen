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

        String overlayName=request.getParameter("overlayName");

        construction.setOverlay(overlayName);
        construction.setWalls(new ArrayList<>());




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


            for (int i = 0; i < 3; i++) {
                if (walls[i] != null)
                    coveredWalls.add(walls[i]);
            }

       if (coveredWalls.size()!=0) {
            String[] wallSides = new String[coveredWalls.size()];
            for (int i = 0; i <coveredWalls.size() ; i++) {
                wallSides[i]=coveredWalls.get(i);
            }
            construction.setWalls(WallBuilder.addConstructionWalls(construction,wallSides));
        }

        ArrayList<Material> ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(construction, overlayName);
        request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);

        if (request.getParameter("walls") != null) {
            return "customerChoiceResult";
        } else if (request.getParameter("shedOverlay") != null) {
            return "itemList";
        } else
            request.setAttribute("notReady", "The next phase is  not ready yet");
        return "overlay";


    }
}

