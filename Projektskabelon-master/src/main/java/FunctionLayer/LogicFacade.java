package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.MaterialMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;


public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name, String email, String password ) throws LoginSampleException {
        User user = new User(name, email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    /**
     * @author Mia
     */
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
    public static double getPrice(int id) throws LoginSampleException {
        double price = MaterialMapper.getPrices(id);
        return price;
    }


    public static ArrayList<Integer> getLengthForMaterials(String nameMaterial) throws LoginSampleException {
        ArrayList lengthForMaterials = MaterialMapper.getLengthForMaterials(nameMaterial);
        return lengthForMaterials;
    }

    public static String getANameFromMaterialID(int idMaterial) throws LoginSampleException {
        return MaterialMapper.getNameFromMaterialID(idMaterial);
    }


    //call the static method that gets the ROOF materials data from DB - static = can be called without creating an obj.
    public static List<Material> getAllPitchedRoofMaterials() throws LoginSampleException {
       return MaterialMapper.getAllPitchedRoofMaterials(); //return 'getAllRoofMaterials()' method from MaterialMapper
    }
    public static List<Material> getAllFlatRoofMaterials() throws LoginSampleException {
        return MaterialMapper.getAllFlatRoofMaterials(); //return 'getAllRoofMaterials()' method from MaterialMapper
        /*if (isPitched) {
            return MaterialMapper.getAllRoofMaterialsByCategory("RejsningTag");//return 'getAllRoofMaterials()' method from MaterialMapper
        }
        return MaterialMapper.getAllRoofMaterialsByCategory("FladtTag");*/
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
    public static void setMaterialsForOrder(Order order) throws LoginSampleException {

        System.out.println("Is about to set materials for overlay\n" +
                "Needed data to proceed construction selv and overlay. overlay: "+ order.getConstruction().getOverlay());

        String msg = OverlayMaterialCalculator.allOverlayMaterialList(
                order.getConstruction(), order.getConstruction().getOverlay());
        System.out.println(msg);
       // order.getConstruction().getShed().setMaterials(ovarlayMaterialList);
        System.out.println("Materials saved for Shed in Logic facade:" +order.getConstruction().getShed().getMaterials().size());


        //................Materials for roof...........//
        //todo create ArrayList with materials for roof and set it on order.construction.roof

        ArrayList<Material> roofMaterialList = new ArrayList<>(); // = call the method her
       // order.getConstruction().getRoof().setTagMaterialList(roofMaterialList);



        //................Materials for construction...........//
        //todo create ArrayList with materials for construction and set it on order.construction

        ArrayList<Material> constructionMaterialList = ConstructionMaterialCalculator.constructionMaterialList(order.getConstruction());
        order.getConstruction().setFundamentMaterials(constructionMaterialList);


    }

    public static void sendOffer(Order order) throws LoginSampleException {
        Date nowDate = new Date();
        long timestamp = nowDate.getTime();

        order.setTimestamp(timestamp);
        order.setStatus("validated");

        OrderMapper.saveNewOffer(order);
    }

}

