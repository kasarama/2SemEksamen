package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.RoofSizing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Carport carportRequest = (Carport) session.getAttribute("carportRequest");


        int height = Integer.parseInt(request.getParameter("height"));
        int tilt = Integer.parseInt(request.getParameter("tilt"));

        RoofSizing roofSizing = new RoofSizing(carportRequest);

        int[] tiltOptions = roofSizing.pitchDegreesOptionsForCostumerToChoose();

        request.setAttribute("height", height);
        request.setAttribute("tilt", tilt);

        carportRequest.getRoof().setHeight(height);
        carportRequest.getRoof().setDegree(tilt);

        session.setAttribute("carportRequest", carportRequest);


        //todo læs data fra designeflatroof.jsp og brug dem for t designe fladt tag

        return "designflatroof";

    }
}
