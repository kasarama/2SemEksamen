package CarportUtil;

import DBAccess.MaterialMapper;
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

    private static List<Material> pitchedRoofMateriallist = null;
    private static List<Material> flatRoofMateriallist = null;
    private static List<Material> overlayList = null;
    private static List<Material> overlayMaterialsList = null;


    //Getters
    public static List<Material> getPitchedRoofMateriallist() {
        if (pitchedRoofMateriallist == null)
        {
            try {
                pitchedRoofMateriallist = LogicFacade.getAllPitchedRoofMaterials();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pitchedRoofMateriallist;
    }
    public static List<Material> getFlatRoofMateriallist() {
        if (flatRoofMateriallist == null)
        {
            try {
                flatRoofMateriallist = LogicFacade.getAllFlatRoofMaterials();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flatRoofMateriallist;
    }


    public static List<Material> getOverlayList() throws LoginSampleException {
        if (overlayList == null){
            try {
                overlayList = LogicFacade.getAllOverlays();
            } catch (LoginSampleException e) {
                throw new LoginSampleException("Overlay list could not load");
            }
        }
        return overlayList;
    }

    public static List<Material> getAllOverlayMaterials() throws LoginSampleException {
        if (overlayMaterialsList == null){
            try {
                overlayMaterialsList = LogicFacade.getAllOverlays();
            } catch (LoginSampleException e) {
                throw new LoginSampleException("Overlay list could not load");
            }
        }
        return overlayList;

    }

}
