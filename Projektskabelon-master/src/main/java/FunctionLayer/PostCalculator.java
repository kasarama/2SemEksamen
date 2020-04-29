package FunctionLayer;

/**
 * @author Magdalena
 */
public class PostCalculator {
    //todo some of the post are common for sides and the back - remember that when drowing or making itemlist

    //counts how many posts should there be on one side of a carport or a shed
    public  static int sidePostAmount(int size){
        int numberOfPost;
        if(size%300==0){
            numberOfPost=size/300+1;
        } else {
            numberOfPost= ( size - size % 300)/300+2;
        }
        return numberOfPost;
    }


    //counts distance between posts on the side
    public static int postDistanceMax300(int size){
        return (size-10)/(sidePostAmount(size)-1);
    }

    //counts how much the roof drops/raises on the given distance
    public static int raising(int angle, int distance){
        return (int) angle*distance/100;
    }

    // fills up the array with heights of posts on the one side of the shed or carport starting from the shortest one
    public static Integer[] postsHeights(int height, int angle, int size, boolean isPitched){
        int postNumber=sidePostAmount(size);
        int distance = postDistanceMax300(size);
        Integer[] postHeights = new Integer[postNumber];

        if (isPitched){
            for (int i = 0; i <postHeights.length ; i++) {
                postHeights[i]=height;
            } }else {
            for (int i = 0; i < postHeights.length ; i++) {
                int tmp = height;
                height= tmp+ raising(angle, distance)*i;
                postHeights[i]=height;
            }
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








}
