package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.ConstructionSizeCalculator;
import FunctionLayer.Order;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Drawing extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Order order = (Order) request.getServletContext().getAttribute("orderForValidation");

        int width = (order.getConstruction().getConstructionLength()/10);
        int height = (order.getConstruction().getConstructionLength()/10);

        // Grundet tegningens størrelses, deles width og height med 2 så tegningen ikke bliver for stor
        if (width>500 || height>500){
            width = width/2;
            height = height/2;
        }

        String viewBox2 = "-50, -10, " + (width+100) + ", " + (height+50);
        Svg svg = new Svg(width+100, height+50, viewBox2, 0, 0);

        // Baggrund:
        svg.addRect(0,0,height,width);

        // Remme:
        svg.addRect(0,30,3,width);
        svg.addRect(0,height-30,3,width);
        if (height > 600){
            svg.addRect(0,height/2,3,width);
        }

        // Spær:
            // metode roofSpaerAmount  --  hvordan skal jeg køre metoden roofSpaerAmount gange?
            // Længde/roofSpaerAmount = mellemrum
        int space = width/(ConstructionSizeCalculator.roofSpaerAmount(order.getConstruction()));
        svg.addRect(0,0,height,3);
        // Der skal sættes et spær for hvert mellemrum: space, space*2, space*3, indtil man når antallet af stopler
        for (int i = 0; i < ConstructionSizeCalculator.roofSpaerAmount(order.getConstruction()); i++){
            svg.addRect(space*i, 0, height, 3);
        }

        svg.addRect(width,0,height,3);
        // Stolper:
        int spacePosts = ConstructionSizeCalculator.postDistanceMax3000(width);
        for (int i = 0; i < ConstructionSizeCalculator.sidePostAmount(width); i++){
            svg.addRect(spacePosts*i, height-31, 7, 7);
            svg.addRect(spacePosts*i, 28, 7, 7);
        }

        svg.addRect(width-5, 28, 7, 7);
        svg.addRect(width-5, height-31, 7, 7);
        // Hulbånd:
        svg.addBand(0, 30, spacePosts, height-30);
        svg.addBand(0, height-28, spacePosts, 30);
        // Mål:
        // width og height skal ganges med 2, da hvis de er over 500 så deles de længere oppe ad hensyn til størrelsen af tegningen
        String text1 = "";
        String text2 = "";

        if (height>500){
            text1 = height *2 + " cm";
        } else {
            text1 = height + " cm";
        }
        if (width>500){
            text2 = width *2 + " cm";
        } else {
            text2 = width + " cm";
        }

        svg.addArrows(-25, 0, -25, height, -35, height/2, -90, text1);
        svg.addArrows(0, height+25, width, height+25, width/2, height+40, 0, text2);


        // Hvis taget er pitched:
        /*
        if (con.getRoof().getIsPitched()){
            System.out.println("Her?");
            svg.addRect(0,height/2,5,width);
        }

*/

        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}
