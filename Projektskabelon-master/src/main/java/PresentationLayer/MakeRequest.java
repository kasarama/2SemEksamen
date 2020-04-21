package PresentationLayer;

import FunctionLayer.CarportRequest;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));
        int isShed = Integer.parseInt(request.getParameter("isShed"));

        CarportRequest carportRequest = new CarportRequest(length, width, isShed, roofType);

        if (isShed != 0) {
            return "sheddisigner";
        } else {
            if (roofType != 0) {
                return "designpitchedroof";
            } else {
                return "designflatroof";
            }
        }

    }
}