package PresentationLayer;

import CarportUtil.ListFactory;
import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("AddMaterial called");
        Material material = new Material();
try {
    String name = request.getParameter("name");
    if (request.getParameter("name") == null) {
        name = null;
    }
    int width = Integer.parseInt(request.getParameter("width"));
    if ((request.getParameter("width") == null)) {
        width = 0;
    }
    int thickness = Integer.parseInt(request.getParameter("thickness"));
    if ((request.getParameter("thickness") == null)) {
        width = 0;
    }
    String unit = (request.getParameter("unit"));
    if (request.getParameter("unit") == null) {
        unit = null;
    }
    String keyword = (request.getParameter("keyword"));
    if (request.getParameter("keyword") == null) {
        keyword = null;
    }
    String category = (request.getParameter("category"));
    if (request.getParameter("category") == null) {
        category = "uncategorized";
    }
    double price = (Double.parseDouble(request.getParameter("price")));
    if (request.getParameter("price") == null) {
        price = 0;
    }
    String picture = (request.getParameter("category") + "/" + request.getParameter("picture"));
    if (request.getParameter("picture") == null) {
        picture = "uncategorized/logo.png";
    }
    double spending = Double.parseDouble(request.getParameter("spending"));
    if (request.getParameter("spending") == null) {
        spending = 0;
    }



        material.setName(name);
        material.setWidth(width);
        material.setThickness(thickness);
        material.setUnit(unit);
        material.setKeyword(keyword);
        material.setCategory(category);
        material.setPrice(price);
        material.setPicture(category+"/"+picture);

        System.out.println(material.toString());
        ListFactory.saveInFile(material,spending);
        MaterialMapper.addMatDB(material);
}catch (Exception ex){
    ex.printStackTrace();
    throw new LoginSampleException(ex.getMessage());
}
        return "addmaterial";
    }
}
