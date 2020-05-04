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

        String overlayName=request.getParameter("overlayName");
        System.out.println(overlayName);


        ArrayList<String> coveredWalls = new ArrayList<>();
        String[] walls = {"left", "right", "back"};

        for (int i = 0; i < 3; i++) {
            if (request.getParameter(walls[i]) != null)
                coveredWalls.add(walls[i]);
        }

        HttpSession session = request.getSession();

        Construction construction = (Construction) session.getAttribute("carportBase");
        construction.setOverlay(overlayName);
        if (coveredWalls.size()!=0) {
            String[] wallSides = (String[]) coveredWalls.toArray();
            construction.setWalls(WallBuilder.addCarportWalls(construction, wallSides));
        }

        ArrayList<Material> ovarlayMaterialList = OverlayCalculator.shedOverlayMaterialList(construction, overlayName);
        request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);

        if (request.getParameter("justShed") != null) {
            return "customerChoiceResult";
        } else if (request.getParameter("shedOverlay") != null) {
            return "itemList";
        } else
            request.setAttribute("notReady", "The next phase is  not ready yet");
        return "overlay";


    }
}

