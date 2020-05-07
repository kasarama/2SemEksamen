package FunctionLayer;

public class PitchedRoofMaterialCalculatorMona {

    Construction construction;
    Roof roof;
    ConstructionSizeCalculator constructionSizeCalculator;

    private int numberOfTaglaegter; // T1 taglægter til spær
    private int numberOfStern;
    private int numberOfToplaegteHolder;
    private int numberOfToplaegte; // T1 toplægter til rygsten
    private int numberOfTagfodsLaegte;
    private int numberOfVindskeder;
    private int numberOfVandbraet;
    private int toplaegteholder;


    public PitchedRoofMaterialCalculatorMona(Roof roof, ConstructionSizeCalculator constructionSizeCalculator, Construction construction) {
        this.constructionSizeCalculator = constructionSizeCalculator;
        this.construction = construction;
        this.roof = roof;
    }

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

 /* vandbræt = length of vinskider.. which depends on roof length.. so same method as above?
    /*
        Længde:  480
         2 stk

     */

//Beregning af needed length vindskeder - tag rejsning/ højde metode

//* Beregning af taglægte længde

//Note:  skal danne 300 mm udhæng i gavl ovenpå tykkelsen af sternbræt.  --> max/min roofLength?


    /* Vindskeder på rejsningen monteres med skruer på lægte enderne husk at dette bræt skal slutte
     1 cm. Over tagstenene.
     --> tag rejsning = ?
     --> tagsten højde = ?
     */

//Beregning af antal vandbræt -- What is it?
    /*
    På toppen af vindskeder i front og bagside monteres et vandbrædt (19x100) som beskyttelse og
    overlap mellem tagsten og vindskede.
     */

//Beregning af.. the needed taglægte distance/length??
// beregning af taglægte needed length?
//Note:  skal danne 300 mm udhæng i gavl ovenpå tykkelsen af sternbræt.  --> max/min roofLength?

//Beregning af..topLægter Rest længde

    /* Not mine...
    //Beregning af antal tagplade  = for loop in for loop. consider roof length and width + measurement of tagplade
    //Beregning af antal rygsten?
    //Rest calculations: sternbrædder, taglægte, toplægter
     */