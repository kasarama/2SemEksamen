package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Shed;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShedSizingMia extends Command{

    // VIRKER IKKE ENDNU

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){
        int width = Integer.parseInt(request.getParameter( "width" ));
            int shedWidth = 0;
        String shedsize = request.getParameter("shedsize");
            if ("Fuld bredde".equals(shedsize)){
                shedWidth = width-15;
            }
            if ("Halv bredde".equals(shedsize)){
                shedWidth = (width-15)/2;
            }
        int depth = Integer.parseInt(request.getParameter( "sheddepth" ));

       // Shed shed = LogicFacade.shedSizing(shedWidth, depth);

        HttpSession session = request.getSession();

        session.setAttribute("shedwidth", shedWidth);
     //   session.setAttribute("shed", shed);

        return "flatroof";
    }
}
