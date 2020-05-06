package FunctionLayer;

public class PitchedRoofMaterialCalculator extends Roof {
    //todo: fix attributes with attributes from Roof?


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