package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class OverlaySizeCalculator {

    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post

    public static int spaerOnOneWall(Wall wall) {
        int amount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(wall.getMinHeight(),
                wall.getRaising(), wall.getLength());

        for (int i = 0; i < postsheights.length - 1; i++) { //+1 because there is one more post than distances
            int tmp = amount + 1;//
            amount = (int) (tmp + postsheights[i] / 1000); //counts number of distances between 2 spaers
        }
        return amount;
    }


    //.............calculates number of screws for spar (6cm)...........//
    public static int screwSpaer(int spaernumber) {

        return spaernumber * 2 * 2; //2 screws on each side of spaer
    }


    //................calculates number of fyr pr wall.......................//
    public static int fyrNumberOnWall(Wall wall) {
        int distance = wall.getLength() - 100;
        int fyrPlusPost = 0;
        if (distance % 600 == 0) {
            fyrPlusPost = (distance / 600) + 1;
        } else {
            fyrPlusPost = (distance - distance % 600) / 600 + 2;
        }
        int justFyr = fyrPlusPost - ConstructionSizeCalculator.sidePostAmount(wall.getLength());
        return justFyr;
    }


    //...........calculates number of screws for fyr (4cm)...................//
    public static int screwFyr(int fyrnumber, int spaernumber) {
        return fyrnumber * spaernumber; //1 screws on each  spaer
    }


    //............creates a List with all needed lengths of fyrs pr one Wall..............//
    public static ArrayList<Integer> fyrLengthsOneWall(Wall wall) {
        ArrayList<Integer> fyrLengthsOneWall = new ArrayList<>();
/*
counts number of all vertical tree elements on one wall
counts distance between them and raising pr that distance, counts on witch idex is there a post,
calculates and adds height of every element that is not on index of post
 */
        int distance = wall.getLength() - 100; // 100 mm for one post
        int fyrPlusPost = 0;
        if (distance % 600 == 0) {
            fyrPlusPost = (distance / 600) + 1;
        } else {
            fyrPlusPost = (distance - distance % 600) / 600 + 2;
        }

        int numberOfPosts = ConstructionSizeCalculator.sidePostAmount(wall.getLength());
        int postIndex = (fyrPlusPost - numberOfPosts) / (numberOfPosts - 1) + 1;
        int distanceBetweenFyr = distance / (fyrPlusPost - 1);
        double raising = ConstructionSizeCalculator.raising(wall.getRaising(), distanceBetweenFyr);
        for (int i = 1; i < fyrPlusPost; i++) {
            if (i % postIndex != 0) {
                int fyrLength = (int) (wall.getMinHeight() + raising * i);
                fyrLengthsOneWall.add(fyrLength);
                System.out.println("idex of fyr: " + i + ", height: " + fyrLength);
            }
        }

        return fyrLengthsOneWall;
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

    public static double wallAreal(Wall wall){
        double areal=-1;
        /*Trapez areal: (a+b)/2*h
        a=minHeight, b= maxHeight, h= length
         */
        int maxHeight=(int) ConstructionSizeCalculator.raising(wall.getRaising(),wall.getLength());
        areal=(wall.getMinHeight()+maxHeight)/2*wall.getLength();

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