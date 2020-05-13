package FunctionLayer;

import DBAccess.MaterialMapper;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class OverlaySizeCalculator {
    final private static int FYRMAXDISTANCE = 600;
    final private static int POSTSIZE = 100;
    final private static int MMPERM = 1000;
    final private static int SPAERDISTANCE = 1000;
    final private static double SECURITYPERCENTAGE = 0.05;
    final private static int LENGTHOFOVERLAYPLANK = 3600;
    final private static int OVERLAP = 10;


    //..............calculates spaer needed for one of the chosen wall...........//

    public static int spaerOnOneWall(Wall wall) {
        // max distance between spaer is 100 cm - counts number of spar after each post
        int amount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(wall.getMinHeight(),
                wall.getRaising(), wall.getLength());

        for (int i = 0; i < postsheights.length - 1; i++) { //-1 because there is one more post than distances
            int tmp = amount + 1;//
            amount = (int) (tmp + postsheights[i] / SPAERDISTANCE); //counts number of distances between 2 spaers
        }
        return amount;
    }


    //..............calculates spaer længth for one of the chosen wall...........//
    public static int spaerLengthOneWall(Wall wall) {
        //spaer has length of distance between posts of one wall
        return ConstructionSizeCalculator.postDistanceMax3000(wall.getLength());

    }


    //.............calculates number of screws for spaer (6cm)...........//
    public static int screwSpaer(int spaerQuantity) {

        return spaerQuantity * 2 * 2; //2 screws on each side of spaer
    }


    //................calculates number of fyr pr wall.......................//
    public static int fyrQuantityOnWall(Wall wall) {
        int distance = wall.getLength() - POSTSIZE;
        int fyrPlusPost = 0;
        if (distance % FYRMAXDISTANCE == 0) {
            fyrPlusPost = (distance / FYRMAXDISTANCE) + 1;
        } else {
            fyrPlusPost = (distance - distance % FYRMAXDISTANCE) / FYRMAXDISTANCE + 2;
        }
        int justFyr = fyrPlusPost - ConstructionSizeCalculator.sidePostAmount(wall.getLength());
        return justFyr;
    }


    //...........calculates number of screws for fyr (4cm)...................//
    public static int screwFyr(int fyrQuantity, int spaerQuantity) {
        return fyrQuantity * spaerQuantity; //1 screws on each  spaer
    }


    //............creates a List with all needed lengths of fyrs pr one Wall..............//
    public static ArrayList<Integer> fyrLengthsOneWall(Wall wall) {
        ArrayList<Integer> fyrLengthsOneWall = new ArrayList<>();
        /*
        counts number of all vertical tree elements on one wall
        counts distance between them and raising pr that distance, counts on witch idex is there a post,
        calculates and adds height of every element that is not on index of post
         */
        int distance = wall.getLength() - POSTSIZE; // 100 mm for one post
        int fyrPlusPost = 0;
        if (distance % FYRMAXDISTANCE == 0) {
            fyrPlusPost = (distance / FYRMAXDISTANCE) + 1;
        } else {
            fyrPlusPost = (distance - distance % FYRMAXDISTANCE) / FYRMAXDISTANCE + 2;
        }

        int numberOfPosts = ConstructionSizeCalculator.sidePostAmount(wall.getLength());
        int postIndex = (fyrPlusPost - numberOfPosts) / (numberOfPosts - 1) + 1;
        int distanceBetweenFyr = distance / (fyrPlusPost - 1);
        double raising = ConstructionSizeCalculator.raising(wall.getRaising(), distanceBetweenFyr);
        for (int i = 1; i < fyrPlusPost; i++) {
            if (i % postIndex != 0) {
                int fyrLength = (int) (wall.getMinHeight() + raising * i);
                fyrLengthsOneWall.add(fyrLength);
            }
        }

        return fyrLengthsOneWall;
    }

    //................................. counts surface of a given wall.................//
    public static double oneWallArea(Wall wall) {
        //to be able to calculate the needed amount of some material for overlay, we need to know the area of
        // surface that's going to be covered
        long area = -1;
        /*Trapez area: (a+b)/2*h
        a=minHeight, b= maxHeight, h= length
         */

        int maxHeight = (int) (wall.getMinHeight() + ConstructionSizeCalculator.raising(wall.getRaising(), wall.getLength()));
        area = (long) ((((double)wall.getMinHeight() +(double) maxHeight)) / 2.0 * (double)wall.getLength());

        return area / (double) MMPERM / (double) MMPERM;
    }




    /*
    https://youtu.be/GHwnJH_n4q4 HardiPlank
    https://www.youtube.com/watch?v=ovbLedbDQUA
    https://www.10-4.dk/varer/byggematerialer/trae/beklaedningsbraedder/25x125mm-klinkbeklaedning-tryk-1432825125300?gclid=Cj0KCQjw17n1BRDEARIsAFDHFey9ARt6e_0jQkOYRhKuj4egHaKtd_JTND164NF9BZA9ptSG0MEYV0YaAvT9EALw_wcB
    https://www.johannesfog.dk/byggecenter/produkter/222X145_GRAN_KLINK_BEKL__SORT1/
    On fog webpage we can find spending of serten material per squer meter. This data ar being located i DB
     */


    public static double allWallsArea(Construction construction) {
        ArrayList<Wall> allWalls = new ArrayList<>();
        ArrayList<Wall> shedWalls = construction.getShed().getWalls();

        int backSideindex = -1;

        for (Wall wall : shedWalls) {
            if (!wall.getSide().equals("front")) {
                allWalls.add(wall);
            }

        }
        for (Wall wall : shedWalls) {
            if (wall.getSide().equals("back")) {
                backSideindex = shedWalls.indexOf(wall);
            }
        }
        for (Wall wall : shedWalls) {
            if (wall.getSide().equals("front")) {
                wall.setLength(shedWalls.get(backSideindex).getLength());

                allWalls.add(wall);
            }
        }
        allWalls.addAll(construction.getWalls());

        double totalArea = 0;
        for (int i = 0; i < allWalls.size(); i++) {

            double area = oneWallArea(allWalls.get(i));
            totalArea = totalArea + area;
        }
        return totalArea;
    }

    public static double overlaySpending(String materialName, double area) throws LoginSampleException {

        double spending = MaterialMapper.spending(materialName);
        double needed = 0;
        if (area==0) {
            return 0;
        } else
        if (materialName.equals("HARDIEPLANK 180X3600X8MM")) {
            needed = spending * area; //spending : how many pieces pr squwe meter
        } else {
            needed = spending * area ;
            needed= needed /  ((double)LENGTHOFOVERLAYPLANK /(double) MMPERM);
        }

        needed = needed + (SECURITYPERCENTAGE * needed); //5 % extra material for cuts
        return needed;


    }


    public static int overlayScrewOneWall(Wall wall, String overlayName) throws LoginSampleException {

        ArrayList<Integer> fyrLengthsOneWall = new ArrayList<>();
        /*
        counts number of all vertical tree elements on one wall
        counts distance between them and raising pr that distance,
        calculates and adds height of every element
         */
        int distance = wall.getLength() - POSTSIZE; // 100 mm for one post
        int fyrPlusPost = 0;
        if (distance % FYRMAXDISTANCE == 0) {
            fyrPlusPost = (distance / FYRMAXDISTANCE) + 1;
        } else {
            fyrPlusPost = (distance - distance % FYRMAXDISTANCE) / FYRMAXDISTANCE + 2;
        }
        int distanceBetweenFyr = distance / (fyrPlusPost - 1);
        double raising = ConstructionSizeCalculator.raising(wall.getRaising(), distanceBetweenFyr);
        for (int i = 0; i < fyrPlusPost; i++) {

            int fyrLength = (int) (wall.getMinHeight() + raising * i);
            fyrLengthsOneWall.add(fyrLength);
        }
        int width = MaterialMapper.getWidthByName(overlayName);
        if (overlayName.equals("HARDIEPLANK 180X3600X8MM")) {
            width = width - 2 * OVERLAP;
        } else width = width - OVERLAP;


        int quantity = 0;
        for (Integer length : fyrLengthsOneWall) {
            if (length % width == 0) {
                quantity = quantity + length / width;
            } else {
                quantity = quantity + ((length - (length % width)) + 1) / width;
            }
        }
        return quantity;
    }


    //wood delivers in chosen length with cuts every 20 cm. Pricing is pr. meter. We order not shorter piece with
    // minimal possible length
    public static int countWoodLength(int needed) {
        if (needed % 20 == 0) {
            return needed;
        } else
            return (needed - (needed % 20) + 20);
    }

    public static int overDoorSpearQuantity(int raising) {
        raising = raising - raising % SPAERDISTANCE;
        int quantity = (int) raising / SPAERDISTANCE + 1;

        return quantity;
    }


}