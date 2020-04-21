package FunctionLayer;

import java.util.ArrayList;

public class CarportBuilder {
// SKAL EGENTLIG VÆRE CARPORTREQUEST OBJEkT
    Carport carport = new Carport();
    int length = carport.getLength();
    int width = carport.getWidth();

    // Stolper og Rem
    public int posts (){
        int numberOfPosts = 0;

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
    public int raft (){
        int rafts = Math.round(length/50);
        return rafts;
    }

    // Firkantskiver
    public int squares(){
        int squares = raft();
        return squares;
    }

    // Universalbeslag
    public int universalBrackets(){
        int universalBrackets = raft()*rem();
        return universalBrackets;
    }

    // Beslagskruer
    public int bracketScrews(){
        int bracketScrews = raft()*9;
        return bracketScrews;
    }

    // Hulbånd
    public int perforatedBand = 2;

    // Understern- og over sternbrædder


    // Skruer
    public int screws(){
        int screws = universalBrackets()*2;
        return screws;
    }

    // Trapezplader
    public int roof(){
        int numberOfTrapezplader = 0;
        int trapezpladeWidth = 1;
        //int T600 = 1;

        if (length <= 300){
            numberOfTrapezplader = Math.round((trapezpladeWidth*width)/100);
        }
        if (length >300){
            numberOfTrapezplader = Math.round((trapezpladeWidth*width + (trapezpladeWidth*100))/100);
        }
        /*
            if (length >= 600){
                numberOfTrapezplader = Math.round((T600*width + (T300*100)/100));
            }
        */

        return numberOfTrapezplader;
    }

    // Bundskruer
    public int bottomScrews(){
        // Plader fastgøres med plastmo bundskruer og skal anvendes 6 stk pr. meter på hver spær
        // Men 8 per meter på den første og den sidste spær
        int bottomScrews = (((raft()-2)*6)+16)*(width/100);
        return bottomScrews;
    }

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
