package FunctionLayer;

import java.util.ArrayList;

public class OverlayMaterialCalculator {


    //todo method that counts equal Materials on the list and make them into one with the propper amount of it
    //todo what is misssing for the door??


    //.......................All the materials for overlay.............................//
    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> shedOverlayMaterialList(Construction construction, String overlayName) throws LoginSampleException {
        ArrayList<Material> allWallsMaterials = wallMaterials(construction.getShed().getWalls());
        ArrayList<Material> doorMaterials = doorFraming(construction.getRoof().getDegree(), construction.getCarportLength());
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
        int fyrsnumber = OverlaySizeCalculator.fyrNumberOnSide(wall.getLength());
        ArrayList<Integer> fyrHeights = OverlaySizeCalculator.fyrLengths(wall.getMinHeight(), wall.getRaising(), wall.getLength());
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
        double wholeAreal=OverlaySizeCalculator.allWallsAreal(construction);

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



/*
    // Skur beklædning
    public int shedTimbering(int shedWidth){
        int areal = shedWidth*carport.getShedDepth();
        int shedTimbering = (int) Math.round(((areal/100)*12.5));
        return shedTimbering;
    }

    // Ydrebeklædnings skruer
    public int outherTimbering(int length, int width){
        int outherTimbering = 0;

        if (length < 500 && width < 510){
            outherTimbering = 200;
        }
        if (length > 500 && width > 510){
            outherTimbering = 400;
        }
        return outherTimbering;
    }

    // Inner beklædningsskruer
    public int innerTimbering(int length, int width){
        int innerTimbering = 0;

        if (length < 500 && width < 510){
            innerTimbering = 150;
        }
        if (length > 500 && width > 510){
            innerTimbering = 300;
        }
        return innerTimbering;
    }
*/



    /*
    m x 25 x 300cm
    hvis unit.equals ("m"){
    pris = size*pris/100

    ("stk2)
    pris=size*price

     */

}
