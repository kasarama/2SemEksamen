package FunctionLayer;

import java.util.ArrayList;


/**
 * @author Magdalena
 */
public class OverlayCalculator {
    //todo method that counts equal Materials on the list and make them into one with the propper amount of it
    //todo what is misssing for the door??


    //.......................All the materials for overlay.............................//
    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> shedOverlayMaterialList(Construction construction) {
        ArrayList<Material> allWallsMaterials = wallMaterials(construction.getShed().getWalls());
        ArrayList<Material> doorMaterials = doorFraming(construction.getRoof().getDegree(), construction.getCarportLength());
        ArrayList<Material> shedOverlayMaterialList= new ArrayList<>();
        shedOverlayMaterialList.addAll(allWallsMaterials);
        shedOverlayMaterialList.addAll(doorMaterials);


        return shedOverlayMaterialList;
    }

    //................................materialsForOneWallFraming............................//
    //for given wall calculates all the materials needed for framing for horizontal overlay
    public static ArrayList<Material> materialsForOneWallFraming(Wall wall){
        ArrayList<Material> materials = new ArrayList<>();
        Material spaer = new Material();
        spaer.setName("47X100 MM SPÆRTRÆ");
        int spaers = spaersNumberOnSide(wall.getLength(),wall.getMinHeight(),wall.getRaising());
        int spaerlength= ConstructionSizeCalculator.postDistanceMax300(wall.getLength());
        spaer.setSize(spaerlength);
        spaer.setComment("Horizontal framing");
        for (int i = 0; i < spaers; i++) {
            materials.add(spaer);
        }
        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing");
        int screwSpaeramount = screwSpaer(spaers);
        screwSpaer.setSize(screwSpaeramount);
        materials.add(screwSpaer);

        Material fyr = new Material();
        fyr.setName("19X50 MM BRÆDDER FYR");
        fyr.setComment("Vertical framing");
        int fyrsnumber= fyrNumberOnSide(wall.getLength());
        ArrayList<Integer> fyrHeights=fyrLengths(wall.getMinHeight(),wall.getRaising(),wall.getLength());
        for (Integer height:fyrHeights
             ) {
            fyr.setSize(height);
            materials.add(fyr);
        }
        Material screwFyr  = new Material();
        screwFyr.setName("BASIC SKRUE 5,0X40MM");
        screwFyr.setSize(screwFyr(fyrsnumber,spaers));
        screwFyr.setComment("Til montering af vertical framing");
        materials.add(screwFyr);
        return materials;
    }



    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post
    public static int spaersNumberOnSide(int length, int minHeight, int angle) {
        int spaersAmount = 1;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(minHeight, angle, length);
        for (int i = 0; i < postsheights.length-1; i++) { //+1 because there one more spaer than distances
            int tmp = spaersAmount+1;//
            spaersAmount = tmp + postsheights[i] / 100; //counts number of distances between 2 spaers
        }
        return spaersAmount;

    }

    //calculates number of screws for spar (6cm)
    public static int screwSpaer(int spaernumber) {
        return spaernumber * 2 * 2; //2 screws on each side of spaer
    }

    public static int numberOfFyrOnDistance(int distance){
        int numberOfFyrOnDistance;
        if (distance % 60 == 0) {
            numberOfFyrOnDistance = distance / 60 - 1;
        } else {
            numberOfFyrOnDistance = (distance - distance % 60) / 60;
        }
        return numberOfFyrOnDistance;
    }

    //counts number of fyr on each distance and in total on chosen side
    public static int fyrNumberOnSide(int length) {
        int distance = ConstructionSizeCalculator.postDistanceMax300(length);
        int distancesNumber = ConstructionSizeCalculator.sidePostAmount(length) - 1;
        int numberOfFyrOnDistance=numberOfFyrOnDistance(distance);

        return numberOfFyrOnDistance * distancesNumber;
    }

    //calculates number of screws for fyr (4cm)
    public static int screwFyr(int fyrnumber, int spaernumber) {
        return fyrnumber * spaernumber; //1 screws on each  spaer
    }

    //returns array with length of each fyr used on chosen side
    /*

     */
    public static ArrayList<Integer> fyrLengths(int height, int angle, int size){
        ArrayList<Integer> fyrLengths = new ArrayList<>();
        int allLengths=numberOfFyrOnDistance(size-10)+2; // treats posts as fyr and counts them all;
        int postNumber= ConstructionSizeCalculator.sidePostAmount(size);
        int distance = size/(postNumber+fyrNumberOnSide(size)-1);
        int distanceOfPosts= ConstructionSizeCalculator.postDistanceMax300(size);
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distanceOfPosts);
        fyrLengths.add(height); //the first post has height of the start(given) height

            for (int i = 1; i < allLengths; i++) {
                int tmp = height;
                height = tmp + ConstructionSizeCalculator.raising(angle, distance); // calculates height of the element on given distance
                fyrLengths.add(height); //adds calculated height and each fyr to the list
        }

        //on the list there are also posts that need to by now removed. I take number of posts and
        // set every n-th element as 0 , where n=numberOfFyrOnDistance+1
        Integer[] zeroIndexes= new Integer[postNumber];
        for (int i = 0; i < postNumber; i++) {
            zeroIndexes[i]=fyrLengths.get(i*(1+numberOfFyrOnDistance));
        }

        for (int i = postNumber-1; i >=0 ; i--) {
            fyrLengths.remove(zeroIndexes[i]);
        }
        return fyrLengths;

    }
    //..................door Framing..........................//
    public static ArrayList<Material> doorFraming(int angle, int sideWallLength) {
        ArrayList<Material> doorMaterials = new ArrayList<>();
        int overDoorFyr=ConstructionSizeCalculator.raising(angle,sideWallLength-10);
        Integer[] fyrLengths= {200,200,200,overDoorFyr};
        for (int i = 0; i < 4; i++) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing-dør");
            fyr.setSize(fyrLengths[i]);
            doorMaterials.add(fyr);
        }

        Integer[]spaerSizes={200, 100,100,90, 90}; //acroos the door (180x90 cm), 2 over the door,two horizontal for door
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

        Material screwFyr  = new Material();
        screwFyr.setSize(24);
        screwFyr.setComment("Til montering af vertical framing-dør");
        doorMaterials.add(screwFyr);

        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setComment("til montering af horizontal framing-dør");
        screwSpaer.setSize(8);
        doorMaterials.add(screwSpaer);




        return doorMaterials;
    }



    //..........Materials for framing for all the given walls...........................//
    public static ArrayList<Material> wallMaterials(ArrayList<Wall> walls){
        ArrayList<Material> materials = new ArrayList<>();
        for (Wall wall:walls) {
            ArrayList wallMaterials = materialsForOneWallFraming(wall);
            materials.addAll(wallMaterials);
        }
        return materials;
    }

    //wood delivers in chosen length with cuts every 20 cm. Pricing is pr. meter. We order not shorter piece with
    // minimal possible length
    public static int countWoodLength(int needed) {
        if (needed % 20 == 0) {
            return needed;
        } else
            return (needed - (needed % 20) + 20);
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

}
