package PresentationLayer;


import CarportUtil.Initializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mia
 */
public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String destination = request.getParameter("destination");

        return destination;
    }
}
