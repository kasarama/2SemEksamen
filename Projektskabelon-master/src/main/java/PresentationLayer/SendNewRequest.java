package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Magdalena
 */
public class SendNewRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {



        HttpSession session = request.getSession();
        Construction construction = (Construction) session.getAttribute("carportBase");

        String email = (String) session.getAttribute("email");
        Order order = new Order();
        order.setConstruction(construction);
        order.setEmail(email);

        LogicFacade.sendNewRequest(order);
        session.setAttribute("carportBase", null);

        request.setAttribute("newRequestMSG", "Dine forespørgelse er blevet sendt til validering");
        System.out.println("MSG on request");
        return "customerPage";
    }
}
