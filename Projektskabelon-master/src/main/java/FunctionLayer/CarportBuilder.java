package FunctionLayer;

import java.util.ArrayList;

public class CarportBuilder {
    Carport carport = new Carport();

    // Stolper og Rem
    public int posts (){
        int numberOfPosts = 0;
        int length = carport.getLength();
        int width = carport.getWidth();

        if (length < 300 && width < 510){
            numberOfPosts = 4;
        }
        if (length < 300 && width > 510){
            numberOfPosts = 6;
        }
        if (length > 300 && width < 510){
            numberOfPosts = 6;
        }
        if (length > 300 && width > 510){
            numberOfPosts = 9;
        }
        return numberOfPosts;
    }
    public int rem (){
        int numberOfRem = 0;
        int length = carport.getLength();
        int width = carport.getWidth();

        if (length < 300 && width < 510){
            numberOfRem = 2;
        }
        if (length < 300 && width > 510){
            numberOfRem = 3;
        }
        if (length > 300 && width < 510){
            numberOfRem = 4;
        }
        if (length > 300 && width > 510){
            numberOfRem = 6;
        }
        return numberOfRem;
    }

    // Bræddebolte
    public int carriageBolts() {
        int carriageBolts = posts()*2;
        return carriageBolts;
    }

    // Spær
    //public int

    // Firkantskiver
    // Universalbeslag
    // Beslagskruer
    // Hulbånd
    // Understern- og over sternbrædder
    // Skruer
    // Trapezplader
    // Bundskruer
    // Tætningsprofil
    // Vandbræt 360
    // Vandbræt540
    // Skruer til vandbræt
    // Skruer til ydrebeklædning
    // Skruer til inderbeklædning

    // Skur:
    // Stolpe
    // Lås
    // Hængsel
    // Lægte
    // Vinkelbeslag
    // Beklædning

// algorytmer for calculation of needed materials
    public void buildCarport(CarportRequest carportRequest) {
        Carport carport = new Carport();
        ArrayList<Material> materials = new ArrayList<>();

        int length = carportRequest.getLength();
        int width = carportRequest.getWidth();
        int shedDepth = carportRequest.getShedDepth();
        int angle = carportRequest.getAngle();

        carport.setLength(length);
        carport.setWidth(width);
        carport.setShedDepth(shedDepth);
        carport.setAngle(angle);


        int sidePost = ((length - (length % 300)) / 300 + 1) * 2;
        int shedPost;
        if (shedDepth > 0) {
            shedPost = 3;
            if (width == 600) {
                shedPost = 5;
            }
        } else {
            shedPost = 0;
        }

        for (int i = 0; i < (sidePost + shedPost); i++) {
            materials.add(new Material("97x97mm.trykimp.Stolpe", 300));
        }
    }


    /*
    Strap/Rem bygges af 45x19mm.spærtræubh.
     */
}
