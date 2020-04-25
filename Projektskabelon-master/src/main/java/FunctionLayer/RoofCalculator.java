package FunctionLayer;

import java.security.PrivateKey;

//Beregner
public class RoofCalculator {

    private Carport carport;

    private int roofLength;
    private int roofHeight;

    public RoofCalculator(Carport carport) {
        this.carport = carport;
    }

    public int roofHeight(boolean pitchedRoof){
        roofHeight = (carport.getLength())*1;
        if (pitchedRoof)
            roofHeight = (int) (Math.tan((double) carport.getRoof().getDegree()))*(carport.getWidth()/2); //TODO se om det virker
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
        int minDegreeOption = 90; //TODO slå det op i tegning/beskrivelse
        int maxDegreeOption = 180-1; //TODO slå det op i tegning/beskrivelse
        int deltaDegreeOption = maxDegreeOption-minDegreeOption;
        int[] pitchDegreeOptions = new int[deltaDegreeOption];
        for (int i = 0; i < (deltaDegreeOption-1); i++) {
            pitchDegreeOptions[i] = minDegreeOption++;
        }
        return pitchDegreeOptions;
    }

    //Hjælpemetode for bredde af tag afhægnigt af type
    public int roofwidthHelper() throws Exception {
        int roofwidth = carport.getWidth();
        if (carport.getRoof().isPitched()) {
            roofwidth = pitchedRoofCalcutatedWidth(carport.getRoof().getDegree());
        }
        return roofwidth;
    }
    //Hjælpemetode for længde af tag afhægnigt af type
    public int rooflenghtHelper() throws Exception {
        int roofLength = flatRoofCalcutatedSide(carport.getRoof().getDegree());

        if (carport.getRoof().isPitched()) {
            roofLength = carport.getLength();
        }
        return roofLength;
    }

}
