package PresentationLayer;

import FunctionLayer.CarportBuilder;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class FindMaterial extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        // Her skal der findes de materialer og indsættes i DB i itemlist

        int length = Integer.parseInt(request.getParameter( "length" ));
        int width = Integer.parseInt(request.getParameter( "width" ));

        CarportBuilder carportBuilder = new CarportBuilder();
        ArrayList<Material> materials = new ArrayList<>();

     // Stolper
        int stolpeAntal = carportBuilder.posts(length, width);
            Material stolpe = LogicFacade.getMaterial("Stolpe");
     // Rem
        int remAntal = carportBuilder.rem(length, width);
            Material rem = LogicFacade.getMaterial("Rem");
     // Bræddebolte
        int bræddebolteAntal = carportBuilder.carriageBolts();
            Material bræddebolte = LogicFacade.getMaterial("Bræddebolte");
     // Spær
        int spærAntal = carportBuilder.raft();
            Material spær = LogicFacade.getMaterial("Spær");
     // Firkantskiver
        int firkantskiverAntal = carportBuilder.squares();
            Material firkantskiver = LogicFacade.getMaterial("Firkantskiver");
     // Universalbeslag
        int universalbeslagAntal = carportBuilder.universalBrackets();
            Material universalbeslag = LogicFacade.getMaterial("Universalbeslag");
     // Beslagskruer
        int beslagskruerAntal = carportBuilder.bracketScrews();
            Material beslagskruer = LogicFacade.getMaterial("Beslagskruer");
     // Hulbånd
        int hulbåndAntal = carportBuilder.perforatedBand;
            Material hulbånd = LogicFacade.getMaterial("Hulbånd");
     // Skruer
        int skrueAntal = carportBuilder.screws();
            Material skruer = LogicFacade.getMaterial("Skruer");
     // Trapezplader
        int tagpladerAntal = carportBuilder.roof();
            Material tagplader = LogicFacade.getMaterial("Trapezplader");
     // Bundskruer
        int bundskruerAntal = carportBuilder.roof();
            //Material tagplader = LogicFacade.getMaterial("Trapezplader");


        HttpSession session = request.getSession();

        session.setAttribute( "stolpeAntal", stolpeAntal );
        session.setAttribute( "stolpeInfo", stolpe );


        return "finishedcarport";
    }
}
