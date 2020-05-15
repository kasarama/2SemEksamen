package PresentationLayer;

import FunctionLayer.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class PitchedRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Construction carportBase = (Construction) session.getAttribute("carportBase");

        String temp = request.getParameter("pitchedroofmaterial");
        String[] tempMateriale = temp.split(";");

        int tagstenID = Integer.parseInt(tempMateriale[0]);
        int variationID = Integer.parseInt(tempMateriale[1]);

        String color = LogicFacade.getColourByVariationID(variationID);
        String materialName = LogicFacade.getANameFromMaterialID(tagstenID);

        carportBase.getRoof().setColor(color);
        carportBase.getRoof().setCover(materialName);

        int degree = Integer.parseInt(request.getParameter("pitchedroofdegree"));
        System.out.println("Graden er: " + degree);

        carportBase.getRoof().setDegree(degree);
        System.out.println("Er der rejsning? " + carportBase.getRoof().getIsPitched());
        System.out.println("Actual degree= " + carportBase.getRoof().getDegree());

        session.setAttribute("carportBase", carportBase);

        //todo læs data fra designpitchedroof.jsp og brug dem for t designe tag med rejsning

        return "overlay";
    }
}
