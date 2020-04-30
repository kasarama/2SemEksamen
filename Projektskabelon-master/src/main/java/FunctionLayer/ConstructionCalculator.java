package FunctionLayer;

public class ConstructionCalculator {
    public ConstructionCalculator() {
    }

    public static RoofMaterialCalculator r = new RoofMaterialCalculator();

// TRÆ OG ANDET:
    // Stolper
    public int posts (int length, int width){
        int numberOfPosts = 0;

        if (width < 600){
            if (length <=300){
                numberOfPosts = 4;
            } else if (length < 600){
                numberOfPosts = 6;
            } else {
                numberOfPosts = 8;
            }
        } else if (width > 600){
            if (length <=300){
                numberOfPosts = 6;
            } else if (length < 600){
                numberOfPosts = 9;
            } else {
                numberOfPosts = 12;
            }
        }
        return numberOfPosts;
    }

// SKRUER OG BESLAG
    // Hulbånd
    public int perforatedBand(int length, int width){
        double band = Math.sqrt((Math.pow((length/100),2)) + (Math.pow((width/100),2)))*2;
        int ruller;
        if (band<1){
            ruller = 1;
        } else if (band<2){
            ruller = 2;
        } else {
            ruller = 3;
        }
        return ruller;
    }
    // Beslagskruer
    public int bracketScrewsCon(int length){
        // Beslagskruer til hulbånd:
        int bracketScrewsH = (r.raft(length)-2)*2;
        // Skal bruge antallet af pakker og der er 250 stk i 1 pakke:
        int forskel = 250/bracketScrewsH;
        int brancketScrewPk = 0;
        if (forskel<=1){
            brancketScrewPk = 1;
        } else if (forskel<=2){
            brancketScrewPk = 2;
        } else if (forskel<=3){
            brancketScrewPk = 3;
        } else {
            brancketScrewPk = 4;
        }
        return brancketScrewPk;
    }


}
