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
        System.out.println(roofType+"rooftype");
        int shedWidthParameter = 0;
        int shedDepth = 0;
        int constructionHeight = Integer.parseInt(request.getParameter("constructionHeight"));
        String shedSide = "";
        final int RAISING=3;

        if (request.getParameter("withShed") != null){

            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
        }

        if (request.getParameter("tooverlay") != null) {

            shedWidthParameter = Integer.parseInt(request.getParameter("shedWidthParameter"));
            shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            shedSide = request.getParameter("shedSide");
        }

        Construction constructionBase = new Construction();

        constructionBase.setConstructionHeight(constructionHeight);
        constructionBase.setCarportLength(carportLength);
        constructionBase.setCarportWidth(carportWidth);

        Roof roofBase;
        if (roofType == 1) {
            roofBase = new RoofPitched(0, carportLength, carportWidth, 0);
            roofBase.setPitched(true);
        } else {
            roofBase = new RoofFlat(0, carportLength, carportWidth, RAISING,false);
        }

        constructionBase.setRoof(roofBase);

        int shedWidth = (carportWidth*shedWidthParameter);

        Shed shed = new Shed(shedWidth, shedDepth, shedSide);
        constructionBase.setShed(shed);
        ArrayList<Wall> walls=WallBuilder.addShedWalls(constructionBase);
        shed.setWalls(walls);
        constructionBase.setShed(shed);




        HttpSession session = request.getSession();
        if (session.getAttribute("carportBase") == null) {
            session.setAttribute("carportBase", constructionBase);

        }
        request.setAttribute("carportToString", constructionBase.toString());

        System.out.println(constructionBase.toString()+"raising. "+constructionBase.getRoof().getDegree());

        if (roofType == 1) {
            return "designpitchedroof";
        }else if (roofType ==0) {
            return "designflatroof";
        } else {
            request.setAttribute("error", "kune ikke definere tag type");
            return "index";}
    }
}
