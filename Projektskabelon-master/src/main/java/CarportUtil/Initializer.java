package CarportUtil;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.util.List;

/*
NOTE 1: This class ‘initializes’ (gives a start value) to the called methods from the “LogicFacade”,
 in case they don’t have one already.


NOTE 2: what's exactly being returned?
        the "materialList" which calls ".getAllMaterials()" method
       from “LogicFacade” which calls the “getAllMaterials(” from the “MaterialMapper”
       --> i.e. we are calling a method that connects to DB,
       creates list of materials obj and gets its data (rows) from DB in each 'Getter'.
*/
public class Initializer {

    private static List<Material> materialList = null;
    private static List<Material> overlayList = null;

    //Getters
    public static List<Material> getMaterialList() {
        if (materialList == null)
        {
            try {
            materialList = LogicFacade.getAllRoofMaterials();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return materialList;
    }
    public static List<Material> getOverlayList() throws LoginSampleException {
        if (overlayList == null){
            try {
                overlayList = LogicFacade.getAllOverlayMaterials();
            } catch (LoginSampleException e) {
                throw new LoginSampleException("Overlay list could not load");
            }
        }
        return overlayList;

    }
}
