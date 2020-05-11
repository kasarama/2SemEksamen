package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author Magdalena
 */
public class NewRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //todo sletter alle data fra carportRequest som er gemt på session

        HttpSession session = request.getSession();
        session.setAttribute("carportBase", null);
        return "carportBase";
    }
}
