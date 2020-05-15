package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class EditOrderPrices extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int carportLength = Integer.parseInt(request.getParameter("carportLength"));

        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));



        int angle = Integer.parseInt(request.getParameter("angle"));

        int tilt = Integer.parseInt(request.getParameter("tilt"));

        double transport = Double.parseDouble(request.getParameter("transport"));


        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");

        order.getConstruction().setCarportLength(carportLength);
        order.getConstruction().setCarportWidth(carportWidth);

        if (order.getConstruction().getShed().getDepth() > 0) {
            String shedSide = request.getParameter("shedSide");
            int shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
            order.getConstruction().getShed().setSide(shedSide);
            order.getConstruction().getShed().setDepth(shedDepth);
            ArrayList<Wall> shedWalls = WallBuilder.addShedWalls(order.getConstruction());
            order.getConstruction().getShed().setWalls(shedWalls);

        }


        order.getConstruction().setConstructionWidth();
        order.getConstruction().setConstructionLength();
        order.getConstruction().getRoof().setDegree(angle);
        order.getConstruction().getRoof().setTilt(tilt);
        order.setTransport(transport);

        ArrayList<Wall> costructionWalls = WallBuilder.createCarportWalls(order.getConstruction(), order.getConstruction().getWallSides());
        order.getConstruction().setWalls(costructionWalls);
        order.setCoverage(order.getDEFAULTCOVERAGE());

        System.out.println("is about to call for adding all  materials");

            LogicFacade.setMaterialsForOrder(order);
            System.out.println("Added materials to order - overlay has size: " + order.getConstruction().getShed().getMaterials().size());


        order.setCost(Economy.ordersCostPrice(order, order.getConstruction()));
        order.setSalePrice(Economy.ordersSalePrice(order, order.getConstruction()));


        request.getServletContext().setAttribute("orderForValidation", order);

        return "prepareOffer";

    }
}