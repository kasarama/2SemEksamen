package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.CarportRequest;
import FunctionLayer.LoginSampleException;
import FunctionLayer.ShedSizing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MakeRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));
        int isShed = Integer.parseInt(request.getParameter("isShed"));

        HttpSession session = request.getSession();
        Carport carportRequest = new Carport();
        if(session.getAttribute("carportRequest")==null) {
            session.setAttribute("carportRequest", carportRequest);

        }

        String shedMsg="Der gik noget galt";
        int shedVersion=-1;
        if (length<560 && width<420){
            shedMsg="De mål du har valgt er for små for at bygge en skur. Den mindste længde for en carport er 440 cm " +
                    "og den mindste bredde er 300. Der skal beregnes mindst 120 cm for skur." +
                    "Du kan gå tilbage for at redigire, eller fortsætte med carport uden skur";
            shedVersion=0;

        } else if (length<560 && width>=420){
            shedMsg="Med de mål du har valgt kan du kun bygge din skur på siden af carport. " +
                    "Du kan gå tilbage for at redigire, eller vælge skurens mål. " +
                    "Vi anbefaler at skuren skal fylde hele længde af din carport.";
            shedVersion=1;
        } else if (length>=560 && width<420){
            shedMsg="Med de mål du har valgt kan du kun bygge din skur på bagsiden af carport. " +
                    "Du kan gå tilbage for at redigire, eller vælge skurens mål";
            shedVersion=2;
        } else {
            shedMsg="Din carport er står nok til at bygge skur på bagsiden eller siden. ";
            shedVersion=3;
        }
        request.setAttribute("shedMsg", shedMsg);
        request.setAttribute("shedVersion", shedVersion);

        ArrayList<ArrayList> possibleSizes = ShedSizing.possibleSizes(carportRequest, shedVersion);

        request.setAttribute("possibleSizes", possibleSizes);


        if (isShed != 0) {
            return "designshed";
        } else {
            if (roofType != 0 && isShed == 0) {
                return "designpitchedroof";
            } else {
                    return "designflatroof";
                }
            }
        }

    }
