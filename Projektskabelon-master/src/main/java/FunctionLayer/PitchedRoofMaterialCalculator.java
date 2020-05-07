package FunctionLayer;

public class PitchedRoofMaterialCalculator {

    Construction construction;
    RoofSizing roofSizing;

    private int roofLength;
    private int roofWidth;
    private int roofHeight;
    private int vindskeder;
    private int vandbraet;
    private int stern;
    private int toplaegteholder;
    private int spaer;
    private int t1_SpaerLength = 540;  //taglægte til spær
    private int t1_RygstenLength = 420; //taglægte til rygsten
    private int tagfodslaegteBraet = 540; // tagfodslægteBræt
    private int tagplade; // B&C Dobbelt -s sort (tagplade)


    private int rygstenBeslag;
    private int tagstenBinder;
    private int tagstenNakkekrog;
    private int toplægteHolder;

    private int screwForTaglægter;
    private int screwsForVindskeder;
    private int screwsForVandbræt;
    private int beslagForToplægte;
    private int screwPackage;

    private int vindskedeLængde = 0; //Todo ændre dette når du har fået fat i Mona :D
    private int vandBrætsLængde = 0; ///Todo ændre dette når du har fået fat i Mona :D

    private int tagstenEntirePitchedRoof;
    private int lægteafstand = 307; //TODO evt. hente fra Mona
    private int tagstenBredde;

    private int spærFuldeBrædtLength;
    private int spærAmount;
    private int spærFuldeAntalBrædder;

    private int amountOfRygsten;



    public PitchedRoofMaterialCalculator(Construction construction) {
        this.construction = construction;
        roofSizing = new RoofSizing(construction);
    }

    public int amoutOfRygstenBeslagCalculated() {
        rygstenBeslag = rygsten();
        return rygstenBeslag;
    }

    public int amountOfTagsten(){
        int tagstenHalfePitchedRoof = 0;
        //Vi trækker ikke tagestenbredde fra i taget længde i for loopet fordi vi vil have det hele antal + en hvis
        // der er en rest
        for (int i = 0; i < roofSizing.roofWidthSurface()-lægteafstand; i= i + lægteafstand) {
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
        //TODO - hent hvor lang lægten + spær er fra Mias beregning (og evt. monas)!!
        //Vi antager der er er en skrue pr toplægteholder samt et pr spær for at sætte toplægten fast
        screwForTaglægter = 0;//monas her metode til toplægteholderantal ; // TODO + antal spær
     return screwForTaglægter;
    }

    public int screwsForVindskederCalculated(){
        //Vi antager der bruges en skrue for hvert 50cm plus startskrue
        //TODO - hent hvor lang vindskederne er pr. styk. Der må i alt være mindst fire fordi det er pitched
        for (int i = 0; i < vindskedeLængde ; i = i + 50) {
            screwsForVindskeder++;
        }
        return screwsForVindskeder;
    }

    public int screwsForVandbrætCalculated(){
        //Vi antager der skal bruges til hver 30 cm en skrue samt startskrue:
        for (int i = 0; i < vandBrætsLængde ; i = i + 50) {
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
        beslagForToplægte = 9*2*amountOfBeslagScrewsForToplægteCalculated();
        return beslagForToplægte;
    }

    public int spærBrædtLængdePrSpær(){
        int spærfodLength = construction.getCarportWidth();
        int spærarm = (int) (spærfodLength/(Math.cos(Math.toRadians(construction.getRoof().getDegree()))))*2;
        spærFuldeBrædtLength = (spærarm*2)+spærfodLength;
        return spærFuldeBrædtLength;
    }

    public int spærAntal(){
        int carportLength = construction.getCarportLength();
        int distanceBestweenSpær = 89;
        for (int i = 0; i < carportLength; i = 1 + distanceBestweenSpær) {
            spærAmount++;
        }
        return spærAmount;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int spærFuldeAntalBrædder(){
        spærFuldeAntalBrædder = spærBrædtLængdePrSpær()*spærAntal();//TODO
        return spærFuldeAntalBrædder;
    }

    public int rygsten() {

        return amountOfRygsten;
    }
    ////////////////////////////////////////////////////////////////////////

    //** Beregning af antal taglægter i forhold til tagets bredde - Remember: tilpas med t1_SpaerLength!? **
    private int numberOfT1_Spaer (int roofWidth)
    {
        //length = roofLength;
        int T1_SpaerDistance = 307; // 307 mm mellem hvert lægte - dog ikke den første
        int topDistance = 30; // 30 mm på hver side dvs *2

        int numberOfT1_Spaer = roofWidth - (topDistance * 2)/T1_SpaerDistance + 2; // 2 = 350mm bræt
        return numberOfT1_Spaer;
    }

    // ** Beregning af antal sternbrædder i forhold til tagets længde - stern skal have samme længde som taget + 300 mm**
    public static int numberOfStern (int roofLength)
    {
        int numberOfStern = 0;
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

    //** Beregning af antal Toplægteholdere i forhold til spær (beslag) ** (OPS NOT MINE)
    private static int numberOfToplaegteHolder (int toplaegteholder, int spaer)
    {
        int numberOfToplaegteHolder;

        numberOfToplaegteHolder = toplaegteholder * spaer;
        return numberOfToplaegteHolder;
    }

    //** Beregning af T1 toplægte (til rygsten) i forhold til tag længde **
    public static int numberOfT1_RygstenLength(int roofLength)
    {
        //int toplaegteLength = 420; // 420 mm = 1 toplægte længde
        int numberOfToplaegte = 0;

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
    public static int numberOfTagfodsLaegte (int roofLength)
    {
        int numberOfTagfodsLaegte = 0;
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

    //** Beregning af antal vindskeder i forhold til tagets længde **
    public static int numberOfVindskeder (int roofLength, int roofHeight)
    {
        int numberOfVindskeder = 0;
        boolean isVindskeder;

        if (roofHeight < 100) //if roofHeight is less than 1 m
        {
            isVindskeder = false; // no vindskeder needed
            return 0;
        }
        else {  //roofHeight > 100
            isVindskeder = true; //vinsdkeder is needed

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
    public static int numberOfVandbraet(int roofLength)
    {
        int numberOfVandbraet = 0;

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