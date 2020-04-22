package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PitchedRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //todo læs data fra designpitchedroof.jsp og brug dem for t designe tag med rejsning

        return "designpitchedroof";
    }
}
