package FunctionLayer;

public class RoofSizing {

    Construction construction;
    private int roofLength;
    private double roofFullTilt;
    private int minpitchDegreeOption = 15;
    private int maxpitchDegreeOption = 45 - 1; //Vi har valgt ud fra hvad productowner fra Fog har sagt
    //"45 grader vil blive et tårn" - men man kan fælge det på fogs hjemmeside, så vi har derfor sagt 45-1

    public RoofSizing(Construction construction) {
        this.construction = construction;
    }

    //Beregning af tagets stigning
    public int roofHeight(boolean pitchedRoof) {
        roofFullTilt = (int) Math.tan(construction.getRoof().getDegree()) /* TODO PROBLEM - her skal stå roofFLat.getRoofRaisedCmPrCmLength istedet for grad beregning*/ *construction.getConstructionLength();
        if (pitchedRoof)
            roofFullTilt = Math.tan(construction.getRoof().getDegree()) * ((construction.getCarportWidth() / 2.0)); //TODO se om det virker
        return (int) roofFullTilt;
    }

    //Muligheder for vinklens grader angående af tagryggen på et tag med rejsning
    public int[] pitchDegreesOptionsForCostumerToChoose(){
        int deltaDegreeOption = maxpitchDegreeOption-minpitchDegreeOption;
        int[] pitchDegreeOptions = new int[deltaDegreeOption];
        for (int i = 0; i < (deltaDegreeOption-1); i=+5) {
            pitchDegreeOptions[i] = minpitchDegreeOption+5;
        }
        return pitchDegreeOptions;
    }

    //Hjælpemetode for bredde af tag afhægnig af type
    public int roofWidthSurface() throws Exception {
        int roofwidth = construction.getCarportWidth();
        if (construction.getRoof().getIsPitched()) {
            roofwidth = pitchedRoofCalcutatedWidth(construction.getRoof().getDegree());
        }
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnig af type
    public int roofLengthSurface() throws Exception {
        int roofLength = flatRoofCalcutatedLength(construction.getRoof().getDegree());

        if (construction.getRoof().getIsPitched()) {
            roofLength = construction.getCarportLength();
        }
        return roofLength;
    }

    //Areal hjælpeberegning af længde af fladt tags overflade
    public int flatRoofCalcutatedLength(int tiltAngle) throws Exception {
        //Vi har fået beskrevet af productowner at fladt tag skal have en fast hældning
        roofFullTilt = roofHeight(false);
        roofLength = (int) Math.hypot((double) construction.getCarportLength(), (double) roofFullTilt);
        return roofLength;
    }

    //Areal hjælpeberegning af bredde af tag med spids's overflade
    public int pitchedRoofCalcutatedWidth(int pitchDegrees){
        //Vi har antaget at tagryggen går fra midt front til midt bagpå (parallelt med construction.length)
        int halfRaftWidthForPitchedRoof = construction.getCarportWidth();
        int roofWidth = (int) (halfRaftWidthForPitchedRoof*(Math.sin((double) (pitchDegrees))));
        return roofWidth;
    }

    public int getRoofLength() {
        return roofLength;
    }

    public void setRoofLength(int roofLength) {
        this.roofLength = roofLength;
    }

    public double getRoofFullTilt() {
        return roofFullTilt;
    }

    public void setRoofFullTilt(double roofFullTilt) {
        this.roofFullTilt = roofFullTilt;
    }

    public int getMinpitchDegreeOption() {
        return minpitchDegreeOption;
    }

    public void setMinpitchDegreeOption(int minpitchDegreeOption) {
        this.minpitchDegreeOption = minpitchDegreeOption;
    }

    public int getMaxpitchDegreeOption() {
        return maxpitchDegreeOption;
    }

    public void setMaxpitchDegreeOption(int maxpitchDegreeOption) {
        this.maxpitchDegreeOption = maxpitchDegreeOption;
    }

}
