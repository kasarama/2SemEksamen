package PresentationLayer;

import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Validate extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        ArrayList<Order> orders = (ArrayList<Order>) request.getServletContext().getAttribute("newRequestsList");

        Order order = new Order();
        for (Order tmp : orders) {
            if (tmp.getOrderID()==orderID) {
                order=tmp;
            }
            request.setAttribute("orderForValidation", order);
        }
        return "validateRequest";
    }
}
