package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class PitchedRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
    //todo læs data fra designpitchedroof.jsp og brug dem for t designe tag med rejsning

        // -- attempt to read data from designpitchedroof.jsp --

        String [] pitchedroofInfos = request.getParameterValues("pitchedroof");

        //initilizing the List to null (empty)
        List<String> picthedRoofList = null;

        //if the arrayList 'infos'(checkboxes) is not 'empty' then convert it to a List
        if (pitchedroofInfos != null) // this is done to avoid getting an empty List.
        {
            picthedRoofList = Arrays.asList(pitchedroofInfos);//convert "infos" to a List
        }

        request.setAttribute("pitchedroofInfos", picthedRoofList); //key: "the ArrayList", value: "The converted ArrayList"


        request.setAttribute("pitchedroofInfos", picthedRoofList); //key: "the ArrayList", value: "The converted ArrayList"

        return "designpitchedroof";
    }
}
