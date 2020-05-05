package FunctionLayer;

public class RoofMaterialCalculator {

    Construction construction = new Construction();

    RoofSizing roofSizing = new RoofSizing(construction);
    private int trapezpladeWidth = 100;
    private int T600RoofPlateLength = 600;
    private int T300RoofPlateLength = 300;
    private int numberOfT600Trapezplates = 0;
    private int numberOfT300Trapezplates = 0;
    private int square1numberOfT600Trapezplates = 0;
    private int square2numberOfT600Trapezplates = 0;
    private int square3numberOfT600Trapezplates = 0;
    private int roofWidth = roofSizing.roofWidthSurface();
    private int roofLength = roofSizing.roofLengthSurface();
    private boolean pitchedRoof = construction.getRoof().getIsPitched();


    ////////////////// Trapezplader - START

    //Antal T600 Trapezplader
    public int quantityOfT600ForRoof() {
        //Tag er fladt hvis man ikke aktivt vælger tag med spids

        ///////////////Beregning af første del af tag (hvor mange HELE T600 plader kan der være)
        for (int i = 0; i < roofWidth - trapezpladeWidth; i = +trapezpladeWidth) {
            System.out.printf("26");
            for (int j = 0; j < roofLength - T600RoofPlateLength; j = +T600RoofPlateLength) {
                square1numberOfT600Trapezplates++;
            }
        }

        /////////////////////////////////////////////////////

        /////Beregning af anden del af tag (T600 plader inkl. T600 pladerester - hvor pladerne er delt på bredden)
        int restWidth = roofWidth % trapezpladeWidth;

        for (int i = 0; i < roofLength - T600RoofPlateLength; i = +T600RoofPlateLength) {
            square2numberOfT600Trapezplates++;
        }

        int restPart;

        if (restWidth != 0) {
            restPart = trapezpladeWidth / restWidth;
            int temp = square2numberOfT600Trapezplates / restPart;
            square2numberOfT600Trapezplates = -temp;
            System.out.printf("46");
        }

        /////////////////////////////////////////////////////

        ///////////////Beregning af tredje del af tag (om hvor mange antal T600 plader der er (delt i længden))
        int quantityOfT300 = quantityOfT300ForRoof();

        if (quantityOfT300 == 0) {
            for (int i = 0; i < roofWidth - trapezpladeWidth; i = +trapezpladeWidth) {
                square3numberOfT600Trapezplates++;
            }
        }

        /////////////////////////////////////////////////////

        //Mellemregning til samlet antal plader
        numberOfT600Trapezplates = square1numberOfT600Trapezplates + square2numberOfT600Trapezplates +
                square3numberOfT600Trapezplates;

        /////////////Beregning af fjerde og sidste del af tag (om den sidste plade skal være en T600 eller T300)

        if (quantityOfT300 == 0)
            numberOfT600Trapezplates++;

        /////////////////////////////////////////////////////

        if (pitchedRoof)
            numberOfT600Trapezplates = numberOfT600Trapezplates * 2;

        return numberOfT600Trapezplates;
    }

    //Antal T300 Trapezplader
    public int quantityOfT300ForRoof() {
        int restOfLength = roofLength % T600RoofPlateLength;
        if (restOfLength > 0 && restOfLength <= T300RoofPlateLength)
            numberOfT300Trapezplates = (roofWidth / trapezpladeWidth) + 1;
        //^(Beregning af fjerde og sidste del
        // af taget betyder det når jeg skriver +1)
        int temp = 0;
        if (pitchedRoof)
            temp = (numberOfT300Trapezplates * 2);
        numberOfT300Trapezplates = temp;

        return numberOfT300Trapezplates;
    }

    ////////////////// Trapezplader - SLUT


    // TRÆ OG ANDET:
    // Understernbrædder
    public static int understernboartU360(int length, int width) {
        int antalU360;
        int lengthU360antal;
        int widthU360antal;
        if (length <= 360) {
            lengthU360antal = 2;
        } else if (length > 540 && length <= 720) {
            lengthU360antal = 4;
        } else {
            lengthU360antal = 0;
        }
        if (width <= 360) {
            widthU360antal = 2;
        } else if (width > 540 && width <= 720) {
            widthU360antal = 4;
        } else {
            widthU360antal = 0;
        }
        antalU360 = lengthU360antal + widthU360antal;
        return antalU360;
    }

    public static int understernboartU540(int length, int width) {
        int antalU540;
        int lengthU540antal;
        int widthU540antal;
        if (length > 360 && length <= 540) {
            lengthU540antal = 2;
        } else if (length > 720 && length <= 780) {
            lengthU540antal = 4;
        } else {
            lengthU540antal = 0;
        }
        if (width > 360 && width <= 540) {
            widthU540antal = 2;
        } else if (width > 720 && width <= 780) {
            widthU540antal = 4;
        } else {
            widthU540antal = 0;
        }
        antalU540 = lengthU540antal + widthU540antal;
        return antalU540;
    }

    // Oversternbrædder
    public static int oversternboartU360(int length, int width) {
        int oversternAntal = understernboartU360(length, width);
        return oversternAntal;
    }

    public static int oversternboartU540(int length, int width) {
        int oversternAntal = understernboartU540(length, width);
        return oversternAntal;
    }

    // Rem
    public static int rem600(int length, int width) {
        int rem600Antal;
        if (width > 600) {
            rem600Antal = 3;
        } else {
            rem600Antal = 2;
        }
        return rem600Antal;
    }

    public static int rem480(int length, int width) {
        int rem480Antal;
        if (length > 600) {
            rem480Antal = 1;
        } else if (width > 600) {
            rem480Antal = 2;
        } else {
            rem480Antal = 0;
        }
        return rem480Antal;
    }

    // Spær
    public static int raft(int length) {
        int rafts = Math.round(length / 50);
        return rafts;
    }

    // Vandbræt
    public static int vandbræt360(int length, int width) {
        int vandbrætAntal = oversternboartU360(length, width);
        return vandbrætAntal;
    }

    public static int vandbræt540(int length, int width) {
        int vandbrætAntal = oversternboartU540(length, width);
        return vandbrætAntal;
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
    public static int gasket(int width) {
        int gasket = Math.round((width / 100) * 2);
        return gasket;
    }


    // SKRUER OG BESLAG:

    // Bundskruer
    public static int bottomScrews(int length, int width) {
        // Plader fastgøres med plastmo bundskruer og skal anvendes 6 stk pr. meter på hver spær
        // Men 8 per meter på den første og den sidste spær
        double bottomScrews = (((raft(length) - 2) * 6) + 16) * (width / 100);
        double forskel = bottomScrews / 200;
        int pakker;
        if (forskel <= 1) {
            pakker = 1;
        } else if (forskel <= 2) {
            pakker = 2;
        } else {
            pakker = 3;
        }
        return pakker;
    }

    // UniversalHøjre
    public static int universalBracketsRight(int length) {
        int universalBracketsRight = raft(length);
        return universalBracketsRight;
    }

    // UniversalVenstre
    public static int universalBracketsLeft(int length) {
        int universalBracketsLeft = raft(length);
        return universalBracketsLeft;
    }

    // Skruer til vandbræt -- 1 pakke er nok til en stor carport
    public static int waterboardScrews = 1;

    // Beslagskruer
    public static int bracketScrewsRoof(int length) {
        // Beslagskruer til spær:
        int bracketScrewsS = raft(length) * 9;
        // Skal bruge antallet af pakker og der er 250 stk i 1 pakke:
        int forskel = 250 / bracketScrewsS;
        int brancketScrewPk = 0;
        if (forskel <= 1) {
            brancketScrewPk = 1;
        } else if (forskel > 1 && forskel <= 2) {
            brancketScrewPk = 2;
        } else if (forskel > 2 && forskel <= 3) {
            brancketScrewPk = 3;
        } else {
            brancketScrewPk = 4;
        }
        return brancketScrewPk;
    }

    // Bræddebolte
    public static int carriageBolts(int length, int width) {
        int carriageBolts = ConstructionMaterialCalculator.posts(length, width) * 2;
        return carriageBolts;
    }

    // Firkantskiver
    public static int squares(int length, int width) {
        int squares = ConstructionMaterialCalculator.posts(length, width);
        return squares;
    }

}
