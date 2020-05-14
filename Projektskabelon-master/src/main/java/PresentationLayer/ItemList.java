package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class ItemList  extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");
        LogicFacade.setMaterialsForOrder(order);
        request.getServletContext().setAttribute("orderForValidation", order);
        return "itemList";
    }
}
