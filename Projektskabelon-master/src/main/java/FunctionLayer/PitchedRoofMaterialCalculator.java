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

    //C
    RoofSizing roofSizing;
    private int SCREWSPERTAGLÆGTEHOLDER = 5;
    private int LÆGTESTENDISTANCE = 307;
    private int RYGSTENCOVERS = 330;

    private int tagstenNakkekrog;

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

    ConstructionSizeCalculator constructionSizeCalculator;
    Construction construction;
    Roof roof;



    public PitchedRoofMaterialCalculator(Construction construction) {
        this.construction = construction;
        roofSizing = new RoofSizing(construction);
        roof = construction.getRoof();
    }

    public ArrayList<Material> pitchedRoof (Construction construction) throws LoginSampleException {
        ArrayList<Material> pitchedRoofMaterials = new ArrayList<>();

        // Todo: Set materials to the correct attributes and call amount methods where needed.
        // Todo: gavlOverlay, tagplader

        //Toplægter
        Material toplaegter = new Material();

        toplaegter.setName("TOPLÆGTE" + toplaegter.getThickness() + "x" + toplaegter.getWidth());
        toplaegter.setCategory("Rejsning Konstruktion");
        toplaegter.setUnit(LogicFacade.getUnitByName(toplaegter.getName()));
        toplaegter.setWidth(LogicFacade.getWidthByID(toplaegter.getId(),toplaegter.getName()));
        toplaegter.setThickness(LogicFacade.getThicknessByID(toplaegter.getId()));

        int quantityOfToplaegter = amountOfT1_RygstenLength();
        toplaegter.setAmount(quantityOfToplaegter);
        toplaegter.setComment("Lægte til montering af rygsten - lægges i toplægte holder");

        //todo: put 'getLengthForMaterials' method from Mapper in logicFacade..+ call it from there to get size (length)
        toplaegter.setSize(0); //  Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(toplaegter);

        //Taglægter
        Material taglaegter = new Material();

        taglaegter.setName("TAGLÆGTE" + taglaegter.getThickness() + "x" + taglaegter.getWidth());
        taglaegter.setCategory("Rejsning Konstruktion");
        taglaegter.setUnit(LogicFacade.getUnitByName(taglaegter.getName()));
        taglaegter.setWidth(LogicFacade.getWidthByID(taglaegter.getId(),taglaegter.getName()));
        taglaegter.setThickness(LogicFacade.getThicknessByID(taglaegter.getId()));

        int quantityOfTaglaegter = amountOfT1_Spaer_Taglaegter();
        taglaegter.setAmount(quantityOfTaglaegter);
        taglaegter.setComment("Lægte til montering på spær");

        taglaegter.setSize(0); //  Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(taglaegter);


        //Sternbrædder
        Material stern = new Material();

        stern.setName("STERNBRÆT" + stern.getThickness() + "x" + stern.getWidth());
        stern.setCategory("Rejsning Konstruktion");
        stern.setUnit(LogicFacade.getUnitByName(stern.getName()));
        stern.setWidth(LogicFacade.getWidthByID(stern.getId(),stern.getName()));
        stern.setThickness(LogicFacade.getThicknessByID(stern.getId()));

        int quantityOfStern = amountOfStern();
        stern.setAmount(quantityOfStern);
        stern.setComment("Bræt påsømmes enderne af tagspærene - dækker og beskytter spærene");


        stern.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(stern);

        //Vandbræt
        Material vandbraet = new Material();

        vandbraet.setName("VANDBRÆT" + vandbraet.getThickness() + "x" + vandbraet.getWidth());
        vandbraet.setCategory("Rejsning Konstruktion");
        vandbraet.setUnit(LogicFacade.getUnitByName(vandbraet.getName()));
        vandbraet.setWidth(LogicFacade.getWidthByID(vandbraet.getId(),vandbraet.getName()));
        vandbraet.setThickness(LogicFacade.getThicknessByID(vandbraet.getId()));

        int quantityOfVandbraet = amountOfVandbraet();
        vandbraet.setAmount(quantityOfStern);
        vandbraet.setComment("Bræt til montering på vindskeder -  beskytter mod fugtfæld");

        vandbraet.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper


        pitchedRoofMaterials.add(vandbraet);

        //Vindskeder
        Material vindskeder = new Material();

        vindskeder.setName("VINDSKEDER" + vindskeder.getThickness() + "x" + vindskeder.getWidth());
        vindskeder.setCategory("Rejsning Konstruktion");
        vindskeder.setUnit(LogicFacade.getUnitByName(vindskeder.getName()));
        vindskeder.setWidth(LogicFacade.getWidthByID(vindskeder.getId(),vindskeder.getName()));
        vindskeder.setThickness(LogicFacade.getThicknessByID(vindskeder.getId()));

        int quantityOfVindskeder = amountOfVindskeder();
        vindskeder.setAmount(quantityOfVindskeder);
        vindskeder.setComment("Bræt til montering på tag rejsning som afslutning på tagpaptage");

        vindskeder.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(vindskeder);


        //TagfodsLægte
        Material tagfodsLaegte = new Material();

        tagfodsLaegte.setName("TAGFODSLÆGTE" + tagfodsLaegte.getThickness() + "x" + tagfodsLaegte.getWidth());
        tagfodsLaegte.setCategory("Rejsning Konstruktion");
        tagfodsLaegte.setUnit(LogicFacade.getUnitByName(tagfodsLaegte.getName()));
        tagfodsLaegte.setWidth(LogicFacade.getWidthByID(tagfodsLaegte.getId(),tagfodsLaegte.getName()));
        tagfodsLaegte.setThickness(LogicFacade.getThicknessByID(tagfodsLaegte.getId()));

        int quantityOfTagfodsLaegte = amountOfTagfodsLaegte();
        tagfodsLaegte.setAmount(quantityOfTagfodsLaegte);
        tagfodsLaegte.setComment("Lægte til tagfod");

        tagfodsLaegte.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper


        pitchedRoofMaterials.add(tagfodsLaegte);

        //Rygsten
        Material rygsten = new Material();

        rygsten.setName("RYGSTEN" + rygsten.getThickness() + "x" + rygsten.getWidth());
        rygsten.setCategory("Rejsning Konstruktion");
        rygsten.setUnit(LogicFacade.getUnitByName(rygsten.getName()));
        rygsten.setWidth(LogicFacade.getWidthByID(rygsten.getId(),rygsten.getName()));
        rygsten.setThickness(LogicFacade.getThicknessByID(rygsten.getId()));

        int quantityOfRygsten = quantityRygsten();
        rygsten.setAmount(quantityOfRygsten);
        rygsten.setComment("Monteres på toplægte");

        rygsten.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(rygsten);


        //Tagsten /plader? - 3 typer med forskellife farver --> setName? setColor? ingen tykkelse, længde osv i db kunne ikke finde info
        Material tagsten = new Material();

        tagsten.setName(LogicFacade.getANameFromMaterialID(0)); //getNameFromMaterialID
        tagsten.setColor(roof.getColor());

        tagsten.setCategory("Rejsning Konstruktion");
        tagsten.setUnit(LogicFacade.getUnitByName(tagsten.getName()));
        tagsten.setWidth(LogicFacade.getWidthByID(tagsten.getId(),tagsten.getName()));
        tagsten.setThickness(LogicFacade.getThicknessByID(tagsten.getId()));

        int quantityOfTagsten = amountOfTagsten();
        tagsten.setAmount(quantityOfTagsten);
        tagsten.setComment("Monteres.. ");

        tagsten.setSize(0); // Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(tagsten);

        // ** Beslag **

        //toplægteHolder
        Material toplaegteHolder = new Material();
        toplaegteHolder.setName("TOPLÆGTEHOLDER" + toplaegteHolder.getThickness() + "x" + toplaegteHolder.getWidth());

        int quantityOfToplaegteHolder = amountOfToplaegteHolder();
        toplaegteHolder.setAmount(quantityOfToplaegteHolder);
        toplaegteHolder.setComment("monteres på toppen af spæret af toplægte");
        toplaegteHolder.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(toplaegteHolder);

        //Taglægter skruer
        Material taglaegteSkruer = new Material();
        taglaegteSkruer.setName("TAGLÆGTER SKRUER" + taglaegteSkruer.getThickness() + "x" + taglaegteSkruer.getWidth());

        int quantityOfTaglaegteScrews = screwForTaglægterCalculated();
        taglaegteSkruer.setAmount(quantityOfTaglaegteScrews);
        taglaegteSkruer.setComment("Skruer til taglægter");

        taglaegteSkruer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper
        pitchedRoofMaterials.add(taglaegteSkruer);


        //Vandbræt skruer
        Material vandbraetSkruer = new Material();
        vandbraetSkruer.setName("VANDBRÆT SKRUER" + vandbraetSkruer.getThickness() + "x" + vandbraetSkruer.getWidth());

        int quantityOfVandbraerScrews = screwsForVandbrætCalculated();
        vandbraetSkruer.setAmount(quantityOfVandbraerScrews);
        vandbraetSkruer.setComment("Skruer til vandbræt");

        vandbraetSkruer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(vandbraetSkruer);

        //toplægte skruer
        Material toplaegteSkruer = new Material();
        toplaegteSkruer.setName("TOPLÆGTER SKRUER" + toplaegteSkruer.getThickness() + "x" + toplaegteSkruer.getWidth());

        int quantityOfToplaegteScrews = amountOfBeslagScrewsForToplægteCalculated();
        toplaegteSkruer.setAmount(quantityOfToplaegteScrews);
        toplaegteSkruer.setComment("Skruer til toplægter");

        toplaegteSkruer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(toplaegteSkruer);

        //Vindskeder skruer
        Material vindskederSkruer = new Material();
        vindskederSkruer.setName("VINDSKEDER SKRUER" + vindskederSkruer.getThickness() + "x" + vindskederSkruer.getWidth());

        int quantityOfVindskederScrews = screwsForVindskederCalculated();
        toplaegteSkruer.setAmount(quantityOfVindskederScrews);
        toplaegteSkruer.setComment("Skruer til vindskeder");

        toplaegteSkruer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(vindskederSkruer);

        //toplægteHolder skruer
        Material toplaegteHolderSkruer = new Material();
        toplaegteHolderSkruer.setName("TOPLÆGTEHOLDER SKRUER" + toplaegteHolderSkruer.getThickness() + "x" + toplaegteHolderSkruer.getWidth());

        int quantityOfToplaegteHolderScrews =  amountOfBeslagScrewsForToplægteCalculated();
        toplaegteHolderSkruer.setAmount(quantityOfToplaegteHolderScrews);
        toplaegteHolderSkruer.setComment("Skruer til toplægteholder");

        toplaegteHolderSkruer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(toplaegteHolderSkruer);


        //Rygsten Beslag
        Material rygstenBeslag = new Material();
        rygstenBeslag.setName("RYGSTENBESLAG" + rygstenBeslag.getThickness() + "x" + rygstenBeslag.getWidth());

        int quantityOfRygstenBeslag =  amoutOfRygstenBeslagCalculated()
        rygstenBeslag.setAmount(quantityOfRygstenBeslag);
        rygstenBeslag.setComment("Beslag til rygsten");

        rygstenBeslag.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(rygstenBeslag);

        //spær til tag
        Material tagSpaer = new Material();
        tagSpaer.setName("SPÆR"+ tagSpaer.getThickness() + "x" + tagSpaer.getWidth());

        int quantityOfSpaer = spærFullQuantityOfPlanksTotal();
        tagSpaer.setAmount(quantityOfSpaer);
        tagSpaer.setComment("Spær til tag");

        tagSpaer.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(tagSpaer);


        //Nakkekrog til tagsten
        Material tagstenNakkekroge = new Material();
        tagstenNakkekroge.setName("TAGSTEN NAKKEKROGE" + tagstenNakkekroge.getThickness() + "x" + tagstenNakkekroge.getWidth());

        int quantityOfNakkekrog = tagstenNakkekrogeCalculated();
        tagstenNakkekroge.setAmount(quantityOfNakkekrog);
        tagstenNakkekroge.setComment("Til montering af tagsten");

        tagstenNakkekroge.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(tagstenNakkekroge);

        //Bindere til tagsten
        Material tagstenBindere = new Material();
        tagstenBindere.setName("TAGSTEN BINDERE" + tagstenBindere.getThickness() + "x" + tagstenBindere.getWidth());

        int quantityOfBindere = tagstenBindereCalculated();
        tagstenBindere.setAmount(quantityOfBindere);
        tagstenBindere.setComment("Til montering af tagsten");

        tagstenBindere.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(tagstenBindere);


        //Gavl - 0,0 i parameter?
        Material gavlOverlay = new Material();
        gavlOverlay.setName("GAVLOVERLAY" +  gavlOverlay.getThickness() + "x" +  gavlOverlay.getWidth());

        int quantityOfGavlOverlay = gavlOverlayQuantity(0,0);
        gavlOverlay.setAmount(quantityOfGavlOverlay);
        gavlOverlay.setComment("Til montering af tagsten");

        gavlOverlay.setSize(0); //Længde fra DB - metode der henter længde fra DB i Mapper

        pitchedRoofMaterials.add(gavlOverlay);

        return pitchedRoofMaterials;
    }


    //........ CALCULATIONS .........

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
        screwForTaglægter = amountOfToplaegteHolder() * SCREWSPERTAGLÆGTEHOLDER;
        return screwForTaglægter;
    }

    public int screwsForVindskederCalculated(){
        //Vi antager der bruges en skrue for hvert 50cm
        vindskedeLængde = (int)(Math.hypot((construction.getConstructionWidth()/2.0), (double) (roofSizing.roofHeight(
                construction.getRoof().getIsPitched(), construction.getConstructionLength(),
                construction.getConstructionWidth()))));
        for (int i = 50; i < vindskedeLængde-50 ; i = i + 50) {
            screwsForVindskeder++;
        }
        return screwsForVindskeder;
    }

    public int screwsForVandbrætCalculated(){
        //Vi antager der skal bruges til hver 30 cm en skrue
        vandBrætsLength = construction.getRoof().getLength();
        for (int i = 30; i < vandBrætsLength -30 ; i = i + 30) {
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


    public int spærPlankLengthPerSpær(){
        int spærfodLength = construction.getCarportWidth();
        int spærArm = (int) (spærfodLength/(Math.cos(Math.toRadians(construction.getRoof().getDegree()))))*2;
        spærFullPlankLength = (spærArm*2)+spærfodLength;
        return spærFullPlankLength;
    }
    //TODO beregning af ekstra spær (til sidst)
    public int spærQuantity(){
        int carportLength = construction.getCarportLength();
        int distanceBestweenSpær = 89;
        for (int i = 0; i < carportLength; i = 1 + distanceBestweenSpær) {
            spærAmount++;
        }
        if (construction.getShed() != null) {
            spærAmount = spærAmount+ 2;
        }
        return spærAmount;
    }

    public int spærFullQuantityOfPlanksTotal(){
        spærFullQuatityOfPlanks = spærPlankLengthPerSpær()* spærQuantity();
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
    private int amountOfT1_Spaer_Taglaegter()
    {
        int roofWidth = roof.getWidth();
        int T1_SpaerDistance = 307; // 307 mm mellem hvert lægte - dog ikke den første
        int topDistance = 30; // 30 mm på hver side dvs * 2

        numberOfTaglaegter = roofWidth - (topDistance * 2)/T1_SpaerDistance + 2; // 2 = 350mm bræt
        return numberOfTaglaegter;
    }

    // ** Beregning af antal sternbrædder i forhold til tagets længde - stern skal have samme længde som taget + 300 mm**
    public int amountOfStern()
    {
        int roofLength = roof.getLength();
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
    private int amountOfToplaegteHolder()
    {
        int spaer = constructionSizeCalculator.roofSpaerAmount(construction);
        int toplaegteholder = 0;

        numberOfToplaegteHolder = toplaegteholder * spaer;
        return numberOfToplaegteHolder;
    }

    //** Beregning af T1 toplægte (til rygsten) i forhold til tag længde **
    public int amountOfT1_RygstenLength()
    {
        int roofLength = roof.getLength();

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
    public int amountOfTagfodsLaegte ()
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
    public int amountOfVindskeder ()
    {
       int  roofLength = roof.getLength();
       int  roofHeight = roof.getHeight();

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
    public  int amountOfVandbraet()
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