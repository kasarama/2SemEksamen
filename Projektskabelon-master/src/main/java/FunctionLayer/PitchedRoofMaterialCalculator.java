package FunctionLayer;

public class PitchedRoofMaterialCalculator {

    Construction construction;
    private int RygstenBeslag;
    private int tagstenBinder;
    private int tagstenNakkekrog;
    private int toplægteHolder;

    private int screwForTaglægter;
    private int screwsForVindskeder;
    private int screwsForVandbræt;
    private int beslagForToplægte;
    private int screwPackage;

    private int vindskedeLængde = 0; //Todo ændre dette når du har fået fat i Mona :D
    private int vandBrætsLængde = 0; ///Todo ændre dette når du har fået fat i Mona :D

    private int tagstenEntirePitchedRoof;
    private int lægteafstand = 307; //TODO evt. hente fra Mona
    private int tagstenBredde;

    RoofSizing roofSizing;

    public PitchedRoofMaterialCalculator(Construction construction) {
        this.construction = construction;
        roofSizing = new RoofSizing(construction);
    }

    public int amoutOfRygstenBeslagCalculated() {
        //TODO - hent antal spær fra Monas beregning !!
        return RygstenBeslag;
    }

    public int amountOfTagsten(){
        int tagstenHalfePitchedRoof = 0;
        //Vi trækker ikke tagestenbredde fra i taget længde i for loopet fordi vi vil have det hele antal + en hvis
        // der er en rest
        for (int i = 0; i < roofSizing.roofWidthSurface()-lægteafstand; i= i + lægteafstand) {
            for (int j = 0; j < roofSizing.roofLengthSurface(); j = j + tagstenBredde) {
                tagstenHalfePitchedRoof++;
            }
        }
        tagstenEntirePitchedRoof = tagstenHalfePitchedRoof * 2;
        return tagstenEntirePitchedRoof;
    }
    
    public int tagstenBindereCalculated(){
        int tagstenBinder = amountOfTagsten();
        for (int i = 0; i < tagstenBinder; i = i+2) {
            tagstenBinder ++;
        }
        return tagstenBinder;
    }

    public int tagstenNakkekrogeCalculated(){
                       //TODO FInd ud af hvor mange? Formoder en pr. tagsten
        tagstenNakkekrog = amountOfTagsten();
        return tagstenNakkekrog;
    }

    public int toplægteHolderCalculated(){
        toplægteHolder = amoutOfRygstenBeslagCalculated();
        return toplægteHolder;
    }

    public int screwForTaglægterCalculated(){
        //TODO - hent hvor lang lægten + spær er fra Monas beregning !!
        //Vi antager der er er en skrue pr toplægteholder samt et pr spær for at sætte toplægten fast
        screwForTaglægter = toplægteHolder; // TODO + antal spær
     return screwForTaglægter;
    }

    public int screwsForVindskederCalculated(){
        //Vi antager der bruges en skrue for hvert 50cm plus startskrue
        //TODO - hent hvor lang vindskederne er pr. styk. Der må i alt være mindst fire fordi det er pitched
        for (int i = 0; i < vindskedeLængde ; i = i + 50) {
            screwsForVindskeder++;
        }
        return screwsForVindskeder;
    }

    public int screwsForVandbrætCalculated(){
        //Vi antager der skal bruges til hver 30 cm en skrue samt startskrue:
        for (int i = 0; i < vandBrætsLængde ; i = i + 50) {
            screwsForVindskeder++;
        }
        return screwsForVandbræt;
    }

    /*public int AmountOfScrewPackages(){
        int screwsTotal = screwForTaglægterCalculated() + screwsForVindskederCalculated()
                + screwsForVandbrætCalculated();
        screwPackage = Math.round(screwsTotal/200);
        return screwPackage;
    }*/

    public int amountOfBeslagForToplægteCalculated(){

        return beslagForToplægte;
    }

}
