package FunctionLayer;

public class RoofSizing {

    Construction construction;
    private int roofLength;
    private double roofHeigth;
    private static int MINPITCHDEGREEOPTION = 15;
    private static int MAXPITCHDEGREEOPTION = 45 - 1; //Vi har valgt ud fra hvad productowner fra Fog har sagt
    //"45 grader vil blive et tårn" - men man kan finde det på fogs hjemmeside, så vi har derfor sagt 45-1

    public RoofSizing(Construction construction) {
        this.construction = construction;
    }

    //Beregning af tagets stigning
    public int roofHeight(boolean pitchedRoof, int lenght, int width) {
        if (pitchedRoof)
            roofHeigth = (int) (Math.tan(Math.toRadians(construction.getRoof().getDegree())) * width/2);
        else
            roofHeigth = (int) (Math.tan(Math.toRadians(construction.getRoof().getDegree()))* lenght);
        return (int) roofHeigth;
    }

    //Hjælpemetode for bredde af tag afhægnig af type
    public int roofWidthSurface() {
        int roofwidth;
        if (construction.getRoof().getIsPitched())
            roofwidth = pitchedRoofCalcutatedWidth();
        else
            roofwidth= construction.getConstructionWidth();
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnig af type
    public int roofLengthSurface(){
        int roofLength;
        if (construction.getRoof().getIsPitched())
            roofLength = construction.getConstructionLength();
        else
            roofLength = flatRoofCalcutatedLength();

        return roofLength;
    }

    //Areal hjælpeberegning af længde af fladt tags overflade
    public int flatRoofCalcutatedLength() {
        //Vi har fået beskrevet af productowner at fladt tag skal have en fast hældning
        roofHeigth = roofHeight(false, construction.getConstructionLength() , construction.getConstructionWidth());
        roofLength = (int) Math.hypot((double) construction.getConstructionLength(), (double) roofHeigth);
        return roofLength;
    }

    //Areal hjælpeberegning af halv bredde af tag med spids's overflade målt fra tagfod til tagryg
    public int pitchedRoofCalcutatedWidth(){
        //Vi har antaget at tagryggen går fra midt front til midt bagpå (parallelt med construction.length)
        int halfRaftWidthForPitchedRoof = construction.getConstructionWidth()/2;
        int roofHalfWidth = (int) (halfRaftWidthForPitchedRoof/(Math.cos(Math.toRadians(construction.getRoof().getDegree()))));
        return roofHalfWidth;
    }

    public int getRoofLength() {
        return roofLength;
    }

    public void setRoofLength(int roofLength) {
        this.roofLength = roofLength;
    }

    public double getRoofHeigth() {
        return roofHeigth;
    }

    public void setRoofHeigth(double roofHeigth) {
        this.roofHeigth = roofHeigth;
    }

    public static int getMINPITCHDEGREEOPTION() {
        return MINPITCHDEGREEOPTION;
    }

    public static int getMAXPITCHDEGREEOPTION() {
        return MAXPITCHDEGREEOPTION;
    }
}
