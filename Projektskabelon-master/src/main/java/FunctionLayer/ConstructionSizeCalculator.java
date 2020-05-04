package FunctionLayer;

/**
 * @author Magdalena
 */
public class ConstructionSizeCalculator {
    //todo some of the post are common for sides and the back - remember that when drowing or making itemlist
    //todo method counting shared posts
    //todo we need to update postHights with data about the length to be berried in the ground. We can also ask Tu if
    // the posts could be chosen to be set on a surface instead of in the ground

    //counts how many posts should there be on one side of a carport or a shed
    public  static int sidePostAmount(int size){
        int numberOfPost;
        size=size-10;
        if(size%300==0){ // 900cm -(3*300) =0
            numberOfPost=size/300+1;
        } else {
            numberOfPost= ( size - size%300)/300+2; //(750cm -(3*300) =0) 750%300=2 2*300=600 (150????)
        }
        return numberOfPost;
    }


    //counts distance between posts on the side
    public static int postDistanceMax300(int size) {
        return (size-10)/(sidePostAmount(size)-1);
    }

    //counts how much the roof drops/raises on the given distance in mm
    public static int raising(int angle, int distance){

        return (int) angle*10*distance/1000;
    }

    // fills up the array with heights of posts on the one side of the shed or carport starting from the shortest one
    public static Integer[] postsHeights(int height, int angle, int size){
        //todo when calculating postHeights of carport, int height should be the heighest one of shed posts
        int postNumber=sidePostAmount(size);
        int distance = postDistanceMax300(size);
        Integer[] postHeights = new Integer[postNumber];

            for (int i = 0; i < postHeights.length ; i++) {
                int tmp = height;
                height= tmp+ raising(angle, distance)*i;
                postHeights[i]=height;
            }

        return postHeights;
    }

    //counts how many rows of post should there be because max distans between posts is 600 cm from side to side
    public static int postRows (int width){
        int rows;
        if(width%600==0){
            rows=width/600+1;
        } else {
            rows=(width - width%600)/600 +2;
        }
        return  rows;
    }


        //////.........SHED FRONT SIDE ........../////////

    //counts number of post on the front side of the shed
    public static int shedFrontPostsAmount(int width) {
        //method cunts posts starting from the door not from the very first post. That missing post comes in door calculation
        width = width - 105;

        return sidePostAmount(width);
    }


    public void remPieces (Construction construction){
        //todo count witch lengths of "rem" tree chould be used so the connections ar in the right places if "rem"
        // should be compoused of more than one piece and return them in Integer[]

        /*
        først tjek om construction længde er mindre eller lige med 600
        if not: 1. lav en rem til shed (den bliver mac 3500 mm)
        2. fordel carports længde på 2 lige stykker eller find den stolpe det skal samles på
         3 havd så hvis skur er kun på halve af carportts bredde - hvor skal de samles henne??
         hvis brædde >6000 mm så rem antal gang 2???

         */
        //todo in ConstrucionMaterialCalculator implement the method that will return Material object for each of pieces
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
