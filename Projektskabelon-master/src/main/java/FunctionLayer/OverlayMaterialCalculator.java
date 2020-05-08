package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class OverlayMaterialCalculator {
    //todo method that counts equal Materials on the list and make them into one with the propper amount of it
    //todo what is misssing for the door??

    final private  static int DOORHEIGHT=2000;
    final private  static int DOORWIDTH =900;
    final private  static int POSTWIDTH =100;
    final private  static int MAXGAPDOORROOF=100;
    final private  static int SPAERDISTANCE=1000;




    //......................SPAER......................//
    public static Material sparOneWall(Wall wall) {
        Material spaer = new Material();
        int quantity = OverlaySizeCalculator.spaerOnOneWall(wall);
        int size = OverlaySizeCalculator.spaerLengthOneWall(wall);
        spaer.setName("47X100 MM SPÆRTRÆ");
        spaer.setAmount(quantity);
        spaer.setSize(size);
        spaer.setComment("Horizontal framing");

        return spaer;
    }

    //..................SCREWS FOR SPAER......................//
    public static Material screwSparOneWall(Wall wall) {
        Material screwSpaer = new Material();
        int spaerAmount = OverlaySizeCalculator.spaerOnOneWall(wall);
        int screwSpaerQuantity = OverlaySizeCalculator.screwSpaer(spaerAmount);
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing");
        screwSpaer.setSize(screwSpaerQuantity);
        screwSpaer.setAmount(1);

        return screwSpaer;
    }

    //........................FYR......................//
    public static ArrayList<Material> FyrOneWall(Wall wall) {
        ArrayList<Material> fyrs = new ArrayList<>();

        ArrayList<Integer> fyrHeights = OverlaySizeCalculator.fyrLengthsOneWall(wall);
        for (Integer height : fyrHeights) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing");
            fyr.setSize(height);
            fyr.setAmount(1);
            fyrs.add(fyr);
        }
        return fyrs;
    }

    //..................SCREWS FOR FYR......................//
    public static Material screwFYROneWall(Wall wall) {
        Material screwFyr = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        int fyrQuantity = OverlaySizeCalculator.fyrQuantityOnWall(wall);
        int spaerQuantity = OverlaySizeCalculator.spaerOnOneWall(wall);
        screwFyr.setSize(OverlaySizeCalculator.screwFyr(fyrQuantity, spaerQuantity));
        screwFyr.setComment("Til montering af vertical framing");
        screwFyr.setAmount(1);
        return screwFyr;
    }


    //..................door Framing..........................//
    public static ArrayList<Material> doorFraming(Construction construction) {
        ArrayList<Material> doorMaterials = new ArrayList<>();
        /*

         */
        int tilt = construction.getRoof().getTilt();
        int distance= construction.getShedDepth();
        int raising=(int) ConstructionSizeCalculator.raising(tilt, distance);
        int overDoorFyr =raising;
        Integer[] fyrLengths = {DOORHEIGHT, DOORHEIGHT, DOORHEIGHT, overDoorFyr};
        int lastIndex;
        if(overDoorFyr<=MAXGAPDOORROOF){
            lastIndex=2;
        } else {
            lastIndex=3;
        }

            for (int i = 0; i <= lastIndex; i++) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing-dør");
            fyr.setSize(fyrLengths[i]);
            fyr.setAmount(1);
            doorMaterials.add(fyr);
        }

            int overDoorSpearQuantity = OverlaySizeCalculator.overDoorSpearQuantity(raising);
            int doorSpaerToSplit = (int) ( 2*DOORWIDTH + Math.sqrt(Math.pow(DOORHEIGHT,2)+Math.pow(DOORHEIGHT,2)));

        for (int i = 0; i <overDoorSpearQuantity ; i++) {
            Material overDoorSpaer = new Material();
            overDoorSpaer.setName("47X100 MM SPÆRTRÆ");
            overDoorSpaer.setComment("Horizontal framing-dør");
            overDoorSpaer.setSize(DOORWIDTH+(int)1.5*POSTWIDTH);
            overDoorSpaer.setAmount(overDoorSpearQuantity);
            doorMaterials.add(overDoorSpaer);
        }
        Material doorSpaer = new Material();
        doorSpaer.setName("47X100 MM SPÆRTRÆ");
        doorSpaer.setComment("Horizontal framing-dør");
        doorSpaer.setSize(doorSpaerToSplit);
        doorSpaer.setAmount(1);
        doorMaterials.add(doorSpaer);


        Material greb = new Material();
        greb.setName("stalddørsgreb 50x75");
        greb.setComment("Greb til skurdør");
        greb.setSize(1);
        greb.setAmount(1);
        doorMaterials.add(greb);

        Material hinge = new Material();
        hinge.setComment("Hængsler til skurdør");
        hinge.setName("t hængsel 390 mm");
        hinge.setAmount(2);
        hinge.setSize(1);
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





    }











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

