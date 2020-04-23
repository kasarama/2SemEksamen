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

    ////call the static method that gets the material data from DB - static = can be called without creating an obj.
    public static List<Material> getAllMaterials() throws LoginSampleException
    {
       return MaterialMapper.getAllMaterials(); //return 'getAllMaterials()' method from MaterialMapper
    }

}
