package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
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

    public static Material getMaterial(String keyword) throws LoginSampleException {
        return MaterialMapper.getMaterial(keyword);
    }

    //call the static method that gets the ROOF materials data from DB - static = can be called without creating an obj.
    public static List<Material> getAllRoofMaterials() throws LoginSampleException
    {
        System.out.println(" I have reached LogicFacade.getAllRoofMaterials()");
       return MaterialMapper.getAllRoofMaterials(); //return 'getAllRoofMaterials()' method from MaterialMapper
    }

    public static List<Material> getAllOverlayMaterials() throws LoginSampleException {
        return MaterialMapper.getAllOverlayMaterials();
    }
}

