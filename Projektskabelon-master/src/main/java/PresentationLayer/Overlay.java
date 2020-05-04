package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Material;
import FunctionLayer.OverlayCalculator;

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

        int overlayID = Integer.parseInt(request.getParameter("overlayID"));

        ArrayList<String> coveredWalls = new ArrayList<>();
        String[] walls = {"left", "right", "back"};

        for (int i = 0; i < 3; i++) {
            if (request.getParameter(walls[i]) != null)
                coveredWalls.add(walls[i]);
        }
        HttpSession session = request.getSession();

        Construction construction = (Construction) session.getAttribute("carportBase");

        ArrayList<Material> ovarlayMaterialList = OverlayCalculator.shedOverlayMaterialList(construction);
        request.setAttribute("ovarlayMaterialList", ovarlayMaterialList);

        if (request.getParameter("shedOverlay") != null) {
            return "materialsBill";
        } else {
            request.setAttribute("notReady", "The next phase is  not ready yet");
            return "overlay";
        }

    }
}
