package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.ConstructionSizeCalculator;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Construction con = new Construction();
        //int width = con.getConstructionWidth();
        int widthActual = 7800;
        int width = (780/3)*2;
        int height = (600/3)*2;
        //int height = con.getConstructionHeight();
        String viewBox = "-50, 0, " + (width+50) + ", " + height;
        Svg svgFromAbove = new Svg(width+10, height, viewBox, 0, 0);
            // Hvid baggrund:
            //svgFromAbove.addRect(-100,-20, height+400, width+120);
            // Rem, spær, stolper, hulbånd, understern, overstern
        // Baggrund:
            svgFromAbove.addRect(0,0,height,width);
        // Spær:
            svgFromAbove.addRect(0,0,height,3);
            svgFromAbove.addRect(width-4,0,height,3);
        // Remme:
            svgFromAbove.addRect(0,30,3,width);
            svgFromAbove.addRect(0,height-30,3,width);
        // Hulbånd:
        int hulbåndWidth = (((ConstructionSizeCalculator.postDistanceMax3000(widthActual)*3+100)/10)/3)*2;
            svgFromAbove.addBand(0, 30,height, hulbåndWidth);
            svgFromAbove.addBand(0, height-30,height, 30);

        request.setAttribute("svgFromAbove", svgFromAbove.toString());

        Svg svg = new Svg(533, 400, "0, 0, 533, 400", 0, 0);
        svg.addRect(0,0,400,520);
        svg.addRect(0,23,3,520);
        svg.addRect(0,377,3,520);
        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}
