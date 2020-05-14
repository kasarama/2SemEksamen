package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class FlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Construction carportBase = (Construction) session.getAttribute("carportBase");

        int trapezPladesID = Integer.parseInt(request.getParameter("flatroof"));
        String color = LogicFacade.getColorByMaterialID(trapezPladesID);
        String materialName = LogicFacade.getANameFromMaterialID(trapezPladesID);

        carportBase.getRoof().setColor(color);
        carportBase.getRoof().setCover(materialName);

        session.setAttribute("carportBase", carportBase);

        return "overlay";

    }
}
