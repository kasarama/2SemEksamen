package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShowEditedConstruction extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int carportLength = Integer.parseInt(request.getParameter("carportLength"));

        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));

        String shedSide = request.getParameter("shedSide");

        int angle = Integer.parseInt(request.getParameter("angle"));

        int tilt = Integer.parseInt(request.getParameter("tilt"));

        double transport = Double.parseDouble(request.getParameter("transport"));


        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");

        order.getConstruction().setCarportLength(carportLength);
        order.getConstruction().setCarportWidth(carportWidth);
        order.getConstruction().getShed().setSide(shedSide);
        order.getConstruction().getRoof().setDegree(angle);
        order.getConstruction().getRoof().setTilt(tilt);
        order.setTransport(transport);
        ArrayList<Wall> shedWalls = WallBuilder.addShedWalls(order.getConstruction());
        ArrayList<Wall> costructionWalls = WallBuilder.createCarportWalls(order.getConstruction(), order.getConstruction().getWallSides());
        order.getConstruction().setWalls(costructionWalls);
        order.getConstruction().getShed().setWalls(shedWalls);




        request.getServletContext().setAttribute("orderForValidation", order);

        return "prepareOffer";
    }
}
