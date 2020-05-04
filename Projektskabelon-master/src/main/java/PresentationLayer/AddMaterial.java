package PresentationLayer;

import CarportUtil.ListFactory;
import DBAccess.MaterialMapper;
import FunctionLayer.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("AddMaterial called");
        Material material = new Material();

        String name =request.getParameter("name");
        if (request.getParameter("name")==null){
            name=null;
        }
        int size= Integer.parseInt(request.getParameter("size"));
        if((request.getParameter("size")==null)){
            size=0;
        }
        String unit = (request.getParameter("unit"));
        if(request.getParameter("unit")==null){
            unit=null;
        }
        String keyword=(request.getParameter("keyword"));
        if(request.getParameter("keyword")==null){
            keyword=null;
        }
        String category=(request.getParameter("category"));
        if(request.getParameter("category")==null){
            category="uncategorized";
        }
        double price=(Double.parseDouble(request.getParameter("price")));

        if(request.getParameter("price")==null){
            price=0;
        }
        String picture=(request.getParameter("category")+"/"+request.getParameter("picture"));
        if(request.getParameter("picture")==null){
            picture="uncategorized/logo.png";
        }


        material.setName(request.getParameter("name"));
        material.setSize(Integer.parseInt(request.getParameter("size")));
        material.setUnit(request.getParameter("unit"));
        material.setKeyword(request.getParameter("keyword"));
        material.setCategory(request.getParameter("category"));
        material.setPrice(Double.parseDouble(request.getParameter("price")));
        material.setPicture(request.getParameter("category")+"/"+request.getParameter("picture"));
        System.out.println(material.toString());
        ListFactory.saveInFile(material);
        MaterialMapper.addMatDB(material);

        return "addmaterial";
    }
}
