package FunctionLayer;

/**
 * @author Magdalena
 * Hvilken størrelse af materiale
 */
public class ConstructionSizeCalculator {
    //todo some of the post are common for sides and the back - remember that when drowing or making itemlist
    //todo method counting shared posts
    //todo we need to update postHights with data about the length to be berried in the ground. We can also ask Tu if
    // the posts could be chosen to be set on a surface instead of in the ground

    final private  static int POSTSIZE=100;
    final private  static int CMPERM=100;
    final private  static int MAXPOSTDISTANCE=3000;
    final private  static int MAXROWSISTANCE=6000;
    final private  static int DOORWIDTH=1000;




    //counts how many posts should there be on one side of a carport or a shed
    public  static int sidePostAmount(int size){
        int numberOfPost;
        size=size-POSTSIZE;
        if(size%MAXPOSTDISTANCE==0){ //
            numberOfPost=size/MAXPOSTDISTANCE+1;
        } else {
            numberOfPost= ( size - size%MAXPOSTDISTANCE)/MAXPOSTDISTANCE+2; //(750cm -(3*300) =0) 750%300=2 2*300=600 (150????)
        }
        return numberOfPost;
    }


    //counts distance between posts on the side
    public static int postDistanceMax3000(int size) {
        return (size-POSTSIZE)/(sidePostAmount(size)-1);
    }

    //counts how much the roof drops/raises on the given distance in mm
    public static double raising(int angle, int distance){

        return  angle*distance/CMPERM;
    }

    // fills up the array with heights of posts on the one side of the shed or carport starting from the shortest one
    public static Integer[] postsHeights(double height, int angle, int size){
        //todo when calculating postHeights of carport, int height should be the heighest one of shed posts
        int postNumber=sidePostAmount(size);
        int distance = postDistanceMax3000(size);
        Integer[] postHeights = new Integer[postNumber];
        postHeights[0]=(int)height;
            for (int i = 1; i < postHeights.length ; i++) {
                height= height+ raising(angle, distance);
                postHeights[i]=(int)height;
                System.out.println();
            }

        return postHeights;
    }

    //counts how many rows of post should there be because max distans between posts is 600 cm from side to side
    public static int postRows (int width){
        int rows;
        if(width%MAXROWSISTANCE==0){
            rows=width/MAXROWSISTANCE+1;
        } else {
            rows=(width - width%MAXROWSISTANCE)/MAXROWSISTANCE +2;
        }
        return  rows;
    }


        //////.........SHED FRONT SIDE ........../////////

    //counts number of post on the front side of the shed
    public static int shedFrontPostsAmount(int width) {
        //method cunts posts starting from the door not from the very first post. That missing post comes in door calculation
        width = width - DOORWIDTH-POSTSIZE/2;

        return sidePostAmount(width);
    }

    public static int carportMinHeight(int constuctionsMinHeight,int shedDepth, int raising) {
        //todo returns length of the lowest post of carport
        return (int) (constuctionsMinHeight+raising(raising,shedDepth));
    }


    public int possibleRems(Construction construction, int carportLength){
        int[] possibleRems = new int[]{300, 360, 420, 480, 540, 600, 660, 720};
        carportLength = construction.getCarportLength();
        int wantedRem = 0;
        int difference = 0;
        // Iterating:
        for (int i = 0; i < possibleRems.length; i++){
            // For hver værdi i arrayet, hvis værdien (i) er under vores længde skal den næste bruges
            // Tag hver forskel, og find den nærmeste positive værdi
            difference = possibleRems[i]-carportLength;
            if (difference>=0){
                wantedRem = carportLength+difference;
                break;
            }
        }
        return wantedRem;
    }

    public int[] remPieces (Construction construction){
        //todo count witch lengths of "rem" tree chould be used so the connections ar in the right places if "rem"
        // should be compoused of more than one piece and return them in Integer[]
        /*
            Der findes 45*195: 300, 360, 420, 480, 540, 600, 660, 720
            Vi ved hvor langt der er mellem stolperne (postDistanceMax300)
            og hvor mange stolper der bliver brugt (sidePostAmount).
            1. Hvis længden er over 720 uden skur:
                Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                Samlet på 2. stolpe: (1*300 og 1*480)*2
            2. Hvis konstruktionens længde er over 720 (Det samme gælder hvis skuret kun fylder halvdelen - symetri):
                2A. Hvis carporten er under 720 og skuret er <= 300:
                    (1*tættestPåCarportLængde og 1*300)*2
                2B. Hvis carporten er under 720 og skuret er under 360:
                    (1*tættestPåCarportLængde og 1*360)*2
                2C. Hvis carporten er over 720 og skuret er <= 300:
                    (1*Punkt1 og 1*300)*2
                2D. Hvis carporten er over 720 og skuret er under 360:
                    (1*Punkt1 og 1*360)*2
            3. Hvis bredden er over 600:
                Så skal alt overstående lægges 1 til

        først tjek om construction længde er mindre eller lige med 600
        if not: 1. lav en rem til shed (den bliver mac 3500 mm)
        2. fordel carports længde på 2 lige stykker eller find den stolpe det skal samles på
        3 havd så hvis skur er kun på halve af carportts bredde - hvor skal de samles henne??
        hvis brædde >6000 mm så rem antal gang 2???
         */
        //todo in ConstrucionMaterialCalculator implement the method that will return Material object for each of pieces
        int[] remPieces = null;
        int constructionWidth = construction.getConstructionWidth();
        int constructionLength = construction.getCarportLength() + construction.getShedDepth();
        int carportLength = construction.getCarportLength();
        int shedDept = construction.getShedDepth();
        int tmpRem = possibleRems(construction, carportLength);
        // Hvis noShed = 0 er der ikke noget skur
        int noShed = construction.getShedDepth();

        if (constructionWidth<6000){
            if (carportLength>7200 && noShed == 0){
                // Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                // Samlet på 2. stolpe: (1*300 og 1*480)*2
                remPieces = new int[]{300, 300, 480, 480};
            } else if (constructionLength>720){
                if (carportLength<=720 && shedDept<=300){
                    // (1*tættestPåCarportLængde og 1*300)*2
                    remPieces = new int[]{tmpRem, tmpRem, 300, 300};
                } else if (carportLength<=720 && shedDept<360){
                    // (1*tættestPåCarportLængde og 1*360)*2
                    remPieces = new int[]{tmpRem, tmpRem, 360, 360};
                } else if (carportLength>720 && shedDept<=300){
                    // (1*Punkt1 og 1*300)*2
                    remPieces = new int[]{300, 300, 480, 480, 300, 300};
                } else if (carportLength>720 && shedDept<360){
                    // (1*Punkt1 og 1*360)*2
                    remPieces = new int[]{300, 300, 480, 480, 360, 360};
                }
            }
        } else {
            if (carportLength>7200 && noShed == 0){
                // Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                // Samlet på 2. stolpe: (1*300 og 1*480)*3
                remPieces = new int[]{300, 300, 300, 480, 480, 480};
            } else if (constructionLength>720){
                if (carportLength<=720 && shedDept<=300){
                    // (1*tættestPåCarportLængde og 1*300)*3
                    remPieces = new int[]{tmpRem, tmpRem, tmpRem, 300, 300, 300};
                } else if (carportLength<=720 && shedDept<360){
                    // (1*tættestPåCarportLængde og 1*360)*3
                    remPieces = new int[]{tmpRem, tmpRem, tmpRem, 360, 360, 360};
                } else if (carportLength>720 && shedDept<=300){
                    // (1*Punkt1 og 1*300)*3
                    remPieces = new int[]{300, 300, 300, 480, 480, 480, 300, 300, 300};
                } else if (carportLength>720 && shedDept<360){
                    // (1*Punkt1 og 1*360)*3
                    remPieces = new int[]{300, 300, 300, 480, 480, 480, 360, 360, 360};
                }
            }
        }
        return remPieces;
    }

    public void remScrewsNumner (Construction construction){
        //todo return number of screw used to montage of rem on the posts. Use the method remPieces
        //todo in ConstrucionMaterialCalculator implement method that will return a material of that screw with size that equals this number

    }

    public void roofSpaerLength (Construction construction) {
        //todo return lengths of spaer
        /*
        brædde >600
         */
    }
    public void roofSpaernumber (Construction construction){
        //todo return number of spaer needed for whole construction length
        //todo in ConstrucionMaterialCalculator implement method that will return  2 Materials of beslag
        // - one for left and one for right with amount of number of spaer and one Material that is the beslag skruer where the amount is roofSpaernumber x2x3x3

    }
    public void holeTapeSkrews (Construction construction) {
        //todo implement a method in ConstructionMaterialCalculator that returns hulbånd material , make sure that it is not possible that the crossing piece is longer than 10 m
        //todo return amount of screw needed for montage of that tape

    }
    public void underSternLengths(Construction construction) {
        //todo caount pieces needet to build a under stern take to consideration that they might need to be connected on the certain length (på middten)
        //todo in ConstrucionMaterialCalculator implement method that will return Materials of that tree for each piece
    }

    public void sternScrewNumber(Construction construction) {
        //todo count number of screws needet for montage of both Sterns
        //todo in ConstrucionMaterialCalculator implement method that will return Material of that screw with its size that equals this number
    }


    public void overSternLengths(Construction construction) {
        //todo caount pieces needet to build a under stern take to consideration that they might need to be connected on the certain length
        //todo in ConstrucionMaterialCalculator implement method that will return Materials of that tree for each piece
    }

}
