package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.Material;
import FunctionLayer.OverlayCalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Overlay extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int overlayID= Integer.parseInt(request.getParameter("overlayID"));

        ArrayList<String> coveredWalls =new ArrayList<>();
        String[] walls ={"left","right","back"};

        for (int i = 0; i < 3; i++) {
            if (request.getParameter(walls[i])!=null)
                coveredWalls.add(walls[i]);
        }
        HttpSession session= request.getSession();

        Carport carport = (Carport) session.getAttribute("carportBase");

        ArrayList<Material> ovarlayMaterialList=OverlayCalculator.materialList(carport);
        return null;
    }
}
