package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.UserMapper;

import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
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

    public static List<Material> getAllOverlayMaterials() throws LoginSampleException {
        return MaterialMapper.getAllOverlayMaterials( );
    }
}

