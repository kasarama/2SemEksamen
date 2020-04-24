package FunctionLayer;

import java.util.ArrayList;

public class ShedSizing {

    public static ArrayList<ArrayList> possibleSizes (Carport carportRequest, String position) throws LoginSampleException {


        if(position.equals("SL") || position.equals("SR")){
            return version1(carportRequest);
        } else {
            if(position.equals("BL") || position.equals("BR")){
                return version2(carportRequest);
            } else {
                throw new LoginSampleException("Jeg kunne ikke forså hvor skuren skal placeres");
            }
        }
    }


    public static ArrayList<ArrayList> version1(Carport carportRequest) {
        /*
        calculates and returnes possible sizes of a shed located on a left or right side of a carport
         */
        ArrayList<ArrayList> siezeLists = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> depths = new ArrayList<>();

        int minWidth =100;
        int maxWidth = carportRequest.getWidth()-300-15;

        if (carportRequest.getWidth()<=715){ //chcecks if the carport is wider than 715 for if it is, the max width of a carport after building a shed cannot be more than 600cm and the minimum width f a shed is 100 cm plus there is 15 cm space rom the very end of the roof to the wall of the shed
            for (int i = 10; i <= maxWidth/10 ; i++) {
                widths.add((i*10));
            }
            siezeLists.add(widths);
        } else {
            minWidth = carportRequest.getWidth()-600-15;
            for (int i = minWidth/10; i <= (maxWidth/10) ; i++) {
                widths.add(i*10);
            }
            siezeLists.add(widths);
        }

        for (int i = 10; i < ((carportRequest.getLength()-30)/10); i++) {
            depths.add(i*10);
        }
        siezeLists.add(depths);
        return siezeLists;
    }

    public static ArrayList<ArrayList> version2(Carport carportRequest) {
        /*
        calculates and returnes possible sizes of a shed located on the back side of a carport
         */
        ArrayList<ArrayList> siezeLists = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> depths = new ArrayList<>();

        int minWidth =100;
        int maxWidth =carportRequest.getWidth()-30;
        for (int i = (minWidth/10); i <= (maxWidth/10); i++) {
            widths.add((i*10));
        }
        int minDepth = 100;
        int maxDepth = carportRequest.getLength()-440-15;

        for (int i = minDepth/10; i <=maxDepth ; i++) {
            depths.add(i*10);
        }

        return siezeLists;
    }

}