package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.MaterialMapper.getNameFromMaterialID;

public class FlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Construction constructionRequest = (Construction) session.getAttribute("carportBase");


        RoofSizing roofSizing = new RoofSizing(constructionRequest);
        RoofMaterialCalculator rmc = new RoofMaterialCalculator(constructionRequest);
        int colourOfTrapezPladesID = Integer.parseInt(request.getParameter("roofMaterial"));
        String materialName = LogicFacade.getANameFromMaterialID(colourOfTrapezPladesID);
        ArrayList<Material> materialList = rmc.flatRoofMaterialsInsert(materialName);
        constructionRequest.getRoof().setRoofMaterialList(materialList);

/*<<<<<<< HEAD
=======
        int[] tiltOptions = roofSizing.pitchDegreesOptionsForCostumerToChoose();

        request.setAttribute("height", height);
        request.setAttribute("tilt", tilt);

        constructionRequest.getRoof().setHeight(height);
        constructionRequest.getRoof().setDegree(tilt);

>>>>>>> lifeOfOrder*/
        session.setAttribute("carportBase", constructionRequest);


        //todo læs data fra designeflatroof.jsp og brug dem for t designe fladt tag

        return "overlay";

    }
}
