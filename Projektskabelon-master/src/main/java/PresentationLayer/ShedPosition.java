package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.ShedSizing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Purpose: to read and save data(position) chosen by Customer user on shedposition.jsp as an attribute of a Shed object of a Carport
 *
 * @author Magdalena
 */
public class ShedPosition extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Carport carportRequest = (Carport) session.getAttribute("carportRequest");
        boolean roofType = carportRequest.getRoof().isPitched();
        String position = request.getParameter("position");
        carportRequest.getShed().setSide(position);
        String possitionMsg="";
        switch (position){
            case "BL":
                possitionMsg="Skuren liger i bagsiden til venstre";
                break;
            case "BR" :
                possitionMsg="Skuren liger i bagsiden til højre";
                break;
            case "SL":
                possitionMsg="Skuren liger på siden til venstre";
                break;
            case "SR":
                possitionMsg="Skuren liger i bagsiden til højre";
                break;
            default:
                possitionMsg="Jeg kunne ikke forstå, hvor skuren skal ligge...";
        }


        session.setAttribute("carportRequest", carportRequest);
        request.setAttribute("possitionMsg", possitionMsg);

        ArrayList<ArrayList> possibleSizes = ShedSizing.possibleSizes(carportRequest, position);
        request.setAttribute("possibleSizes", possibleSizes);

        String page="";
        if(position.equals("null") && !roofType){
            page="designflatroof";
        } else if(position.equals("null") && roofType) {
        } else {
            page="designshed";
        }
        return page;
    }
}
