package FunctionLayer;

import java.util.ArrayList;

public class OverlayMaterialCalculator {


    //todo method that counts equal Materials on the list and make them into one with the propper amount of it
    //todo what is misssing for the door??


    //..................SPAER......................//

public static Material sparOneWall(Wall wall){
    Material spaer = new Material();

    int amount = OverlaySizeCalculator.spaerOnOneWall(wall);
    int size = OverlaySizeCalculator.spaerLengthOneWall(wall);
    spaer.setName("47X100 MM SPÆRTRÆ");
    spaer.setAmount(amount);
    spaer.setSize(size);
    spaer.setComment("Horizontal framing");

    return spaer;
}
    public static Material screwSparOneWall(Wall wall){
        Material screwSpaer = new Material();
        int spaerAmount = OverlaySizeCalculator.spaerOnOneWall(wall);
        int screwSpaeramount = OverlaySizeCalculator.screwSpaer(spaerAmount);
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing");
        screwSpaer.setSize(screwSpaeramount);
    return  screwSpaer;











  /*


    //.......................All the materials for overlay.............................//
    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> shedOverlayMaterialList(Construction construction, String overlayName) throws LoginSampleException {
        ArrayList<Material> allWallsMaterials = wallMaterials(construction.getShed().getWalls());
        ArrayList<Material> doorMaterials = doorFraming(construction.getRoof().getTilt(), construction.getCarportLength());
        ArrayList<Material> shedOverlayMaterialList = new ArrayList<>();
        Material overlay = overlaMaterial(overlayName,construction);
        shedOverlayMaterialList.addAll(allWallsMaterials);
        shedOverlayMaterialList.addAll(doorMaterials);
        shedOverlayMaterialList.add(overlay);



        return shedOverlayMaterialList;
    }

    //................................materialsForOneWallFraming............................//
    //for given wall calculates all the materials needed for framing for horizontal overlay
    public static ArrayList<Material> materialsForOneWallFraming(Wall wall) {

        ArrayList<Material> materials = new ArrayList<>();
        Material spaer = new Material();
        spaer.setName("47X100 MM SPÆRTRÆ");
        int spaers = OverlaySizeCalculator.spaerOnOneWall(wall);
        int spaerlength = ConstructionSizeCalculator.postDistanceMax3000(wall.getLength());
        spaer.setSize(spaerlength);
        spaer.setComment("Horizontal framing");
        for (int i = 0; i < spaers; i++) {
            materials.add(spaer);
        }
        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing");
        int screwSpaeramount = OverlaySizeCalculator.screwSpaer(spaers);
        screwSpaer.setSize(screwSpaeramount);
        materials.add(screwSpaer);


        Material fyr = new Material();
        fyr.setName("19X50 MM BRÆDDER FYR");
        fyr.setComment("Vertical framing");
        int fyrsnumber = OverlaySizeCalculator.fyrNumberOnWall(wall);
        ArrayList<Integer> fyrHeights = OverlaySizeCalculator.fyrLengthsOneWall(wall);
        for (Integer height : fyrHeights
        ) {
            fyr.setSize(height);
            materials.add(fyr);
        }

        Material screwFyr = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        screwFyr.setSize(OverlaySizeCalculator.screwFyr(fyrsnumber, spaers));

        screwFyr.setComment("Til montering af vertical framing");
        materials.add(screwFyr);
        return materials;
    }


    public static Material overlaMaterial(String materialName, Construction construction) throws LoginSampleException {
        double wholeAreal=OverlaySizeCalculator.allWallsArea(construction);

        int amount = OverlaySizeCalculator.overlaySpending(materialName, wholeAreal);
        Material overlay = new Material();
        overlay.setName(materialName);
        overlay.setAmount(amount);
        if (amount==0){
            throw new LoginSampleException("Vi kunne ikke beregne beklædning: "
                    +materialName+". Prøv at vælge noget andet beklædning");
        }

        return overlay;

    }

    //..................door Framing..........................//
    public static ArrayList<Material> doorFraming(int angle, int sideWallLength) {
        ArrayList<Material> doorMaterials = new ArrayList<>();
        int overDoorFyr =(int) ConstructionSizeCalculator.raising(angle, sideWallLength - 100);
        Integer[] fyrLengths = {1640, 1640, 1640, overDoorFyr};
        for (int i = 0; i < 4; i++) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing-dør");
            fyr.setSize(fyrLengths[i]);
            doorMaterials.add(fyr);
        }

        Integer[] spaerSizes = {1640, 1000, 1000, 900, 900}; //acroos the door (180x90 cm), 2 over the door,two horizontal for door
        for (int i = 0; i < 5; i++) {
            Material spaer = new Material();
            spaer.setName("47X100 MM SPÆRTRÆ");
            spaer.setComment("Horizontal framing-dør");
            spaer.setSize(spaerSizes[i]);
            doorMaterials.add(spaer);
        }
        Material greb = new Material();
        greb.setName("stalddørsgreb 50x75");
        greb.setComment("Greb til skurdør");
        doorMaterials.add(greb);

        Material hinge = new Material();
        hinge.setComment("Hængsler til skurdør");
        hinge.setName("t hængsel 390 mm");
        doorMaterials.add(hinge);

        Material screwFyr = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        screwFyr.setSize(24); //for the door - always the same sioze of the door
        screwFyr.setComment("Til montering af vertical framing-dør");
        doorMaterials.add(screwFyr);

        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing-dør");
        screwSpaer.setSize(8); //for the door - always the same sioze of the door
        doorMaterials.add(screwSpaer);


        return doorMaterials;
    }

    //..........Materials for framing for all the given walls...........................//
    public static ArrayList<Material> wallMaterials(ArrayList<Wall> walls) {
        ArrayList<Material> materials = new ArrayList<>();
        for (Wall wall : walls) {
            ArrayList wallMaterials = materialsForOneWallFraming(wall);
            materials.addAll(wallMaterials);
        }
        return materials;
    }
    */
}
