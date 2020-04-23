package FunctionLayer;

//Beregner
public class RoofCalculator {
    int pitchDegrees = 180;
    int roofTopSurfaceArea = 0;

    // TODO SPØRGMÅL: Skal vi ikke lave en Carport parent class? Så vi kan bruge enten requestCarport eller "result"Carport på sammme type objekt?
    Carport carport = new Carport();


    /*//Beregning af antal grader på hældning via bredde
    public int pitchedRoofcalculatorByWidth(int width, int height *//*TOOD - Er dette fastbestemt med en standard eller er det min til max (hvad)?*//*){
        //TODO lav beregninger til tagets hældning/spids via bredde???
        return pitchDegrees;
    }

    //Beregning af bredde via antal grader på hældning
    public int pitchedRoofcalculatorByDegrees(int pitchDegree, int height *//*TOOD - Er dette fastbestemt med en standard eller er det min til max (hvad)?*//*){
        //TODO lav beregninger til tagets bredde via tagets hældning/spids ???
        return widthCalculated;
    }*/



    //Areal beregning af fladt tag
    public int flatRoofLength(int tiltAngle) throws Exception {
        int roofLength;
        int roofHeight;

        //Vi antager at tagets vinkel er mindst 2 grader eftersom pr meter den skal stige med mindst 3 cm,
        // som svarer til lidt under 2 grader
        //Vi antager også at tagets vinkel er mindre end 45
        //TODO undersøg om tagets maxhældning som fladt tag
        if (tiltAngle < 2 || tiltAngle > 45)
            throw new Exception("Hældningen på taget må ikke være mindre end 2 grader");

        roofHeight = carport.getLength()*3;
        roofLength = (int) Math.hypot((double)carport.getLength(), (double) roofHeight);
        return roofLength;
    }


    //Areal beregning af tag med hældning (eller spids) - TODO - find ud af om det er hældning eller spids????
    public int pitchedRoofArea(int width, int depth, int pitchDegrees){
        roofTopSurfaceArea = width * depth + 15 ; //TODO - find ud af hvor meget der mindst skal være ekstra udover areal i kanterne
        return roofTopSurfaceArea;
    }


}
