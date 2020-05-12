package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.ConstructionSizeCalculator;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Drawing extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Construction con = new Construction();
        //int width = con.getConstructionWidth();
        int widthActual = 7800;
        // Width: 780, height: 600
        con.setConstructionLength(7800);
        con.setConstructionWidth(6000);
        int width = (con.getConstructionLength()/10)/2;
        int height = (con.getConstructionWidth()/10)/2;
        //int height = con.getConstructionHeight();
        String viewBox = "-100, 80, 900, 500";
        Svg svgFromAbove = new Svg(780, 600, viewBox, 0, 0);
            // Hvid baggrund:
            svgFromAbove.addRect(-100,80, 1000, 900);
            // Rem, spær, stolper, hulbånd, understern, overstern
        // Baggrund:
            //svgFromAbove.addRect(0,0,height,width);
        // Spær:
            svgFromAbove.addRect(0,0,600,3);
            svgFromAbove.addRect(780-4,0,600,3);
        // Remme:
            svgFromAbove.addRect(0,30,3,780);
            svgFromAbove.addRect(0,600-30,3,780);
        // Hulbånd:
        int hulbåndWidth = (((ConstructionSizeCalculator.postDistanceMax3000(widthActual)*3+100)/10)/3)*2;
            svgFromAbove.addBand(7, 30,600, 570);
            //svgFromAbove.addBand(0, height-30,height, 30);

        request.setAttribute("svgFromAbove", svgFromAbove.toString());



        String viewBox2 = "-50, 0, " + (width+100) + ", " + (height+50);
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
        int space = width/(ConstructionSizeCalculator.roofSpaerAmount(con));
        svg.addRect(0,0,height,3);
        // Der skal sættes et spær for hvert mellemrum: space, space*2, space*3, indtil man når antallet af stopler
        for (int i = 0; i < ConstructionSizeCalculator.roofSpaerAmount(con)+1; i++){
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
        svg.addArrows(-25, 0, -25, height, -25, height/2, -90, height + " cm");
        svg.addArrows(0, height+25, width, height+25, width/2,height+30, 0, width + " cm");
        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}
