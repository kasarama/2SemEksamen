package PresentationLayer;

import FunctionLayer.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarportBase extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));
        int shedWidthParameter = 1;
        int shedDepth = 0;
        String shedSide = "";

        if (request.getParameter("withShed") != null) {

            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
        }

        Carport carportBase = new Carport();
        boolean pitchedRoof;
        if (roofType == 1) {
            pitchedRoof = true;
        } else {
            pitchedRoof = false;
        }

        int shedWidth = ShedSizing.shedWidth(carportWidth,shedWidthParameter);
        carportBase.setLength(carportLength);
        carportBase.setWidth(carportWidth);
        carportBase.setRoof(new Roof(0, 0, pitchedRoof));
        carportBase.setShed(new Shed(shedWidth, shedDepth, shedSide));

        HttpSession session = request.getSession();
        if (session.getAttribute("carportBase") == null) {
            session.setAttribute("carportBase", carportBase);

        }
        request.setAttribute("cearportToString", carportBase.toString());

        if(request.getParameter("tooverlay")!=null){
            return "overlay";
        } else
        if (roofType == 1) {
            return "designpitchedroof";
        } else {
            return "designflatroof";
        }
    }

}
