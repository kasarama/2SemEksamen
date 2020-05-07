package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class OverlaySizeCalculator {
    final private  static int FYRMAXDISTANCE=600;
    final private  static int POSTSIZE=100;
    final private  static int MMPERM=1000;
    final private  static double SECURITYPERCENTAGE=0.05;


    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post

    public static int spaerOnOneWall(Wall wall) {
        int amount = 0;
        Integer[] postsheights = ConstructionSizeCalculator.postsHeights(wall.getMinHeight(),
                wall.getRaising(), wall.getLength());

        for (int i = 0; i < postsheights.length - 1; i++) { //+1 because there is one more post than distances
            int tmp = amount + 1;//
            amount = (int) (tmp + postsheights[i] / MMPERM); //counts number of distances between 2 spaers
        }
        return amount;
    }


    //.............calculates number of screws for spar (6cm)...........//
    public static int screwSpaer(int spaernumber) {

        return spaernumber * 2 * 2; //2 screws on each side of spaer
    }


    //................calculates number of fyr pr wall.......................//
    public static int fyrNumberOnWall(Wall wall) {
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
                System.out.println("idex of fyr: " + i + ", height: " + fyrLength);
            }
        }

        return fyrLengthsOneWall;
    }

    //................................. counts surface of a given wall.................//
    public static double oneWallArea(Wall wall){
        //to be able to calculate the needed amount of some material for overlay, we need to know the area of
        // surface that's going to be covered
        double area=-1;
        /*Trapez area: (a+b)/2*h
        a=minHeight, b= maxHeight, h= length
         */
        int maxHeight=(int) (wall.getMinHeight()+ConstructionSizeCalculator.raising(wall.getRaising(),wall.getLength()));
        System.out.println("minH="+wall.getMinHeight()+", maxH="+maxHeight+", wallLength="+wall.getLength());
        area=((wall.getMinHeight()+maxHeight)) /2*wall.getLength();

        System.out.println("area: "+area); //returnes valeu in mm

        return area;
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





    public static double allWallsArea(Construction construction) {
        ArrayList<Wall> allWalls = new ArrayList<>();
        ArrayList<Wall> shedWalls = construction.getShed().getWalls();
        System.out.println("walls in construction: "+construction.getWalls().size());

        int backSideindex=-1;
        int frontSideindex=-1;

        for (Wall wall: shedWalls) {
            if (!wall.getSide().equals("front")){
                allWalls.add(wall);
            }

        }
        for (Wall wall: shedWalls ) {
            if(wall.getSide().equals("back")){
                backSideindex= shedWalls.indexOf(wall);
            }
        }
        for (Wall wall: shedWalls) {
            if (wall.getSide().equals("front")) {
                System.out.println("first length: "+wall.getLength());
                wall.setLength(shedWalls.get(backSideindex).getLength());
                System.out.println("new length: "+wall.getLength());

                allWalls.add(wall);
            }
        }
        allWalls.addAll(construction.getWalls());

        double totalArea = 0;
        for (int i = 0; i < allWalls.size() ; i++) {

            double area=oneWallArea(allWalls.get(i));
            totalArea=totalArea+area;
            System.out.println("wall: "+allWalls.get(i)+" area: "+ area+"\n"+"total Area:" +totalArea+"\n");
        }

        return totalArea/MMPERM/MMPERM;
    }

    public static int overlaySpending(String materialName, double area) throws LoginSampleException {
        //todo fix DB !!!!!!

        //double spending = MaterialMapper.spending(materialName);
        double needed = 5; // spending * area;
        needed = needed + SECURITYPERCENTAGE * needed; //5 % extra material for cuts

        if (((needed * 10) % 10) == 0) {
            return (int) needed;
        } else {
            return (int) needed + 1;
        }

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