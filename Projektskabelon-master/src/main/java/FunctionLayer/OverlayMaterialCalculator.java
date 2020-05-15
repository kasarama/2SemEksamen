package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class OverlayMaterialCalculator {

    final private static int DOORHEIGHT = 2000;
    final private static int DOORWIDTH = 900;
    final private static int POSTWIDTH = 100;
    final private static int MAXGAPDOORROOF = 100;
    final private static int SCREWFORDOORELEMEN = 9;
    final private static int DOORMETALELEMENS = 3;




    //......................SPAER......................//
    public static Material spaerOneWall(Wall wall) throws LoginSampleException {
        Material spaer = new Material();
        int quantity = OverlaySizeCalculator.spaerOnOneWall(wall);
        int size = OverlaySizeCalculator.spaerLengthOneWall(wall);
        spaer.setName("47X100 MM SPÆRTRÆ");
        spaer.setAmount(quantity);
        spaer.setSize(size);
        spaer.setComment("Horizontal framing");
        spaer.setPrice(LogicFacade.getPrice(spaer.getId()));
        return spaer;
    }

    //..................SCREWS FOR SPAER......................//
    public static Material screwSparOneWall(Wall wall) throws LoginSampleException {
        Material screwSpaer = new Material();
        int spaerAmount = OverlaySizeCalculator.spaerOnOneWall(wall);
        int screwSpaerQuantity = OverlaySizeCalculator.screwSpaer(spaerAmount);
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing");
        screwSpaer.setSize(screwSpaerQuantity);
        screwSpaer.setAmount(1);
        screwSpaer.setPrice(LogicFacade.getPrice(screwSpaer.getId()));
        return screwSpaer;
    }

    //........................FYR......................//
    public static ArrayList<Material> fyrOneWall(Wall wall) throws LoginSampleException {
        ArrayList<Material> fyrs = new ArrayList<>();

        ArrayList<Integer> fyrHeights = OverlaySizeCalculator.fyrLengthsOneWall(wall);
        for (Integer height : fyrHeights) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing");
            fyr.setSize(height);
            fyr.setAmount(1);
            fyr.setPrice(LogicFacade.getPrice(fyr.getId()));
            fyrs.add(fyr);
        }
        return fyrs;
    }

    //..................SCREWS FOR FYR......................//
    public static Material screwFYROneWall(Wall wall) throws LoginSampleException {
        Material screwFyr = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        int fyrQuantity = OverlaySizeCalculator.fyrQuantityOnWall(wall);
        int spaerQuantity = OverlaySizeCalculator.spaerOnOneWall(wall);
        screwFyr.setSize(OverlaySizeCalculator.screwFyr(fyrQuantity, spaerQuantity));
        screwFyr.setComment("Til montering af vertical framing");
        screwFyr.setAmount(1);
        screwFyr.setPrice(LogicFacade.getPrice(screwFyr.getId()));
        return screwFyr;
    }


    //..............SCREWS FOR OVERLAY........................//
    public  static Material screwForOverlayOneWall ( Wall wall, String overlayName) throws LoginSampleException {
        Material screwOverlay = new Material();
        if (overlayName.equals("HARDIEPLANK 180X3600X8MM")) {
            screwOverlay.setName("FACADESKRUE TIL HARDIEPLANK");
        } else {
            screwOverlay.setName("BASIC SKRUE 5,0X40MM");
        }
        int size = OverlaySizeCalculator.overlayScrewOneWall(wall, overlayName);
        screwOverlay.setSize(size);
        screwOverlay.setComment("til montering af beklædningsplanke");
        screwOverlay.setAmount(1);
        screwOverlay.setPrice(LogicFacade.getPrice(screwOverlay.getId()));

        return screwOverlay;


    }



    //.......................returns LIST OF ALL MATERIALS NEEDED FOR FRAMING chosen wall.................//
    public static ArrayList<Material> wallFraming(Wall wall) throws LoginSampleException {
        ArrayList<Material> wallFraming = new ArrayList<>();

        Material spaerOneWall = spaerOneWall(wall);
        Material screwSparOneWall = screwSparOneWall(wall);
        ArrayList<Material> fyrOneWall = fyrOneWall(wall);
        Material screwFYROneWall = screwSparOneWall(wall);

        wallFraming.add(spaerOneWall);
        wallFraming.add(screwFYROneWall);
        wallFraming.add(screwSparOneWall);
        wallFraming.addAll(fyrOneWall);


        return wallFraming;
    }


    //....................................MATERIALS FOR OVERLAY....................................//
    public static ArrayList<Material> overlayMaterial(Construction construction, String materialName) throws LoginSampleException {
        ArrayList<Material> overlayMaterials = new ArrayList<>();

        ArrayList<Wall> carportWalls = construction.getWalls();
        ArrayList<Wall> shedWalls = construction.getShed().getWalls();
        ArrayList<Wall> allWalls = new ArrayList<>();
        allWalls.addAll(shedWalls);
        allWalls.addAll(carportWalls);


        for (Wall wall :allWalls) {
            Material overlayScrew = screwForOverlayOneWall(wall, materialName);
            overlayMaterials.add(overlayScrew);
        }


        double wholeAreal = OverlaySizeCalculator.allWallsArea(construction);
        double amount=OverlaySizeCalculator.overlaySpending(materialName, wholeAreal);
        int quantity =(int)Math.round(amount);

        if (quantity<amount){
            quantity=quantity+1;
        }

        Material overlay = new Material();
        overlay.setName(materialName);
        overlay.setSize(3600);
        overlay.setAmount(quantity);
        overlay.setComment("Beklædning");
        overlay.setPrice(LogicFacade.getPrice(overlay.getId()));
        if (quantity == 0) {
            throw new LoginSampleException("Vi kunne ikke beregne beklædning: "
                    + materialName + ". Prøv at vælge noget andet til beklædning");
        }
        overlayMaterials.add(overlay);

        return overlayMaterials;

    }


    //..................door Framing..........................//
    public static ArrayList<Material> doorFraming(Construction construction) throws LoginSampleException {
        ArrayList<Material> doorMaterials = new ArrayList<>();
        /*

         */
        int tilt = construction.getRoof().getTilt();
        int distance = construction.getShedDepth();
        int raising = (int) ConstructionSizeCalculator.raising(tilt, distance);
        int overDoorFyr = raising;
        Integer[] fyrLengths = {DOORHEIGHT, DOORHEIGHT, DOORHEIGHT, overDoorFyr};
        int lastIndex;
        if (overDoorFyr <= MAXGAPDOORROOF) {
            lastIndex = 2;
        } else {
            lastIndex = 3;
        }

        for (int i = 0; i <= lastIndex; i++) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing-dør");
            fyr.setSize(fyrLengths[i]);
            fyr.setAmount(1);
            fyr.setPrice(LogicFacade.getPrice(fyr.getId()));
            doorMaterials.add(fyr);
        }

        int overDoorSpearQuantity = OverlaySizeCalculator.overDoorSpearQuantity(raising);
        int doorSpaerToSplit = (int) (2 * DOORWIDTH + Math.sqrt(Math.pow(DOORHEIGHT, 2) + Math.pow(DOORHEIGHT, 2)));

        for (int i = 0; i < overDoorSpearQuantity; i++) {
            Material overDoorSpaer = new Material();
            overDoorSpaer.setName("47X100 MM SPÆRTRÆ");
            overDoorSpaer.setComment("Horizontal framing-dør");
            overDoorSpaer.setSize(DOORWIDTH + (int) 1.5 * POSTWIDTH);
            overDoorSpaer.setAmount(overDoorSpearQuantity);
            overDoorSpaer.setPrice(LogicFacade.getPrice(overDoorSpaer.getId()));
            doorMaterials.add(overDoorSpaer);
        }
        Material doorSpaer = new Material();
        doorSpaer.setName("47X100 MM SPÆRTRÆ");
        doorSpaer.setComment("Horizontal framing-dør");
        doorSpaer.setSize(doorSpaerToSplit);
        doorSpaer.setAmount(1);
        doorSpaer.setPrice(LogicFacade.getPrice(doorSpaer.getId()));
        doorMaterials.add(doorSpaer);


        Material greb = new Material();
        greb.setName("Stalddørsgreb 50x75");
        greb.setComment("Greb til skurdør");
        greb.setSize(1);
        greb.setAmount(1);
        greb.setPrice(LogicFacade.getPrice(greb.getId()));
        doorMaterials.add(greb);

        Material hinge = new Material();
        hinge.setComment("Hængsler til skurdør");
        hinge.setName("T-Hængsel 390 mm");
        hinge.setAmount(2);
        hinge.setSize(1);
        hinge.setPrice(LogicFacade.getPrice(hinge.getId()));
        doorMaterials.add(hinge);


        int screwFyrQuantity = 0;
        int screwSpaerQuantity = 0;
        for (Material material : doorMaterials) {
            if (material.getName().equals("19X50 MM BRÆDDER FYR")) {
                screwFyrQuantity = screwFyrQuantity + material.getAmount();
            }
            if (material.getName().equals("47X100 MM SPÆRTRÆ")) {
                screwSpaerQuantity = screwFyrQuantity + material.getAmount();

            }
        }


        Material screwFyr = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        screwFyr.setSize(screwFyrQuantity); //for the door - always the same size of the door
        screwFyr.setComment("Til montering af vertical framing-dør");
        screwFyr.setPrice(LogicFacade.getPrice(screwFyr.getId()));
        doorMaterials.add(screwFyr);

        Material screwFyrDoor = new Material();
        screwFyrDoor.setName("BASIC SKRUE 5,0X40MM");
        screwFyrDoor.setSize(SCREWFORDOORELEMEN*DOORMETALELEMENS); //for the door - always the same size of the door
        screwFyrDoor.setComment("Til montering af vertical framing-dør");
        screwFyrDoor.setPrice(LogicFacade.getPrice(screwFyrDoor.getId()));
        doorMaterials.add(screwFyrDoor);

        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing-dør");
        screwSpaer.setSize(screwSpaerQuantity); //for the door - always the same sioze of the door
        screwSpaer.setPrice(LogicFacade.getPrice(screwSpaer.getId()));
        doorMaterials.add(screwSpaer);


        return doorMaterials;
    }


    public static ArrayList<Material> allOverlayMaterialList(Construction construction, String overlayName) throws LoginSampleException {

        ArrayList<Material> overlayMaterials = new ArrayList<>();
        ArrayList<Material> doorFraming = doorFraming(construction);

        ArrayList<Wall> walls = construction.getWalls();
        construction.getWalls().addAll(construction.getShed().getWalls());


        if (walls.size()==0){
            return null;
        } else

        for (Wall wall : walls) {
            ArrayList<Material> oneWallMaterials = new ArrayList<>();
            oneWallMaterials=wallFraming(wall);
            overlayMaterials.addAll(oneWallMaterials);
        }
        overlayMaterials.addAll(doorFraming);

        overlayMaterials.addAll(overlayMaterial(construction,overlayName));
        return overlayMaterials;
    }
}

