package FunctionLayer;

import java.util.ArrayList;

public class CarportBuilder {
// SKAL EGENTLIG VÆRE CARPORTREQUEST OBJEkT
// TODO SPØRGMÅL: Skal vi ikke lave en Carport parent class? Så vi kan bruge enten requestCarport eller "result"Carport på sammme type objekt?
    Carport carport;
    private int length = carport.getLength();
    private int width = carport.getWidth();

    RoofCalculator roofCalculator = new RoofCalculator(carport);
    private int trapezpladeWidth = 100;
    private int T600RoofPlateLength = 600;
    private int T300RoofPlateLength = 300;
    private int numberOfT600Trapezplates = 0;
    private int numberOfT300Trapezplates = 0;
    private int tiltAngle = carport.getRoof().getDegree();
    private int pitchDegree = carport.getRoof().getDegree();
    private boolean pitchedRoof = carport.getRoof().isPitchedRoof();
    private int square1numberOfT600Trapezplates = 0;
    private int square2numberOfT600Trapezplates = 0;
    private int square3numberOfT600Trapezplates = 0;

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

    /////////////////TODO - Er det menningen at den ikke står i en metode og/eller er public variabel?????????????
    // Hulbånd
    public int perforatedBand = 2;

    // Understern- og over sternbrædder


    // Skruer
    public int screws(){
        int screws = universalBrackets()*2;
        return screws;
    }


    ////////////////// Trapezplader
    //Hjælpemetode for bredde af tag afhægnigt af type
    public int roofwidthHelper() throws Exception {
        int roofwidth = width;
        if (pitchedRoof) {
            roofwidth = roofCalculator.pitchedRoofCalcutatedWidth(pitchDegree);
        }
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnigt af type
    public int rooflenghtHelper() throws Exception {
        int roofLength = roofCalculator.flatRoofCalcutatedSide(tiltAngle);

        if (pitchedRoof) {
            roofLength = length;
        }
        return roofLength;
    }

    //Antal T600 Trapezplader
    public int quantityOfT600ForRoof(int roofWidth, int roofLength) throws Exception {
        //Tag er fladt hvis man ikke aktivt vælger tag med spids

        ///////////////Beregning af første del af tag (hvor mange HELE T600 plader kan der være)
        for (int i = 0; i < roofWidth; i = +trapezpladeWidth) {
            for (int j = 0; j < roofLength; j = +T600RoofPlateLength) {
                square1numberOfT600Trapezplates++;
            }
        }

        /////////////////////////////////////////////////////

       /////Beregning af anden del af tag (T600 plader inkl. T600 pladerester - hvor pladerne er delt på bredden)
        int restWidth = roofWidth % trapezpladeWidth;

        for (int i = 0; i < roofLength; i = +T600RoofPlateLength) {
            square2numberOfT600Trapezplates++;
        }

        int restPart;

        if(restWidth != 0) {
            restPart = trapezpladeWidth / restWidth;
            //TODO tjek om man kan dette!
            square2numberOfT600Trapezplates = square2numberOfT600Trapezplates / restPart;
        }

        /////////////////////////////////////////////////////

        ///////////////Beregning af tredje del af tag (om hvor mange antal T600 plader der er (delt i længden))
        int quantityOfT300 = quantityOfT300ForRoof(roofLength, roofWidth);

        if (quantityOfT300 != 0){
            for (int i = 0; i < roofWidth; i = +trapezpladeWidth) {
                square3numberOfT600Trapezplates++;
                }
            }

        /////////////////////////////////////////////////////

        //Mellemregning
        int QuantetyOfT600TrapezplatesTotal = square1numberOfT600Trapezplates + square2numberOfT600Trapezplates +
                square3numberOfT600Trapezplates;

        /////////////Beregning af fjerde og sidste del-firkant af tag (om den sidste plade skal være en T600)
        int T300Quantety = quantityOfT300ForRoof(roofLength, roofWidth);

        if (T300Quantety == 0 )
            QuantetyOfT600TrapezplatesTotal++;

        /////////////////////////////////////////////////////

        if(pitchedRoof)
            QuantetyOfT600TrapezplatesTotal = QuantetyOfT600TrapezplatesTotal*2;

        return QuantetyOfT600TrapezplatesTotal;
    }

    //Antal T300 Trapezplader
    public int quantityOfT300ForRoof(int roofLength, int roofWidth) throws Exception {
        int restOfLength = roofLength % T600RoofPlateLength;
        if (restOfLength > 0 && restOfLength <= T300RoofPlateLength)
            numberOfT300Trapezplates = (roofWidth / trapezpladeWidth) + 1 ;
                                                                        //^(Beregning af fjerde og sidste del
                                                                        // af taget betyder det når jeg skriver +1)
        if(pitchedRoof)
            numberOfT600Trapezplates = numberOfT600Trapezplates*2;

        return numberOfT300Trapezplates;

    }


     /*   if (length <= 300){
            numberOfTrapezRows = Math.round((trapezpladeWidth*width)/100);
        }
        if (length >300){
            numberOfTrapezRows = Math.round((trapezpladeWidth*width + (trapezpladeWidth*100))/100);
        }
        *//*
            if (length >= 600){
                numberOfTrapezplader = Math.round((T600*width + (T300*100)/100));
            }
        *//*

        return numberOfTrapezRows;
    }
*/


    // Bundskruer
    public int bottomScrews(){
        // Plader fastgøres med plastmo bundskruer og skal anvendes 6 stk pr. meter på hver spær
        // Men 8 per meter på den første og den sidste spær
        int bottomScrews = (((raft()-2)*6)+16)*(width/100);
        return bottomScrews;
    }

    // Tætningsprofil
    public int gasket(){
        int gasket = Math.round((width/100)*2);
        return gasket;
    }

    // Vandbræt 360
    // Vandbræt540

    // Skruer til vandbræt -- 1 pakke er nok til en stor carport
    public int waterboardScrews = 200;

    // Skruer til ydrebeklædning
    public int outherTimbering(){
        int outherTimbering = 0;

        if (length < 500 && width < 510){
            outherTimbering = 200;
        }
        if (length > 500 && width > 510){
            outherTimbering = 400;
        }
        return outherTimbering;
    }

    // Skruer til inderbeklædning
    public int innerTimbering(){
        int innerTimbering = 0;

        if (length < 500 && width < 510){
            innerTimbering = 150;
        }
        if (length > 500 && width > 510){
            innerTimbering = 300;
        }
        return innerTimbering;
    }

    // Skur:
    // Stolpe
    public int shedPosts = 2;

    // Lås
    public int shedLock = 1;

    // Hængsel
    public int shedHinge = 2;

    // Lægte
    public int shedLath = 1;

    // Vinkelbeslag
   // TODO - løsholter gavle + løsholter sider

    // Beklædning
    public int shedTimbering(int shedWidth){
        int areal = shedWidth+carport.getShed().getDepth();
        int shedTimbering = (int) Math.round(((areal/100)*12.5));
        return shedTimbering;
    }

// algorytmer for calculation of needed materials
    public void buildCarport(Carport carport) {

        ArrayList<Material> materials = new ArrayList<>();

        int length = carport.getLength();
        int width = carport.getWidth();
        int shedDepth = carport.getShed().getDepth();
        int shedWidth = carport.getShed().getWidth();

        Carport carportTemp;
        Shed shed = new Shed(,shedDepth)
        carport.setLength(length);
        carport.setWidth(width);
        carport.setShed().setDepth()(shedDepth);
        //carport.setRoof(new Roof(new RoofCalculator()); //TODO hvad med dette?


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
