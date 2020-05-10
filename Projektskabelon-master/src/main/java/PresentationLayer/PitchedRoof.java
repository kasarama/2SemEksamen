package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.LoginSampleException;
import FunctionLayer.RoofSizing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PitchedRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //todo læs data fra designpitchedroof.jsp og brug dem for t designe tag med rejsning

        HttpSession session = request.getSession();
        Construction constructionRequest = (Construction) session.getAttribute("carportRequest");

        RoofSizing roofSizing = new RoofSizing(constructionRequest);

        int[] tiltOptions = roofSizing.pitchDegreesOptionsForCostumerToChoose();

        return "designpitchedroof";
    }
}
