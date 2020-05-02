package FunctionLayer;

import java.util.ArrayList;


/**
 * @author Magdalena
 */
public class OverlayCalculator {
    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> materialList(Construction construction) {
        ArrayList<Material> materialList = new ArrayList<>();
        ArrayList<ArrayList> listsOfElements = new ArrayList<>();

        //todo add the list of all the other elemnts

        for (ArrayList<Material> list : listsOfElements) {
            for (Material material : list) {
                materialList.add(material);
            }
        }

        return materialList;
    }


    public static ArrayList<Material> materialsForWall(Wall wall){
        ArrayList<Material> materials = new ArrayList<>();

        Material spaer = new Material();
        spaer.setName("47X100 MM SPÆRTRÆ");
        int spaers = spaersNumberOnSide(wall.getLength(),wall.getMinHeight(),wall.getRaising());
        int spaerlength= ConstructionSizeCalculator.postDistanceMax300(wall.getLength());
        spaer.setSize(spaerlength);
        spaer.setKeyword("Horizontal framing");
        for (int i = 0; i < spaers; i++) {
            materials.add(spaer);
        }
        Material screwSpaer = new Material();
        screwSpaer.setName("5X80 MM RUST FRI SKRUER");
        screwSpaer.setKeyword("til montering af horizontal framing");
        int screwSpaeramount = screwSpaer(spaers);
        screwSpaer.setSize(screwSpaeramount);
        materials.add(screwSpaer);
        Material fyr = new Material();
        fyr.setName("19X50 MM BRÆDDER FYR");
        fyr.setKeyword("Vertical framing");
        int fyrsnumber= fyrNumberOnSide(wall.getLength());
        ArrayList<Integer> fyrHeights=fyrLengths(wall.getMinHeight(),wall.getRaising(),wall.getLength(),fyrsnumber);
        for (Integer height:fyrHeights
             ) {
            fyr.setSize(height);
            materials.add(fyr);
        }
        Material screwFyr  = new Material();
        screwFyr.setSize(screwFyr(fyrsnumber,spaers));
        screwFyr.setKeyword("Til montering af vertical framing");
        materials.add(screwFyr);



        return materials;
    }

    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post
    public static int spaersNumberOnSide(int length, int minHeight, int angle) {
        int sparsAmount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(minHeight, angle, length);
        for (int i = 0; i < postsheights.length - 1; i++) {
            int tmp = sparsAmount;
            sparsAmount = tmp + postsheights[i] / 100;
        }


        return sparsAmount;

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
    public static ArrayList<Integer> fyrLengths(int height, int angle, int size){
        ArrayList<Integer> fyrLengths = new ArrayList<>();
        int postNumber= ConstructionSizeCalculator.sidePostAmount(size);
        int distance = size/(postNumber+fyrNumberOnSide(size)-1);
        int distanceOfPosts= ConstructionSizeCalculator.postDistanceMax300(size);
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distanceOfPosts);
        int fyrPlusPost=fyrNumberOnSide(size)+postNumber;

            for (int i = 0; i < fyrPlusPost; i++) {
                int tmp = height;
                height = tmp + ConstructionSizeCalculator.raising(angle, distance) * i;
                fyrLengths.add(height);

        }

        //on the list there are also posts that need to by now removed. I take number of posts and
        // set every n-th element as 0 , where n=numberOfFyrOnDistance+1
        for (int i = 0; i < postNumber; i++) {
            fyrLengths.add(i*(1+numberOfFyrOnDistance), 0);
        }

        return fyrLengths;
    }

    //Materials for  Shed framing
    public static ArrayList<Material> wallMaterials(ArrayList<Wall> walls){
        ArrayList<Material> materials = new ArrayList<>();

        for (Wall wall:walls) {
            ArrayList wallMaterials = materialsForWall(wall);
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
