package FunctionLayer;


public class RoofSizing {

    Carport carport;
    private int roofLength = carport.getLength() + carport.getShed().getDepth();
    private int roofHeight;
    private int minpitchDegreeOption = 15;
    private int maxpitchDegreeOption = 45 - 1; //Vi har valgt ud fra hvad produktowneren fra Fog har sagt
    //"45 grader vil blive et tårn" - men man kan fælge det på fogs hjemmeside, så vi har derfor sagt 45-1
    private int minTiltDegreeOption = 2;

    public RoofSizing(Carport carport) {
        this.carport = carport;
    }

    //Beregning af taget højde
    public int roofHeight(boolean pitchedRoof) {
        roofHeight = (int) Math.tan((double)(carport.getRoof().getDegree()))*carport.getLength();//TODO - skriv evt gange x pr meter * carport.length
        if (pitchedRoof)
            roofHeight = (int) (Math.tan(carport.getRoof().getDegree()) * ((carport.getWidth() / 2))); //TODO se om det virker
        return roofHeight;
    }

    //Beregning af max vinkel på tagryg (spisds tag)
    public int tilltAngleMaxCal() {
    int tiltAnglemax = (int) Math.tanh((double) (20 / 100)); //Todo ret metode
    return tiltAnglemax;
    }

    //Areal beregning af fladt tag
    public int flatRoofCalcutatedSide(int tiltAngle) throws Exception {
        //Vi antager også at tagets hældnning er mindre end nedenstående beregning, som svarer til 20 cm pr meter
        // stigning
        //Vi antager at tagets hældning er mindst 2 grader eftersom pr meter den skal stige med mindst 3 cm pr meter,
        // som svarer til lidt under 2 grader
        if (tiltAngle < 2 || tiltAngle > tilltAngleMaxCal())
            throw new Exception("Hældningen på taget må ikke være mindre end 2 grader");
        roofHeight = roofHeight(false);
        roofLength = (int) Math.hypot((double)carport.getLength(), (double) roofHeight);
        return roofLength;
    }

    //Areal beregning af tag med spids
    public int pitchedRoofCalcutatedWidth(int pitchDegrees){
        int halfRaftWidthForPitchedRoof = carport.getWidth();
        int roofWidth = halfRaftWidthForPitchedRoof*((int) Math.sin((double) (pitchDegrees)));

        return roofWidth;
    }

    //Beregning af vinklen af tagryggen på et tag med rejsning
    public int[] pitchDegreesOptionsForCostumerToChoose(){
        int deltaDegreeOption = maxpitchDegreeOption-minpitchDegreeOption;
        int[] pitchDegreeOptions = new int[deltaDegreeOption];
        for (int i = 0; i < (deltaDegreeOption-1); i=+5) {
            pitchDegreeOptions[i] = minpitchDegreeOption+5;
        }
        return pitchDegreeOptions;
    }

    //Beregning af vinklen af tagryggen på et tag med rejsning
    public int[] tiltDegreesOptionsForCostumerToChoose(){
        int deltaDegreeOption = tilltAngleMaxCal()-minTiltDegreeOption;
        int[] pitchDegreeOptions = new int[deltaDegreeOption];
        for (int i = 0; i < (deltaDegreeOption-1); i++) {
            pitchDegreeOptions[i] = minTiltDegreeOption+5;
        }
        return pitchDegreeOptions;
    }

    //Hjælpemetode for bredde af tag afhægnig af type
    public int roofWidthSurface() throws Exception {
        int roofwidth = carport.getWidth();
        if (carport.getRoof().isPitched()) {
            roofwidth = pitchedRoofCalcutatedWidth(carport.getRoof().getDegree());
        }
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnig af type
    public int roofLengthSurface() throws Exception {
        int roofLength = flatRoofCalcutatedSide(carport.getRoof().getDegree());

        if (carport.getRoof().isPitched()) {
            roofLength = carport.getLength();
        }
        return roofLength;
    }

    public int getRoofLength() {
        return roofLength;
    }

    public void setRoofLength(int roofLength) {
        this.roofLength = roofLength;
    }

    public int getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(int roofHeight) {
        this.roofHeight = roofHeight;
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

    public int getMinTiltDegreeOption() {
        return minTiltDegreeOption;
    }

    public void setMinTiltDegreeOption(int minTiltDegreeOption) {
        this.minTiltDegreeOption = minTiltDegreeOption;
    }


}
