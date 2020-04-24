package FunctionLayer;

import java.util.ArrayList;

public class ShedSizing {

<<<<<<< HEAD
    public static ArrayList<ArrayList> possibleSizes (Carport carportRequest, int version) {
=======
    public static ArrayList<ArrayList> possibleSizes (Carport carportRequest, String position) throws LoginSampleException {
>>>>>>> employee


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


<<<<<<< HEAD
    public static ArrayList<ArrayList> version1(Carport carport) {
=======
    public static ArrayList<ArrayList> version1(Carport carportRequest) {
        /*
        calculates and returnes possible sizes of a shed located on a left or right side of a carport
         */
>>>>>>> employee
        ArrayList<ArrayList> siezeLists = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> depths = new ArrayList<>();

        int minWidth =100;
<<<<<<< HEAD
        int maxWidth = carport.getWidth()-300-15;
        if (minWidth<10){
            for (int i = 10; i <= maxWidth/10 ; i++) {
                widths.add(i*10);
            }
        } else {
            for (int i = minWidth/10; i < maxWidth/10; i++) {
                widths.add(i*10);

            }
        }
        siezeLists.add(widths);

        if (carport.getWidth()<=715){
=======
        int maxWidth = carportRequest.getWidth()-300-15;

        if (carportRequest.getWidth()<=715){ //chcecks if the carport is wider than 715 for if it is, the max width of a carport after building a shed cannot be more than 600cm and the minimum width f a shed is 100 cm plus there is 15 cm space rom the very end of the roof to the wall of the shed
>>>>>>> employee
            for (int i = 10; i <= maxWidth/10 ; i++) {
                widths.add((i*10));
            }
            siezeLists.add(widths);
        } else {
<<<<<<< HEAD
            minWidth = carport.getWidth()-600-15;
            for (int i = minWidth/10; i <= maxWidth/10 ; i++) {
=======
            minWidth = carportRequest.getWidth()-600-15;
            for (int i = minWidth/10; i <= (maxWidth/10) ; i++) {
>>>>>>> employee
                widths.add(i*10);
            }
            siezeLists.add(widths);
        }

<<<<<<< HEAD
        ArrayList<Integer> depths = new ArrayList<>();
        for (int i = 10; i < (carport.getLength()-30)/10; i++) {
=======
        for (int i = 10; i < ((carportRequest.getLength()-30)/10); i++) {
>>>>>>> employee
            depths.add(i*10);
        }
        siezeLists.add(depths);
        return siezeLists;
    }

    public static ArrayList<ArrayList> version2(Carport carportRequest) {
<<<<<<< HEAD
=======
        /*
        calculates and returnes possible sizes of a shed located on the back side of a carport
         */
>>>>>>> employee
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

<<<<<<< HEAD
    public static ArrayList<ArrayList> version3(Carport carportRequest) {
        ArrayList<ArrayList> siezeLists = new ArrayList<>();
=======
        for (int i = minDepth/10; i <=maxDepth ; i++) {
            depths.add(i*10);
        }
>>>>>>> employee

        return siezeLists;
    }

}
