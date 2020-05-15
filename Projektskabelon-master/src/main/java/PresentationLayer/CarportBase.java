package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class CarportBase extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));
        int shedWidthParameter = 0;
        int shedDepth = 0;
        int constructionHeight = Integer.parseInt(request.getParameter("constructionHeight"));
        String shedSide = "";
        final int RAISING = 3;
        final int POSTWIDTH = 100;
        int shedWidth = 0;


        Construction constructionBase = new Construction();

        constructionBase.setConstructionHeight(constructionHeight);
        constructionBase.setCarportLength(carportLength);
        constructionBase.setCarportWidth(carportWidth);

        Roof roofBase;
        if (roofType == 1) {
            roofBase = new RoofPitched(0, carportLength, carportWidth, 0);
            roofBase.setPitched(true);
        } else {
            roofBase = new RoofFlat(0, carportLength, carportWidth, RAISING);
        }


        constructionBase.setRoof(roofBase);

        Shed shed = new Shed(shedWidth, shedDepth, shedSide);
        shed.setWalls(new ArrayList<>());
        constructionBase.setShed(shed);
        if (request.getParameter("withShed") != null) {
            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
            if (shedWidthParameter == 1) {
                shedWidth = (int) ((carportWidth / shedWidthParameter));
            } else if (shedWidthParameter == 2) {
                shedWidth = (int) ((carportWidth / shedWidthParameter) + 0.5 * POSTWIDTH);

            } else {
                throw new LoginSampleException("Kunne ikke forstå inputtet for tag parameter CarportBase.java linie 47");
            }


            shed.setWidth(shedWidth);
            shed.setDepth(shedDepth);
            shed.setSide(shedSide);
            ArrayList<Wall> walls = WallBuilder.addShedWalls(constructionBase);
            shed.setWalls(walls);
            constructionBase.setShed(shed);
        }

        constructionBase.setConstructionWidth();
        constructionBase.setConstructionLength();

        //Roof roofBase;
        if (roofType == 1) {
            roofBase = new RoofPitched(0, constructionBase.getConstructionLength(), constructionBase.getConstructionWidth(), 0);
            roofBase.setPitched(true);
        } else {
            roofBase = new RoofFlat(0, constructionBase.getConstructionLength(), constructionBase.getConstructionWidth(), RAISING);
        }
        constructionBase.setRoof(roofBase);


        HttpSession session = request.getSession();
        if (session.getAttribute("carportBase") == null) {
            session.setAttribute("carportBase", constructionBase);

        }

        if (roofType == 1) {
            return "designpitchedroof";
        } else if (roofType == 0) {

            return "designflatroof";

        } else {

            request.setAttribute("error", "kune ikke definere tag type");
            return "index";
        }
    }
}