package FunctionLayer;

import DBAccess.MaterialMapper;

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
        int spaerlength= ConstructionSizeCalculator.postDistanceMax3000(wall.getLength());
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

        /*
int available = katarzynaMetode (very nice);
screwSpear.setAvailabke (available)
         */

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
        int spaersAmount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(minHeight, angle, length);
        for (int i = 0; i < postsheights.length-1; i++) { //+1 because there is one more post than distances
            int tmp = spaersAmount+1;//
            spaersAmount = tmp + postsheights[i] / 1000; //counts number of distances between 2 spaers
        }
        return spaersAmount;

    }

    //calculates number of screws for spar (6cm)
    public static int screwSpaer(int spaernumber) {
        return spaernumber * 2 * 2; //2 screws on each side of spaer
    }

    public static int numberOfFyrOnDistance(int distance){
        int numberOfFyrOnDistance;
        if (distance % 600 == 0) {
            numberOfFyrOnDistance = (distance / 600) - 1;
        } else {
            numberOfFyrOnDistance = (distance - distance % 600) / 600;
        }
        return numberOfFyrOnDistance;
    }

    //counts number of fyr on each distance and in total on chosen side
    public static int fyrNumberOnSide(int length) {
        int distance = ConstructionSizeCalculator.postDistanceMax3000(length);
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
    public static ArrayList<Integer> fyrLengths(int height, int angle, int size){ //todo we need to decide if the height of construction is counted to the lower edge of rem or the upper one.
        ArrayList<Integer> fyrLengths = new ArrayList<>();
        int allLengths=numberOfFyrOnDistance(size-100)+2; // treats posts as fyr and counts them all, counts from the centre of first post to the centre of last post ;
        int postNumber= ConstructionSizeCalculator.sidePostAmount(size);
        int distance = size/(allLengths-1);
        int distanceOfPosts= ConstructionSizeCalculator.postDistanceMax3000(size);
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distanceOfPosts);
        fyrLengths.add(height); //the first post has height of the start(given) height

            for (int i = 1; i < allLengths; i++) {
                int tmp = height;
                height = tmp + ConstructionSizeCalculator.raising(angle, distance); // calculates height of the element on given distance
                fyrLengths.add(height-360); //adds calculated height and each fyr to the list (there shold be in total 360 mm distance betwin the ground and the roof spear
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
        int overDoorFyr=ConstructionSizeCalculator.raising(angle,sideWallLength-100);
        Integer[] fyrLengths= {1640,1640,1640,overDoorFyr};
        for (int i = 0; i < 4; i++) {
            Material fyr = new Material();
            fyr.setName("19X50 MM BRÆDDER FYR");
            fyr.setComment("Vertical framing-dør");
            fyr.setSize(fyrLengths[i]);
            doorMaterials.add(fyr);
        }

        Integer[]spaerSizes={1640,1000,1000,900, 900}; //acroos the door (180x90 cm), 2 over the door,two horizontal for door
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
    https://youtu.be/GHwnJH_n4q4 HardiPlank
    https://www.youtube.com/watch?v=ovbLedbDQUA
    https://www.10-4.dk/varer/byggematerialer/trae/beklaedningsbraedder/25x125mm-klinkbeklaedning-tryk-1432825125300?gclid=Cj0KCQjw17n1BRDEARIsAFDHFey9ARt6e_0jQkOYRhKuj4egHaKtd_JTND164NF9BZA9ptSG0MEYV0YaAvT9EALw_wcB
    https://www.johannesfog.dk/byggecenter/produkter/222X145_GRAN_KLINK_BEKL__SORT1/
     */
    //.................Plank montage..............//
    /*
    On fog webpage we can find spending of serten material per kvadrat meter. This data ar being located i DB
     */

    //to be able to calculate the needed amount of some material for overlay, we need to know the areal surface that's going to be covered
    public static double areal(int width, int length, int angle){
        double raising=ConstructionSizeCalculator.raising(angle,length);
        int backWall=width*2000;
        double sideWall=(length*2000)+(length*raising/2);
        double frontWall=width*(2000+raising);
        double areal=(backWall+2*sideWall+frontWall)/1000/1000;
        return areal;
    }


    public static int overlaySpending(String materialName, double areal) throws LoginSampleException {
        //todo remember to handle that if method returns 0
        double spending = MaterialMapper.spending(materialName);
        double actual = spending*areal;
        actual=actual+0.05*actual; //5 % extra material for cuts

        if ( ((actual*10)%10) ==0 ){
            return (int) actual;
        }
        else {
            return (int) actual+1;
        }

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
