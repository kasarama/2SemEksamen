package FunctionLayer;

//Beregner
public class RoofCalculator {
    // TODO SPØRGMÅL: Skal vi ikke lave en Carport parent class? Så vi kan bruge enten requestCarport eller "result"Carport på sammme type objekt?
    Carport carport = new Carport();


    //Areal beregning af fladt tag
    public int flatRoofCalcutatedSide(int tiltAngle) throws Exception {
        int roofLength;
        int roofHeight;

        //Vi antager at tagets hældning er mindst 2 grader eftersom pr meter den skal stige med mindst 1 cm,
        // som svarer til lidt under 2 grader
        //Vi antager også at tagets hældnning er mindre end 45
        //TODO undersøg om tagets maxhældning som fladt tag
        if (tiltAngle < 2 || tiltAngle > 45)
            throw new Exception("Hældningen på taget må ikke være mindre end 2 grader");

        roofHeight = (carport.getLength())*1;
        roofLength = (int) Math.hypot((double)carport.getLength(), (double) roofHeight);
        return roofLength;
    }


    //Areal beregning af tag med spids
    public int pitchedRoofCalcutatedSide(int pitchDegrees){
        int halfRaftWidthForPitchedRoof = carport.getWidth()/2;

        int roofwidth = halfRaftWidthForPitchedRoof*((int) Math.cos((double) (pitchDegrees/2)));

        return roofwidth;
    }


}
