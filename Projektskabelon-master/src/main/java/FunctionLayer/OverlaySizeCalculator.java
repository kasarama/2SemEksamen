package FunctionLayer;

import java.util.ArrayList;

public class OverlaySizeCalculator {

    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post
    public static int spaersNumberOnSide(int length, int minHeight, int angle) {
        int spaersAmount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(minHeight, angle, length);
        for (int i = 0; i < postsheights.length - 1; i++) { //+1 because there is one more post than distances
            int tmp = spaersAmount + 1;//
            spaersAmount = tmp + postsheights[i] / 1000; //counts number of distances between 2 spaers
        }
        return spaersAmount;

    }

    //calculates number of screws for spar (6cm)
    public static int screwSpaer(int spaernumber) {
        return spaernumber * 2 * 2; //2 screws on each side of spaer
    }

    public static int numberOfFyrOnDistance(int distance) {
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
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distance);
        return numberOfFyrOnDistance * distancesNumber;
    }


    //calculates number of screws for fyr (4cm)
    public static int screwFyr(int fyrnumber, int spaernumber) {
        return fyrnumber * spaernumber; //1 screws on each  spaer
    }

    //returns array with length of each fyr used on chosen side
    /*

     */
    public static ArrayList<Integer> fyrLengths(int height, int angle, int size) { //todo we need to decide if the height of construction is counted to the lower edge of rem or the upper one.
        ArrayList<Integer> fyrLengths = new ArrayList<>();
        int allLengths = numberOfFyrOnDistance(size - 100) + 2; // treats posts as fyr and counts them all, counts from the centre of first post to the centre of last post ;
        int postNumber = ConstructionSizeCalculator.sidePostAmount(size);
        int distance = size / (allLengths - 1);
        int distanceOfPosts = ConstructionSizeCalculator.postDistanceMax3000(size);
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distanceOfPosts);
        fyrLengths.add(height); //the first post has height of the start(given) height

        for (int i = 1; i < allLengths; i++) {
            int tmp = height;
            height = tmp + ConstructionSizeCalculator.raising(angle, distance); // calculates height of the element on given distance
            fyrLengths.add(height - 360); //adds calculated height and each fyr to the list (there shold be in total 360 mm distance betwin the ground and the roof spear
        }

        //on the list there are also posts that need to by now removed. I take number of posts and
        // set every n-th element as 0 , where n=numberOfFyrOnDistance+1
        Integer[] zeroIndexes = new Integer[postNumber];
        for (int i = 0; i < postNumber; i++) {
            zeroIndexes[i] = fyrLengths.get(i * (1 + numberOfFyrOnDistance));
        }

        for (int i = postNumber - 1; i >= 0; i--) {
            fyrLengths.remove(zeroIndexes[i]);
        }
        return fyrLengths;

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



    public static int overlaySpending(String materialName, double areal) throws LoginSampleException {
        //todo fix DB !!!!!!
        // double spending = MaterialMapper.spending(materialName);
        double actual = 5; // spending * areal;
        actual = actual + 0.05 * actual; //5 % extra material for cuts

        if (((actual * 10) % 10) == 0) {
            return (int) actual;
        } else {
            return (int) actual + 1;
        }

    }


    //to be able to calculate the needed amount of some material for overlay, we need to know the areal surface that's going to be covered
    public static double areal(int width, int length, int angle) {
        double raising = ConstructionSizeCalculator.raising(angle, length);
        int backWall = width * 2000;
        double sideWall = (length * 2000) + (length * raising / 2);
        double frontWall = width * (2000 + raising);
        double areal = (backWall + 2 * sideWall + frontWall) / 1000 / 1000;
        return areal;
    }

    public static double allWallsAreal(Construction construction) {
        ArrayList<Wall> allWalls = construction.getShed().getWalls();
        allWalls.addAll(construction.getWalls());
        double areal = 0;
        for (Wall wall : allWalls) {
            areal = wall.getLength() * wall.getMinHeight()
                    + 0.5 * ConstructionSizeCalculator.raising(wall.getRaising(), wall.getLength()) * wall.getLength();
        }
        return areal;
    }



    //wood delivers in chosen length with cuts every 20 cm. Pricing is pr. meter. We order not shorter piece with
    // minimal possible length
    public static int countWoodLength(int needed) {
        if (needed % 20 == 0) {
            return needed;
        } else
            return (needed - (needed % 20) + 20);
    }



}
