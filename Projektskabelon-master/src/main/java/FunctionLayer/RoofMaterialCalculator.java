package FunctionLayer;

public class RoofMaterialCalculator {
    Construction construction;
    private int length = construction.getCarportLength();
    private int width = construction.getCarportWidth();

    RoofSizing roofSizing = new RoofSizing(construction);
    private int trapezpladeWidth = 100;
    private int T600RoofPlateLength = 600;
    private int T300RoofPlateLength = 300;
    private int numberOfT600Trapezplates = 0;
    private int numberOfT300Trapezplates = 0;
    private boolean pitchedRoof = construction.getRoof().getIsPitched();
    private int square1numberOfT600Trapezplates = 0;
    private int square2numberOfT600Trapezplates = 0;
    private int square3numberOfT600Trapezplates = 0;


    ////////////////// Trapezplader - START

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

        //Mellemregning til samlet antal plader
        int QuantetyOfT600TrapezplatesTotal = square1numberOfT600Trapezplates + square2numberOfT600Trapezplates +
                square3numberOfT600Trapezplates;

        /////////////Beregning af fjerde og sidste del af tag (om den sidste plade skal være en T600 eller T300)
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

    ////////////////// Trapezplader - SLUT


    // TRÆ OG ANDET:
        // Vandbræt
        public int[] waterBoard(ConstructionSizeCalculator constructionSizeCalculator, Construction construction){
            int[] waterBoardPieces = constructionSizeCalculator.overSternPieces(construction);
            return waterBoardPieces;
        }

        /*// Tagplader
        public static int roofAntal(int length, int width){
            int numberOfTrapezplader = 0;
            int T300Areal = 3;
            int T600Areal = 6;
            int samletAreal = length*width;
            int numberOfT300 = samletAreal/T300Areal;
            int numberOfT600 = samletAreal/T600Areal;

            // Hvis antallet af T300 er mindre end T600 bruges T300
            if (numberOfT300<numberOfT600){
                numberOfTrapezplader = numberOfT300;
            } else {
                numberOfTrapezplader = numberOfT600;
            }
            return numberOfTrapezplader;
        }

        public static String roofType(int length, int width){
            String trapezplader = "";
            int T300Areal = 3;
            int T600Areal = 6;
            int samletAreal = (length/100)*(width/100);
            int numberOfT300 = samletAreal/T300Areal;
            int numberOfT600 = samletAreal/T600Areal;

            // Hvis antallet af T300 er mindre end T600 bruges T300
            if (numberOfT300<numberOfT600){
                trapezplader = "T300";
            } else {
                trapezplader = "T600";
            }
            return trapezplader;
        }*/

    // Tætningsprofil
        public static int gasket(int width){
            int gasket = Math.round((width/100)*2);
            return gasket;
        }


    // SKRUER OG BESLAG:

        // Bundskruer
        public int bottomScrews(ConstructionSizeCalculator constructionSizeCalculator, Construction construction, int width){
            // Plader fastgøres med plastmo bundskruer og skal anvendes 6 stk pr. meter på hver spær
            // Men 8 per meter på den første og den sidste spær
            double bottomScrews = (((constructionSizeCalculator.roofSpaerAmount(construction)-2)*6)+16)*(width/100);
            double forskel = bottomScrews/200;
            int pakker;
            if (forskel<=1){
                pakker = 1;
            } else if (forskel<=2){
                pakker = 2;
            } else {
                pakker = 3;
            }
            return pakker;
        }

        // Skruer til vandbræt -- 1 pakke er nok til en stor carport
        public static int waterboardScrews = 1;

}
