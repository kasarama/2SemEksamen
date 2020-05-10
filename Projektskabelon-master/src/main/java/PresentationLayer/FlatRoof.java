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
        Construction constructionRequest = (Construction) session.getAttribute("carportRequest");

        RoofSizing roofSizing = new RoofSizing(constructionRequest);
        RoofMaterialCalculator rmc = new RoofMaterialCalculator(constructionRequest);
git 
        /*int colourOfTrapezPladesID = ;

        ArrayList<Material> materialList = rmc.flatRoofMaterialsInsert();
        constructionRequest.getRoof().setRoofMaterialList();
*/

        session.setAttribute("carportRequest", constructionRequest);


        //todo læs data fra designeflatroof.jsp og brug dem for t designe fladt tag

        return "overlay";

    }
}
