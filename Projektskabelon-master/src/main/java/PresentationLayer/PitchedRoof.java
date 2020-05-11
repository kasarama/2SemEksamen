package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class PitchedRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Construction constructionBase = (Construction) session.getAttribute("carportBase");

        RoofSizing roofSizing = new RoofSizing(constructionBase);
        RoofMaterialCalculator rmc = new RoofMaterialCalculator(constructionBase);

        int degreeRoof = Integer.parseInt(request.getParameter("degree"));

        int roofHeigth = roofSizing.roofHeight(true,constructionBase.getConstructionLength(),
                constructionBase.getConstructionWidth());
        Roof roof = constructionBase.getRoof();
        roof.setHeight(roofHeigth);
        roof.setDegree(degreeRoof);

        int colourOfTrapezPladesID = Integer.parseInt(request.getParameter("roofMaterial"));
        String materialName = LogicFacade.getANameFromMaterialID(colourOfTrapezPladesID);
        ArrayList<Material> materialList = rmc.flatRoofMaterialsInsert(materialName);
        constructionBase.getRoof().setRoofMaterialList(materialList);

        session.setAttribute("carportBase", constructionBase);

        //todo læs data fra designpitchedroof.jsp og brug dem for t designe tag med rejsning
        // (gælder også materiale)

        return "overlay";
    }
}
