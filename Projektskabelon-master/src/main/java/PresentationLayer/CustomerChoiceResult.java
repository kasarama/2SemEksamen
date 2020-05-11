package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

// ** Class Not needed because carport attributes are already on session level **

public class CustomerChoiceResult extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));

        int shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
        int shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
        String shedSide = request.getParameter("shedSide");


        HttpSession session = request.getSession();

        request.setAttribute("carpotLength", carportLength);
        request.setAttribute("carportWidth", carportWidth);
        request.setAttribute("roofType", roofType);

        request.setAttribute("shedWidthParameter", shedWidthParameter);
        request.setAttribute("shedDepth", shedDepth);


/*
        carportLength
        carportWidth
        roofType
        shedWidthParameter
        shedDepth
        shedSide
 */



        return "customerChoiceResult";
    }
}
