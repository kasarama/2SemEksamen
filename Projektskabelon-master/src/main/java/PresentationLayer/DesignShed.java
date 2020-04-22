package PresentationLayer;

import FunctionLayer.CarportRequest;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Shed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DesignShed extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        CarportRequest carportRequest = (CarportRequest) session.getAttribute("carportRequest");
        int width=0;
        int depth=0;
        Shed shed = new Shed(width, depth);


        return null;
    }
}
