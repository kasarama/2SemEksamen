package FunctionLayer;

import PresentationLayer.Materials;

import java.util.ArrayList;

public class OverlayCalculator {

    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> materialList(Carport carport) {
        ArrayList<Material> materialList= new ArrayList<>();
        ArrayList<ArrayList> listsOfElements = new ArrayList<>();

        listsOfElements.add(framingH(carport));
        //todo add the list of all the other elemnts




        for (ArrayList<Material> list: listsOfElements ) {
            for (Material material : list ) {
                materialList.add(material);
            }

        }

        return  materialList;
    }


    public void framingV(){
        /*
        todo list of materials needed to montage vertical framing
         */
        /*
        belka pozioma, max dlugosc
         */
    }

    //Materials for horizontal framing
    public static ArrayList<Material> framingH(Carport carport){
        ArrayList<Material>framingH = new ArrayList<>();
        //todo list of materials needed to montage horizontal framing :
        // spær+, beslag-, tape-
        //b

        //sides:
        int sidePost=shedSidePostsAmount(carport);
        Material spaereSide = new Material();
        int spaereSidesLength = shedSidePostDistance(carport);
        spaereSide.setName("RAW Spærtræ C18 47x100 mm");
        spaereSide.setUnit("cm");
        spaereSide.setSize(countWoodLength(spaereSidesLength));
        int spaereSideAmount= 3*(sidePost-1)*2; // there is 3of them between every two posts, on both sides of shed

        for (int i = 0; i < spaereSideAmount; i++) {
            framingH.add(spaereSide);
        }

        int backPost=shedBackPostsAmount(carport);
        Material spaereBack = new Material();
        int spaereBackLength = shedBackPostDistance(carport);
        spaereSide.setName("RAW Spærtræ C18 47x100 mm");
        spaereSide.setUnit("cm");
        spaereSide.setSize(countWoodLength(spaereBackLength));
        int spaereBackAmount= 3*(backPost-1); // there is 3of them between every two posts

        for (int i = 0; i < spaereBackAmount; i++) {
            framingH.add(spaereBack);
        }



        return framingH;
    }

    //wood delivers in chosen length with cuts every 20 cm. Pricing is pr. meter. We order not shorter piece with
    // minimal possible length
    public static int countWoodLength(int needed){
        if (needed%20==0){
            return needed;
        } else
            return (needed- (needed%20) +20);
    }



    //............CARPORT WALLS.............//

    // counts number of post on the side
    public static int carportSidePosts (Carport carport){
        int numberOfPost;
        if(carport.getLength()%300==0){
            numberOfPost=carport.getLength()/300+1;
        } else {
            numberOfPost= ( carport.getLength() - carport.getLength() % 300)/300+2;
        }
        return numberOfPost;
    }

    //counts distance between posts of carport
    public static int carportPostDistance(Carport carport){
        return (carport.getLength()-10)/(carportSidePosts(carport)-1);

    }

    //counts how many rows of post should there be because max distans between posts is 600 cm from side to side
    public static int postRows (Carport carport){
        int rows;
        if(carport.getWidth()%600==0){
            rows=carport.getLength()/600+1;
        } else {
            rows=(carport.getWidth() - carport.getWidth()%600)/600 +2;
        }
        return  rows;
    }



    //............SHED WALLS.............//

    //counts number of post for shed on the side
    public static int shedSidePostsAmount(Carport carport){
        int depth= carport.getShed().getDepth();
        int numberOfPosts;
            if (depth % 300 == 0) {
                numberOfPosts = (depth - 10) / 300 +1;
            } else {
                numberOfPosts =(depth - depth%300)/300 + 2;
            }
            //todo some of the post are common for carport and the shed - remember that when drowing or making itemlist
        return numberOfPosts;
    }


    //counts distance between posts of shed's sides
    public static int shedSidePostDistance(Carport carport){

        return (carport.getShed().getDepth()-10)/(shedSidePostsAmount(carport)-1);
    }


    //counts number of post on the back side of the shed
    public static int shedBackPostsAmount(Carport carport) {
        int width = carport.getShed().getWidth();
        int numberOfPosts;
        if (width % 300 == 0) {
            numberOfPosts = (width - 10) / 300 + 1;
        } else {
            numberOfPosts = (width - width % 300) / 300 + 2;
        }
        return numberOfPosts;
        //todo some of the post are common for sides and the back - remember that when drowing or making itemlist

    }


    //counts distance between posts of shed's backside
    public static int shedBackPostDistance(Carport carport){

        return (carport.getShed().getWidth()-10)/(shedBackPostsAmount(carport)-1);
    }


    //counts number of post on the back side of the shed
    public static int shedFrontPostsAmount(Carport carport) {
        int width = carport.getShed().getWidth();
        int numberOfPosts;
        if ((width-100) % 300 == 0) {
            numberOfPosts = (width - 10) / 300 + 1;
        } else {
            numberOfPosts = (width - width % 300) / 300 + 2;
        }
        return numberOfPosts;
        //todo some of the post are common for sides and the back - remember that when drowing or making itemlist

    }


    //counts distance between posts of shed's front side
    public static int shedFrontSidePostDistance(Carport carport){

        return (carport.getShed().getWidth()-100-10)/(shedFrontPostsAmount(carport)-1);
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
