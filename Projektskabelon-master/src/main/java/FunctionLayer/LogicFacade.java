package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.MaterialMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User(name, email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static Material getMaterialBySizeName(int size, String name) throws LoginSampleException {
        return MaterialMapper.getMaterialBySizeName(size, name);
    }
    public static Material getMaterialByID(int id) throws LoginSampleException {
        return MaterialMapper.getMaterialByID(id);
    }

    public static String getUnitByName(String name) throws LoginSampleException {
        String unit = MaterialMapper.getUnitByName(name);
        return unit;
    }
    public static int getWidthByID(int id, String name) throws LoginSampleException {
        int width = MaterialMapper.getWidthByID(id, name);
        return width;
    }
    public static int getThicknessByID(int id) throws LoginSampleException {
        int thickness = MaterialMapper.getThicknessByID(id);
        return thickness;
    }

    //call the static method that gets the ROOF materials data from DB - static = can be called without creating an obj.
    public static List<Material> getAllPitchedRoofMaterials() throws LoginSampleException {
       return MaterialMapper.getAllPitchedRoofMaterials(); //return 'getAllRoofMaterials()' method from MaterialMapper
    }
    public static List<Material> getAllFlatRoofMaterials() throws LoginSampleException {
        return MaterialMapper.getAllFlatRoofMaterials(); //return 'getAllRoofMaterials()' method from MaterialMapper
    }

    public static List<Material> getAllOverlays() throws LoginSampleException {
        return MaterialMapper.getAllOverlays();
    }

    public static void sendNewRequest(Order order) throws LoginSampleException {
        Date nowDate = new Date();
        long timestamp = nowDate.getTime();

        order.setTimestamp(timestamp);
        order.setStatus("newrequest");
        order.setSalePrice(0);
        order.setCost(0);
        OrderMapper.saveNewRequest(order);
    }

    public static ArrayList<Order>  ReadOrders(String status) throws LoginSampleException {
        return  OrderMapper.ReadAllOrdersByStatus(status);
    }


    /**
     * @author Magdalena
     * The purpose of setMaterialsForOrder is to generate ArrayLists for each element of Construction
     * objekt and to return an Order object with that Construction object
     */
    public static Order setMaterialsForOrder(Order order) throws LoginSampleException {


        ArrayList<Material> ovarlayMaterialList = OverlayMaterialCalculator.allOverlayMaterialList(
                order.getConstruction(), order.getConstruction().getOverlay());
        order.getConstruction().getShed().setMaterials(ovarlayMaterialList);


        //................Materials for roof...........//
        //todo create ArrayList with materials for roof and set it on order.construction.roof

        ArrayList<Material> roofMaterialList = new ArrayList<>(); // = call the method her
        order.getConstruction().getRoof().setTagMaterialList(roofMaterialList);


        //................Materials for construction...........//
        //todo create ArrayList with materials for construction and set it on order.construction

        ArrayList<Material> constructionMaterialList = new ArrayList<>(); // = call the method here
        order.getConstruction().setFundamentMaterials(constructionMaterialList);
        Order order1 = order; //probably not necessary but not tested jet

        return order1;
    }

    public static void sendOffer(Order order) {
        Date nowDate = new Date();
        long timestamp = nowDate.getTime();

        order.setTimestamp(timestamp);
        order.setStatus("validated");

        OrderMapper.saveNewOffer(order);
    }

}

