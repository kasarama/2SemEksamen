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

// algorytmer for calculation of needed materials
    public void buildCarport(CarportRequest carportRequest) {
        carport = new Carport();
        ArrayList<Material> materials = new ArrayList<>();

        int length = carportRequest.getLength();
        int width = carportRequest.getWidth();
        int shedDepth = carportRequest.getShedDepth();
        int angle = carportRequest.getAngle();

        carport.setLength(length);
        carport.setWidth(width);
        carport.setShedDepth(shedDepth);
        carport.setAngle(angle);
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
            materials.add(new Material("97x97mm.trykimp.Stolpe", 300, "cm"));
        }
    }


    /*
    Strap/Rem bygges af 45x19mm.spærtræubh.
     */
}
