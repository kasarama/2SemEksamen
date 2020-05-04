package FunctionLayer;

public class ShedCalculator {

// TRÆ OG ANDET:
    // Lægte
    public static int shedLath = 1;


    // Løsholter
    // For gavlene skal der altid være 3 rækker, for siderne skal der altid være 2 rækker
    public static String løsholterTypeSide(int shedDept){
        String type;
        if (shedDept<=240){
            type = "Løsholter240";
        } else if (shedDept<=270){
            type = "Løsholter270";
        } else if (shedDept<=360){
            type = "Løsholter360";
        } else if (shedDept<=480){
            type = "Løsholter240";
        } else if (shedDept<=540){
            type = "Løsholter270";
        } else {
            type = "Løsholter360";
        }
        return type;
    }
    public static int løsholterAntalSide(int shedDept){
        int antal;
        if (shedDept<480){
            antal = 4;
        } else {
            antal = 8;
        }
        return antal;
    }
    public static String løsholterTypeGavl(int shedWidth){
        String type;
        if (shedWidth<=240){
            type = "Løsholter240";
        } else if (shedWidth<=270){
            type = "Løsholter270";
        } else if (shedWidth<=360){
            type = "Løsholter360";
        } else if (shedWidth<=480){
            type = "Løsholter240";
        } else if (shedWidth<=540){
            type = "Løsholter270";
        } else if (shedWidth<=720){
            type = "Løsholter360";
        } else {
            type = "Løsholter270";
        }
        return type;
    }
    public static int løsholterAntalGavl(int shedWidth){
        int antal;
        if (shedWidth<480){
            antal = 6;
        } else if (shedWidth<720){
            antal = 12;
        } else {
            antal = 18;
        }
        return antal;
    }

    // Skur stolpe
    public static int shedPosts(int length, int width, int shedWidth){
        int shedpost;
        if (shedWidth<=300){
            shedpost = ConstructionMaterialCalculator.posts(length, width)+6;
        } else {
            shedpost = ConstructionMaterialCalculator.posts(length, width)+4;
        }
        return shedpost;
    }

// SKRUER OG BESLAG
    // Lås til skur
    public static int shedLock = 1;

    // Hængsel til skur
    public static int shedHinge = 2;

    // Vinkelbeslag til skur
        //løsholter gavle + løsholter sider
    public static int vinkelbeslag (int shedWidth, int shedDept){
        int vinkelbeslag = løsholterAntalSide(shedDept) + løsholterAntalGavl(shedWidth);
        return vinkelbeslag;
    }


}
