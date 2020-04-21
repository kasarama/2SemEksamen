package PresentationLayer;

import FunctionLayer.CarportBuilder;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

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
        Material stolpe = LogicFacade.getMaterial("Stolpe");
        Material rem = LogicFacade.getMaterial("Rem");


        HttpSession session = request.getSession();

        session.setAttribute( "stolpeAntal", posts );
        session.setAttribute( "stolpeInfo", stolpe );


        return "finishedcarport";
    }
}
