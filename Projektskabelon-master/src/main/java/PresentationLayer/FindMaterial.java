package PresentationLayer;

import FunctionLayer.CarportBuilder;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindMaterial extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        // Her skal der findes de materialer og indsættes i DB i itemlist

        int length = Integer.parseInt(request.getParameter( "length" ));
        int width = Integer.parseInt(request.getParameter( "width" ));

        CarportBuilder carportBuilder = new CarportBuilder();

        // Stolper
        int posts = carportBuilder.posts(length, width);

        String stolpe = String.valueOf(LogicFacade.getMaterial("Stolpe"));

        System.out.println(stolpe);

        HttpSession session = request.getSession();

        session.setAttribute( "posts", posts );
        session.setAttribute( "stolpe", stolpe );


        return "finishedcarport";
    }
}
