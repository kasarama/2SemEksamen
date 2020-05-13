package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendNewOffer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //todo read order from aplication scoop, call a method from FunctionLayer that will send it further to
        // OrderMapper and sæt Order on aplicationScoop as null
        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");
        LogicFacade.sendOffer(order);
        request.getServletContext().setAttribute("orderForValidation",null);
        request.setAttribute("orderMSG","Tilbud er blevet sendt til "+ order.getEmail());

        return "employeePage";
    }
}
