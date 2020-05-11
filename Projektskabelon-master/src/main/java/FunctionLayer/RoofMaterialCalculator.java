package FunctionLayer;

import PresentationLayer.Materials;

import java.util.ArrayList;

public class RoofMaterialCalculator {

    // TODO gem vandbræt, bundskruer, tætningsprofil


    Construction construction;
    RoofSizing roofSizing;

    private int T300ROOFPLADELENGTH = 3000; //Dette skulle rigtig beregnes ud fra 3600 mm istedet men vi prioterer
    //på andre ting, da vi er tidspressede
    private int T600ROOFPLADELENGTH = 6000;
    private int OVERLAP = 200;

    private int numberOfT600Trapezplates;
    private int numberOfT300Trapezplates;
    private int square1numberOfT600Trapezplates = 0;
    private int square2numberOfT600Trapezplates = 0;
    private int square3numberOfT600Trapezplates = 0;
    private int roofWidth;
    private int roofLength;

    ArrayList materialsList;
    Material material;

    public RoofMaterialCalculator(Construction construction) {
        this.construction = construction;
        this.roofSizing = new RoofSizing(construction);
        this.roofWidth = roofSizing.roofWidthSurface();
        this.roofLength = roofSizing.roofLengthSurface();
    }

    public ArrayList<Material> setflatRoofMaterials() throws LoginSampleException {
        construction.getRoof().setRoofMaterialList(flatRoofMaterialsInsert("BLÅTONET")); //TODO hente farve kunde på jsp-side
        return construction.getRoof().getRoofMaterialList();
    }

    public ArrayList<Material> flatRoofMaterialsInsert(String trapezColourAnName) throws LoginSampleException {
        materialsList = new ArrayList();
        material = null;

        //TrapezPlader
        material = LogicFacade.getMaterialBySizeName(T600ROOFPLADELENGTH, "");
        material.setName(trapezColourAnName);
        material.setUnit(LogicFacade.getUnitByName(material.getName()));
        material.setWidth(LogicFacade.getWidthByID(material.getId(), material.getName()));
        material.setThickness(LogicFacade.getThicknessByID(material.getId()));
        material.setName("SPÆRTRÆ UBEHANDLET " + material.getThickness() + "x" + material.getWidth());
        material.setSize(T600ROOFPLADELENGTH);
        int quantityOfT600 = quantityOfT600ForRoof(material.getWidth());
        material.setAmount(quantityOfT600);
        material.setComment("tagplader monteres på spær");

        materialsList.add(material);

        material = LogicFacade.getMaterialBySizeName(T300ROOFPLADELENGTH, "");
        material.setName(trapezColourAnName);
        material.setUnit(LogicFacade.getUnitByName(material.getName()));
        material.setWidth(LogicFacade.getWidthByID(material.getId(), material.getName()));
        material.setThickness(LogicFacade.getThicknessByID(material.getId()));
        material.setName("SPÆRTRÆ UBEHANDLET " + material.getThickness() + "x" + material.getWidth());
        material.setSize(T300ROOFPLADELENGTH);
        int quantityOfT300 = quantityOfT300ForRoof(material.getWidth());
        material.setAmount(quantityOfT300);
        material.setComment("tagplader monteres på spær");

        materialsList.add(material);
        return materialsList;


    }

    ////////////////// Trapezplader - START

    //Antal T600 Trapezplader
    public int quantityOfT600ForRoof(int trapezPladeWidth) {
        ///////////////Beregning af første del af tag (hvor mange HELE T600 plader kan der være)
        int tempTrapezPladeWidth = trapezPladeWidth;
        for (int i = 0; i < (roofWidth- tempTrapezPladeWidth + OVERLAP); i = i+ tempTrapezPladeWidth) {
            for (int j = 0; j < roofLength - T600ROOFPLADELENGTH; j = j+ T600ROOFPLADELENGTH) {
                square1numberOfT600Trapezplates++;
                tempTrapezPladeWidth = trapezPladeWidth - OVERLAP;
            }
        }
        tempTrapezPladeWidth = trapezPladeWidth;
        /////////////////////////////////////////////////////

        /////Beregning af anden del af tag (T600 plader inkl. T600 pladerester - hvor pladerne er delt på bredden)
        for (int i = 0; i < roofLength - T600ROOFPLADELENGTH; i = i + T600ROOFPLADELENGTH) {
            square2numberOfT600Trapezplates++;
        }

        int restWidth = roofWidth % tempTrapezPladeWidth;

        int restPart;
        double temp2;

        if (restWidth != 0 ) {
            restPart = tempTrapezPladeWidth / restWidth;
            temp2 = Math.round((double)square2numberOfT600Trapezplates / restPart);
            square2numberOfT600Trapezplates = (int) temp2;
        }

        /////////////////////////////////////////////////////

        ///////////////Beregning af tredje del af tag (om hvor mange antal T600 plader der er (delt i længden))
        int quantityOfT300 = quantityOfT300ForRoof(trapezPladeWidth);

        tempTrapezPladeWidth = trapezPladeWidth;

        if (quantityOfT300 == 0) {
            for (int i = 0; i < (roofWidth- tempTrapezPladeWidth + OVERLAP) ; i = i + tempTrapezPladeWidth) {
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

        return numberOfT600Trapezplates;
    }

    //Antal T300 Trapezplader
    public int quantityOfT300ForRoof(int trapezPladeWidth) {
        int tempTrapezPladeWidth = trapezPladeWidth;
        int restOfLength = roofLength % T600ROOFPLADELENGTH;
        if (restOfLength > 0 && restOfLength <= T300ROOFPLADELENGTH){
            for (int i = 0; i < roofWidth - tempTrapezPladeWidth + OVERLAP; i=i+ tempTrapezPladeWidth) {
                numberOfT300Trapezplates++;
                tempTrapezPladeWidth = tempTrapezPladeWidth - OVERLAP;
            }
        }
        if (numberOfT300Trapezplates != 0)
            numberOfT300Trapezplates = numberOfT300Trapezplates +1;
        //(Beregning af fjerde og sidste del
        // af taget betyder det når jeg skriver +1)


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


}