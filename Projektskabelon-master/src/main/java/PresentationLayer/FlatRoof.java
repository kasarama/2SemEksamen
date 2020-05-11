package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.LoginSampleException;
import FunctionLayer.RoofSizing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Construction constructionRequest = (Construction) session.getAttribute("carportBase");


        int height = Integer.parseInt(request.getParameter("height"));
        int tilt = Integer.parseInt(request.getParameter("tilt"));

        RoofSizing roofSizing = new RoofSizing(constructionRequest);

        int[] tiltOptions = roofSizing.pitchDegreesOptionsForCostumerToChoose();

        request.setAttribute("height", height);
        request.setAttribute("tilt", tilt);

        constructionRequest.getRoof().setHeight(height);
        constructionRequest.getRoof().setDegree(tilt);

        session.setAttribute("carportBase", constructionRequest);


        //todo læs data fra designeflatroof.jsp og brug dem for t designe fladt tag

        return "designflatroof";

    }
}
