package FunctionLayer;

import java.util.ArrayList;

public class ShedSizing {

    public static ArrayList<ArrayList> possibleSizes (CarportRequest carportRequest, int version) {

        if(version==1){
            return version1(carportRequest);
        } else {
            if(version==2){
                return version2(carportRequest);
            } else {
                return version3(carportRequest);
            }
        }
    }


    public static ArrayList<ArrayList> version1(CarportRequest carportRequest) {
        ArrayList<ArrayList> siezeLists = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        int minWidth =100;
        int maxWidth = carportRequest.getWidth()-300-15;
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

        if (carportRequest.getWidth()<=715){
            for (int i = 10; i <= maxWidth/10 ; i++) {
                widths.add((i*10));
            }
            siezeLists.add(widths);
        } else {
            minWidth = carportRequest.getWidth()-600-15;
            for (int i = minWidth/10; i <= maxWidth/10 ; i++) {
                widths.add(i*10);
            }
            siezeLists.add(widths);
        }

        ArrayList<Integer> depths = new ArrayList<>();
        for (int i = 10; i < (carportRequest.getLength()-30)/10; i++) {
            depths.add(i*10);

        }
        siezeLists.add(depths);
        return siezeLists;
    }

    public static ArrayList<ArrayList> version2(CarportRequest carportRequest) {
        ArrayList<ArrayList> siezeLists = new ArrayList<>();

        return siezeLists;
    }

    public static ArrayList<ArrayList> version3(CarportRequest carportRequest) {
        ArrayList<ArrayList> siezeLists = new ArrayList<>();

        return siezeLists;
    }
}
