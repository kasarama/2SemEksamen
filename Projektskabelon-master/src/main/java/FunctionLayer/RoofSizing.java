package FunctionLayer;

import java.security.PrivateKey;

//Beregner
public class RoofSizing {

    private Carport carport;

    private int roofLength;
    private int roofHeight;
    private int minpitchDegreeOption = 20; //TODO slå det op i tegning/beskrivelse
    private int maxpitchDegreeOption = 45-1; //TODO slå det op i tegning/beskrivelse
    private int minTiltDegreeOption = 2; //TODO slå det op i tegning/beskrivelse
    private int maxTiltDegreeOption = 10; //TODO slå det op i tegning/beskrivelse

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

    public int getMaxTiltDegreeOption() {
        return maxTiltDegreeOption;
    }

    public void setMaxTiltDegreeOption(int maxTiltDegreeOption) {
        this.maxTiltDegreeOption = maxTiltDegreeOption;
    }

    public RoofSizing(Carport carport) {
        this.carport = carport;
    }

    public int roofHeight(boolean pitchedRoof){
        roofHeight = (carport.getLength())*1;
        if (pitchedRoof)
            roofHeight = (int) (Math.tan((double) carport.getRoof().getDegree()))*((carport.getWidth()/2)); //TODO se om det virker
        return roofHeight;
    }

    //Areal beregning af fladt tag
    public int flatRoofCalcutatedSide(int tiltAngle) throws Exception {
        //Vi antager at tagets hældning er mindst 2 grader eftersom pr meter den skal stige med mindst 1 cm,
        // som svarer til lidt under 2 grader
        //Vi antager også at tagets hældnning er mindre end 45
        //TODO undersøg om tagets maxhældning som fladt tag
        if (tiltAngle < 2 || tiltAngle > 45)
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
        int deltaDegreeOption = maxTiltDegreeOption-minTiltDegreeOption;
        int[] pitchDegreeOptions = new int[deltaDegreeOption];
        for (int i = 0; i < (deltaDegreeOption-1); i++) {
            pitchDegreeOptions[i] = minTiltDegreeOption+5;
        }
        return pitchDegreeOptions;
    }

    //Hjælpemetode for bredde af tag afhægnigt af type
    public int roofWidthSurface() throws Exception {
        int roofwidth = carport.getWidth();
        if (carport.getRoof().isPitched()) {
            roofwidth = pitchedRoofCalcutatedWidth(carport.getRoof().getDegree());
        }
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnigt af type
    public int roofLengthSurface() throws Exception {
        int roofLength = flatRoofCalcutatedSide(carport.getRoof().getDegree());

        if (carport.getRoof().isPitched()) {
            roofLength = carport.getLength();
        }
        return roofLength;
    }

}
