package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Shed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Purpose  to read and save data chosen by Customer user on designshed.jsp as attributes of a Shed object of a Carport
 * @author Magdalena
 */
public class DesignShed extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Carport carportRequest = (Carport) session.getAttribute("carportRequest");

        int width = Integer.parseInt(request.getParameter("shedWidth"));
        int depth = Integer.parseInt(request.getParameter("shedDepth"));
        carportRequest.getShed().setWidth(width);
        carportRequest.getShed().setDepth(depth);
        session.setAttribute("carportRequest", carportRequest);
        String page = "";
        if (carportRequest.getRoof().isPitchedRoof()) {
            page = "designpitchedroof";
        } else {
            page = "designflatroof";
        }
        return page;
    }
}
