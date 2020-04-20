package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String length = request.getParameter("length");
        String width = request.getParameter("width");
        String roof = request.getParameter("roof");

        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("roof", roof);

        return "carport";
    }
}
