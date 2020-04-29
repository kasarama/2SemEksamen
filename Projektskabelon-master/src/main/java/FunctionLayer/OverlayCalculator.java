package FunctionLayer;

import java.util.ArrayList;


/**
 * @author Magdalena
 */
public class OverlayCalculator {
    //gets list with materials of all the elements of overlay and sets them on one list of materials
    public static ArrayList<Material> materialList(Carport carport) {
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


    //calculates spaer needed for one of the chosen sides of shed/carport/construction
    // max distance between spaer is 100 cm - counts number of spar after each post
    public static int spaersNumberOnSide(int length, int minHeight, int angle, boolean isPitched) {
        int sparsAmount = 0;
        Integer[] postsheights = PostCalculator.postsHeights(minHeight, angle, length, isPitched);
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
        int distance = PostCalculator.postDistanceMax300(length);
        int distancesNumber = PostCalculator.sidePostAmount(length) - 1;
        int numberOfFyrOnDistance=numberOfFyrOnDistance(distance);

        return numberOfFyrOnDistance * distancesNumber;
    }

    //calculates number of screws for fyr (4cm)
    public static int screwFyr(int fyrnumber, int spaernumber) {
        return fyrnumber * spaernumber; //1 screws on each  spaer
    }

    //returns array with length of each fyr used on chosen side
    public static ArrayList<Integer> fyrLengths(int height, int angle, int size, boolean isPitched, int fyrnumber){
        ArrayList<Integer> fyrLengths = new ArrayList<>();
        int postNumber=PostCalculator.sidePostAmount(size);
        int distance = size/(postNumber+fyrnumber-1);
        int distanceOfPosts=PostCalculator.postDistanceMax300(size);
        int numberOfFyrOnDistance = numberOfFyrOnDistance(distanceOfPosts);
        int fyrPlusPost=fyrnumber+postNumber;
        if (isPitched){
            for (int i = 0; i < fyrPlusPost; i++) {
                fyrLengths.add(height);
            }
        } else {
            for (int i = 0; i < fyrPlusPost; i++) {
                int tmp = height;
                height = tmp + PostCalculator.raising(angle, distance) * i;
                fyrLengths.add(height);
            }
        }

        //on the list there are also posts that need to by now removed. I take number of posts and
        // set every n-th element as 0 , where n=numberOfFyrOnDistance+1
        for (int i = 0; i < postNumber; i++) {
            fyrLengths.add(i*(1+numberOfFyrOnDistance), 0);
        }

        return fyrLengths;
    }

    //Materials for  Shed framing
    public static ArrayList<Material> shedFramingMaterials(int width, int length, int minHeight, int angle, boolean isPitched){
        ArrayList<Material>framingMaterials =new ArrayList<>();
        int sideSpaerNumber=spaersNumberOnSide( length,  minHeight,  angle,  isPitched);
        


        return framingMaterials;
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
