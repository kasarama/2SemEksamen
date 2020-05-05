package FunctionLayer;

public class PitchedRoofMaterialCalculator {

    Construction construction;
    private int length = construction.getCarportLength();
    private int width = construction.getCarportWidth();

    private int roofLength;
    private int vindskider;
    private int vandbraet;
    private int stern;
    private int t1_SpaerLength = 540;  //taglægte til spær
    private int t1_RygstenLength = 420; //taglægte til rygsten
    private int tagfodslaegteBraet = 540; // tagfodslægteBræt
    private int tagplade; // B&C Dobbelt -s sort (tagplade)

    //** Beregning af antal taglægter for pitchedRoof - Remember: tilpas med t1_SpaerLength! **
    private int numberOfT1_Spaer (int roofLength)
    {
        //length = roofLength;
        int T1_SpaerDistance = 307; // 307 mm mellem hvert lægte - dog ikke den første
        int topDistance = 30; // 30 mm på hver side dvs *2

        int numberOfT1_Spaer = roofLength - (topDistance * 2)/T1_SpaerDistance + 2;
        return numberOfT1_Spaer;
    }

    // ** Beregning af antal sternbrædder i forhold til tagets længde - stern skal have samme længde som taget **
    //Note: antager at 30 mm udhæng er inkluderet i tagets længde.  --> max/min roofLength?
    public static int numberOfstern (int roofLength)
    {
        int numberOfStern = 0;
        if (roofLength <= 600 ) //600 mm = stern længde
        {
            numberOfStern = 2; // 1 on each side
        }
        else if (roofLength > 600)
        {
            numberOfStern = 4; // 2 on each side
        }

        return numberOfStern;
    }

    //Beregning af antal vindskider
    /* Vindskeder på rejsningen monteres med skruer på lægte enderne husk at dette bræt skal slutte
     1 cm. Over tagstenene.
     --> tag rejsning = ?
     --> tagsten højde = ?
     */

    //Beregning af antal vandbræt

    //Beregning af.. the needed taglægte distance?
    //Beregning af..topLægter Rest længde
    //Beregning af tagplade amount = for loop in for loop. consider roof length and width + measurement of tagplade


    //Rest calculations: sternbrædder, taglægte

}
