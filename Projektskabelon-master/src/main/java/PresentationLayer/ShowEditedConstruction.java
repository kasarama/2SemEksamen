package PresentationLayer;

import FunctionLayer.UpdateConstruction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEditedConstruction  extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UpdateConstruction.validate(construction);
        return "itemList";
    }
}
