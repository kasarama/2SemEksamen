package FunctionLayer;

public class PitchedRoofMaterialCalculator {

    ConstructionSizeCalculator constructionSizeCalculator;
    Construction construction;
    RoofSizing roofSizing;
    Roof roof;

    //M
    private int numberOfTaglaegter; // T1 taglægter til spær
    private int numberOfStern;
    private int numberOfToplaegteHolder;
    private int numberOfToplaegte; // T1 toplægter til rygsten
    private int numberOfTagfodsLaegte;
    private int numberOfVindskeder;
    private int numberOfVandbraet;
    private int toplaegteholder;

    //C
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



    public PitchedRoofMaterialCalculator(Construction construction, Roof roof, ConstructionSizeCalculator constructionSizeCalculator) {
        this.construction = construction;
        roofSizing = new RoofSizing(construction);
        this.roof = roof;
        this.constructionSizeCalculator = constructionSizeCalculator;
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