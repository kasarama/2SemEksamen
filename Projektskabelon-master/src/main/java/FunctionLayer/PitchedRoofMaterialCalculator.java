package FunctionLayer;

import java.util.ArrayList;

public class PitchedRoofMaterialCalculator {

    //M
    private int numberOfTaglaegter; // T1 taglægter til spær
    private int numberOfStern;
    private int numberOfToplaegteHolder;
    private int numberOfToplaegte; // T1 toplægter til rygsten
    private int numberOfTagfodsLaegte;
    private int numberOfVindskeder;
    private int numberOfVandbraet;
    private int toplaegteholder;

    ConstructionSizeCalculator constructionSizeCalculator;
    Construction construction;
    Roof roof;

    //C
    RoofSizing roofSizing;
    private int SCREWSPERTAGLÆGTEHOLDER = 5;
    private int LÆGTESTENDISTANCE = 307;
    private int RYGSTENCOVERS = 330;

    private int tagstenBinder;
    private int tagstenNakkekrog;
    private int toplægteHolder;

    private int screwForTaglægter;
    private int screwsForVindskeder;
    private int screwsForVandbræt;
    private int beslagForToplægte;

    private int vindskedeLængde;
    private int vandBrætsLength;

    private int tagstenEntirePitchedRoof;

    private int tagstenBredde;
    private int rygstenBeslag;
    private int spærFullPlankLength;
    private int spærAmount;
    private int spærFullQuatityOfPlanks;

    private int amountOfRygsten;



    public PitchedRoofMaterialCalculator(Construction construction) {
        this.construction = construction;
        roofSizing = new RoofSizing(construction);
        roof = construction.getRoof();
    }

    public static ArrayList<Material> pitchedRoof (Construction construction) {
        ArrayList<Material> pitchedRoofMaterials = new ArrayList<>();

        //Toplægter
        Material toplægter = new Material();
        toplægter.setName("");
        toplægter.setComment("");
        toplægter.setSize(0);
        toplægter.setAmount(0);
        pitchedRoofMaterials.add(toplægter);

        //Taglægter
        Material taglaegter = new Material();
        taglaegter.setName("");
        taglaegter.setComment("");
        taglaegter.setSize(0);
        taglaegter.setAmount(0);
        pitchedRoofMaterials.add(taglaegter);

        //Sternbrædder
        Material stern = new Material();
        stern.setName("");
        stern.setComment("");
        stern.setSize(0);
        stern.setAmount(0);
        pitchedRoofMaterials.add(stern);

        //Vandbræt
        Material vandbraet = new Material();
        vandbraet.setName("");
        vandbraet.setComment("");
        vandbraet.setSize(0);
        vandbraet.setAmount(0);
        pitchedRoofMaterials.add(vandbraet);


        //Vindskeder
        Material vindskeder = new Material();
        vindskeder.setName("");
        vindskeder.setComment("");
        vindskeder.setSize(0);
        vindskeder.setAmount(0);
        pitchedRoofMaterials.add(vindskeder);

        //toplægteHolder

        Material toplaegteHolder = new Material();
        toplaegteHolder.setName("");
        toplaegteHolder.setComment("");
        toplaegteHolder.setSize(0);
        toplaegteHolder.setAmount(0);
        pitchedRoofMaterials.add(toplaegteHolder);

        return pitchedRoofMaterials;


    }


    //** Calculations **

    public int amoutOfRygstenBeslagCalculated() {
        rygstenBeslag = quantityRygsten();
        return rygstenBeslag;
    }

    public int amountOfTagsten(){
        int tagstenHalfePitchedRoof = 0;
        //Vi trækker ikke en tagstenbredde fra i tagets længde i for-loopet fordi vi vil have det hele antal + en hvis
        // der er en rest
        for (int i = 0; i < roofSizing.roofWidthSurface()- LÆGTESTENDISTANCE; i= i + LÆGTESTENDISTANCE) {
            for (int j = 0; j < roofSizing.roofLengthSurface(); j = j + tagstenBredde) {
                tagstenHalfePitchedRoof++;
            }
        }
        tagstenEntirePitchedRoof = tagstenHalfePitchedRoof * 2;
        return tagstenEntirePitchedRoof;
    }

    public int tagstenBindereCalculated(){
        int tagstenBinder = amountOfTagsten();
        for (int i = 0; i < tagstenBinder; i = i+2) {
            tagstenBinder ++;
        }
        return tagstenBinder;
    }

    public int tagstenNakkekrogeCalculated(){
        //Vi formoder der er en tagstensnakkekrog pr. tagsten
        tagstenNakkekrog = amountOfTagsten();
        return tagstenNakkekrog;
    }

    public int screwForTaglægterCalculated(){
        //Vi antager der er er en skrue pr toplægteholder + samt et pr spær for at sætte toplægten fast
        screwForTaglægter = numberOfToplaegteHolder() * SCREWSPERTAGLÆGTEHOLDER;
        return screwForTaglægter;
    }

    public int screwsForVindskederCalculated(){
        //Vi antager der bruges en skrue for hvert 50cm
        vindskedeLængde = (int)(Math.hypot((construction.getConstructionWidth()/2.0), (double) (roofSizing.roofHeight(
                construction.getRoof().getIsPitched(), construction.getConstructionLength(),
                construction.getConstructionWidth()))));
        for (int i = 500; i < vindskedeLængde-500 ; i = i + 500) {
            screwsForVindskeder++;
        }
        return screwsForVindskeder;
    }

    public int screwsForVandbrætCalculated(){
        //Vi antager der skal bruges til hver 30 cm en skrue
        vandBrætsLength = construction.getRoof().getLength();
        for (int i = 300; i < vandBrætsLength -300 ; i = i + 300) {
            screwsForVindskeder++;
        }
        return screwsForVandbræt;
    }

    /*public int AmountOfScrewPackages(){
        int screwsTotal = screwForTaglægterCalculated() + screwsForVindskederCalculated()
                + screwsForVandbrætCalculated();
        screwPackage = Math.round(screwsTotal/200);
        return screwPackage;
    }*/

    public int amountOfBeslagScrewsForToplægteCalculated(){
        //Vi antager ud fra billeder på nettet at der er plads til 9 skruger på hver side af toplægtebeslag
        beslagForToplægte = 9*2*amountOfBeslagScrewsForToplægteCalculated();
        return beslagForToplægte;
    }


    public int spærPlankLengthPerSpær(){
        int spærfodLength = construction.getCarportWidth();
        int spærArm = (int) (spærfodLength/(Math.cos(Math.toRadians(construction.getRoof().getDegree()))))*2;
        spærFullPlankLength = (spærArm*2)+spærfodLength;
        return spærFullPlankLength;
    }
    //TODO beregning af ekstra spær (til sidst)

    public int spærQuatity(){
        //Vi har ud fra tegning sagt der er 89 cm imellem hvert spær
        int carportLength = construction.getCarportLength();
        int distanceBestweenSpær = 890;
        for (int i = 0; i < carportLength; i = 1 + distanceBestweenSpær) {
            spærAmount++;
        }
        if (construction.getShed() != null) {
            spærAmount = spærAmount+ 2;
        }
        return spærAmount;
    }

    public int spærFullQuatityOfPlanksTotal(){
        spærFullQuatityOfPlanks = spærPlankLengthPerSpær()*spærQuatity();
        return spærFullQuatityOfPlanks;
    }

    public int gavlOverlayQuantity(int overlayPlankWidthKonstant, int overlayPlankLenghtAvalible){
        int gavlOverlayPlanksQuantity = 0;
        int lengthOfTriangleGavl = construction.getCarportWidth();
        int lenghtOfTriangleGavlShorter = construction.getCarportWidth();
        int restTotal;
        int restUseable = 1;
        int roofHeight = construction.getRoof().getHeight();
        double newHeight = construction.getRoof().getHeight();
        int roofAngleInTop = (construction.getRoof().getDegree())*2;
        int lengthOfHalfRoofWidthSurface = roofSizing.roofWidthSurface();
        int overlayPlankWidth;
        double kFactor;
        double tempHeigth;

        for (int i = 0; i < roofHeight-1; i = i + overlayPlankWidth) {
            overlayPlankWidth = overlayPlankWidthKonstant;
            gavlOverlayPlanksQuantity++;
            restTotal = overlayPlankLenghtAvalible % lenghtOfTriangleGavlShorter;
            if ( restTotal != 0){
                restUseable = overlayPlankLenghtAvalible/restTotal;
                gavlOverlayPlanksQuantity ++;
                overlayPlankWidth = overlayPlankWidth * restUseable;
            }
            tempHeigth = newHeight;
            if (overlayPlankWidth<newHeight)
                newHeight = newHeight - overlayPlankWidth;
            else
                newHeight = overlayPlankWidth - newHeight;
            kFactor = newHeight/tempHeigth;

            lenghtOfTriangleGavlShorter = (int) (kFactor * lenghtOfTriangleGavlShorter);
        }
        if (lenghtOfTriangleGavlShorter !=0 )
            return (int) gavlOverlayPlanksQuantity + 1;

        return (int) gavlOverlayPlanksQuantity;
    }


    public int quantityRygsten() {
        amountOfRygsten = construction.getConstructionLength() / RYGSTENCOVERS;
        if (amountOfRygsten% RYGSTENCOVERS != 0 )
            amountOfRygsten++;
        return amountOfRygsten;
    }

    //Vi antager at der herfra og ned er et slags materiale og derfor disse beregninger:

    //** Beregning af antal taglægter i forhold til tagets bredde - Remember: tilpas med t1_SpaerLength!? **
    private int numberOfT1_Spaer_Taglaegter (int roofWidth)
    {
        roofWidth = roof.getWidth();
        int T1_SpaerDistance = 307; // 307 mm mellem hvert lægte - dog ikke den første
        int topDistance = 30; // 30 mm på hver side dvs * 2

        numberOfTaglaegter = roofWidth - (topDistance * 2)/T1_SpaerDistance + 2; // 2 = 350mm bræt
        return numberOfTaglaegter;
    }

    // ** Beregning af antal sternbrædder i forhold til tagets længde - stern skal have samme længde som taget + 300 mm**
    public int numberOfStern (int roofLength)
    {
        roofLength = roof.getLength();
        int sternLength = roofLength + 300; //tag længde + 300mm lægte udhæng

        if (roofLength <= 600 ) //600 mm = 1 stern længde - if roofLength equal/smaller than 600
        {
            numberOfStern = 4; // 2 on each side
        }
        else if (roofLength > 600) //if bigger than 600
        {
            numberOfStern = 6; // 4 on each side
        }
        else
        {
            numberOfStern = 8;
        }

        return numberOfStern;
    }

    //** Beregning af antal Toplægteholdere i forhold til spær (beslag)
    private int numberOfToplaegteHolder ()
    {
        int spaer = constructionSizeCalculator.roofSpaerAmount(construction);

        numberOfToplaegteHolder = toplaegteholder * spaer;
        return numberOfToplaegteHolder;
    }

    //** Beregning af T1 toplægte (til rygsten) i forhold til tag længde **
    public int numberOfT1_RygstenLength(int roofLength)
    {
        roofLength = roof.getLength();

        //int toplaegteLength = 420; // 420 mm = 1 toplægte længde

        if(roofLength <= 840) // stk af 420 dvs *2= 840
        {
            numberOfToplaegte = 2;
        }
        else if (roofLength > 840)
        {
            numberOfToplaegte = 4;
        }
        else
        {
            numberOfToplaegte = 6;
        }
        return numberOfToplaegte;
    }

    //** Beregning af antal tagfodslægte i forhold til taget længde **
    public int numberOfTagfodsLaegte ()
    {
        int roofLength = roof.getLength();

        if (roofLength <= 1620 ) //340 * 3stk ---> 340 mm = længde af 1 tagfodslægte
        {
            numberOfTagfodsLaegte = 3;
        }
        else if (roofLength > 1620)
        {
            numberOfTagfodsLaegte = 6;
        }
        else {
            numberOfTagfodsLaegte = 9;
        }
        return numberOfTagfodsLaegte;
    }

    //** Beregning af antal vindskeder i forhold til tagets længde og højde **
    public int numberOfVindskeder (int roofLength, int roofHeight)
    {
        roofLength = roof.getLength();
        roofHeight = roof.getHeight();

        if (roofHeight < 100) //if roofHeight is less than 1 m - no vindskeder is needed
        {
            return 0; //return nothing
        }
        else {  //roofHeight > 100 - vinsdkeder is needed

            if (roofLength <= 480 ) //if roofLength equal/smaller than 480 - længde af 1 vindskede bræt
            {
                numberOfVindskeder = 2;
            }
            else if (roofLength > 480 )
            {
                numberOfVindskeder = 4;
            }
        }
        return numberOfVindskeder;
    }

    //** Beregning af antal vandbræt i forhold til antal vindskider ** - skal monteres på vindskider
    //Note: antal vandbræt = antal vindskeder.
    public  int numberOfVandbraet()
    {
        int roofLength = roof.getLength();

        if (roofLength <= 480 ) //if roofLength equal/smaller than 480 - længde af 1 vandbræt
        {
            numberOfVandbraet = 2;
        }
        else if (roofLength > 480 )
        {
            numberOfVandbraet= 4;
        }
        return numberOfVandbraet;
    }
}