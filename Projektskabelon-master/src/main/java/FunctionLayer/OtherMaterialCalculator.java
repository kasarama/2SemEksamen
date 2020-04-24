package FunctionLayer;

public class OtherMaterialCalculator {
    Carport carport = new Carport();
    WoodMaterialCalculator w = new WoodMaterialCalculator();

    // Bundskruer
    public int bottomScrews(int length, int width){
        // Plader fastgøres med plastmo bundskruer og skal anvendes 6 stk pr. meter på hver spær
        // Men 8 per meter på den første og den sidste spær
        double bottomScrews = (((w.raft(length)-2)*6)+16)*(width/100);
        double forskel = bottomScrews/200;
        int pakker;
        if (forskel<=1){
            pakker = 1;
        } else if (forskel<=2){
            pakker = 2;
        } else {
            pakker = 3;
        }
        return pakker;
    }

    // Hulbånd
    public int perforatedBand = 2;

    // UniversalHøjre
    public int universalBracketsRight(int length){
        int universalBracketsRight = w.raft(length);
        return universalBracketsRight;
    }

    // UniversalVenstre
    public int universalBracketsLeft(int length){
        int universalBracketsLeft = w.raft(length);
        return universalBracketsLeft;
    }

    // Skruer til vandbræt -- 1 pakke er nok til en stor carport
    public int waterboardScrews = 200;

    // Beslagskruer
    public int bracketScrews(int length){
        // Beslagskruer til spær:
        int bracketScrewsS = w.raft(length)*9;
        // Beslagskruer til hulbånd:
        int bracketScrewsH = (w.raft(length)-2)*2;
        // Får antallet af skruer:
        int bracketScrews = bracketScrewsS + bracketScrewsH;
        // Skal bruge antallet af pakker og der er 250 stk i 1 pakke:
        int forskel = 250/bracketScrews;
        int brancketScrewPk = 0;
        if (forskel<=1){
            brancketScrewPk = 1;
        } else if (forskel>1 && forskel<=2){
            brancketScrewPk = 2;
        } else if (forskel>2 && forskel<=3){
            brancketScrewPk = 3;
        } else {
            brancketScrewPk = 4;
        }
        return brancketScrewPk;
    }

    // Bræddebolte
    public int carriageBolts(int length, int width) {
        int carriageBolts = w.posts(length, width)*2;
        return carriageBolts;
    }

    // Firkantskiver
    public int squares(int length, int width){
        int squares = w.posts(length, width);
        return squares;
    }

    // Ydrebeklædnings skruer
    public int outherTimbering(int length, int width){
        int outherTimbering = 0;

        if (length < 500 && width < 510){
            outherTimbering = 200;
        }
        if (length > 500 && width > 510){
            outherTimbering = 400;
        }
        return outherTimbering;
    }

    // Inner beklædningsskruer
    public int innerTimbering(int length, int width){
        int innerTimbering = 0;

        if (length < 500 && width < 510){
            innerTimbering = 150;
        }
        if (length > 500 && width > 510){
            innerTimbering = 300;
        }
        return innerTimbering;
    }

    // Lås til skur
    public int shedLock = 1;

    // Hængsel til skur
    public int shedHinge = 2;

    // Vinkelbeslag til skur
        //løsholter gavle + løsholter sider

    // Tætningsprofil
    public int gasket(int width){
        int gasket = Math.round((width/100)*2);
        return gasket;
    }

}
