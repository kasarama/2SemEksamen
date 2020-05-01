package PresentationLayer;

import FunctionLayer.*;

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
        int constructionHeight = Integer.parseInt(request.getParameter("constructionHeight"));
        String shedSide = "";

        if (request.getParameter("withShed") != null || request.getParameter("MiaTest")!=null) {

            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
        }

        if (request.getParameter("tooverlay") != null) {

            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
        }

        Carport carportBase = new Carport();
        Roof roofBase;
        if (roofType == 1) {
            roofBase = new RoofPitched(0, carportLength, carportWidth, 0);
        } else {
            roofBase = new RoofFlat(0, carportLength, carportWidth, 0);
        }

        int shedWidth = (carportWidth*shedWidthParameter);
        carportBase.setLength(carportLength);
        carportBase.setWidth(carportWidth);
        carportBase.setRoof(roofBase);
        carportBase.setShed(new Shed(shedWidth, shedDepth, shedSide));
        carportBase.setConstructionHeight(constructionHeight);

        HttpSession session = request.getSession();
        if (session.getAttribute("carportBase") == null) {
            session.setAttribute("carportBase", carportBase);

        }
        request.setAttribute("carportToString", carportBase.toString());

        if(request.getParameter("MiaTest")!=null){
            return "MiaTest";
        }

        if (request.getParameter("tooverlay") != null || request.getParameter("tooverlaynoshed")!=null) {
            return "overlay";
        }else if (roofType == 1) {
            return "designpitchedroof";
        }else if (roofType != 1) {
            return "designflatroof";
        } else return "index";
    }
}
