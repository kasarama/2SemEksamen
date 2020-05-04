package FunctionLayer;

public class WoodMaterialCalculator {
    Construction construction = new Construction();

    // Understernbrædder
    public int understernboartU360(int length, int width){
        int antalU360;
        int lengthU360antal;
        int widthU360antal;
        if (length<=360){
            lengthU360antal = 2;
        } else if (length>540 && length<=720){
            lengthU360antal = 4;
        } else {
            lengthU360antal = 0;
        }
        if (width<=360){
            widthU360antal = 2;
        } else if (width>540 && width<=720){
            widthU360antal = 4;
        } else {
            widthU360antal = 0;
        }
        antalU360 = lengthU360antal + widthU360antal;
        return antalU360;
    }
    public int understernboartU540(int length, int width){
        int antalU540;
        int lengthU540antal;
        int widthU540antal;
        if (length>360 && length<=540){
            lengthU540antal = 2;
        } else if (length>720 && length<=780){
            lengthU540antal = 4;
        } else {
            lengthU540antal = 0;
        }
        if (width>360 && width<=540){
            widthU540antal = 2;
        } else if (width>720 && width<=780){
            widthU540antal = 4;
        } else {
            widthU540antal = 0;
        }
        antalU540 = lengthU540antal + widthU540antal;
        return antalU540;
    }
    // Oversternbrædder
    public int oversternboartU360(int length, int width){
        int oversternAntal = understernboartU360(length,width);
        return oversternAntal;
    }
    public int oversternboartU540(int length, int width){
        int oversternAntal = understernboartU540(length,width);
        return oversternAntal;
    }

    // Lægte
    public int shedLath = 1;

    // Løsholter

    // Rem
    public int rem600(int length, int width){
        int rem600Antal;
        if (width>600){
            rem600Antal = 3;
        } else {
            rem600Antal = 2;
        }
        return rem600Antal;
    }
    public int rem480(int length, int width){
        int rem480Antal;
        if (length>600){
            rem480Antal = 1;
        } else if (width>600){
            rem480Antal = 2;
        } else{
            rem480Antal = 0;
        }
        return rem480Antal;
    }

    // Spær
    public int raft (int length){
        int rafts = Math.round(length/50);
        return rafts;
    }

    // Stolper
    public int posts (int length, int width){
        int numberOfPosts = 0;

        if (length <= 300 && width < 510){
            numberOfPosts = 4;
        }else if (length <= 300 && width > 510){
            numberOfPosts = 6;
        } else if (length > 300 && width < 510){
            numberOfPosts = 6;
        }else if (length > 300 && width > 510){
            numberOfPosts = 9;
        }
        return numberOfPosts;
    }

    // Skur beklædning
    public int shedTimbering(int shedWidth){
        int areal = shedWidth* construction.getShedDepth();
        int shedTimbering = (int) Math.round(((areal/100)*12.5));
        return shedTimbering;
    }

    // Vandbræt


    // TODO Skal dette være her?
    /*// Tagplader
    public int roofAntal(int length, int width){
        int numberOfTrapezplader = 0;
        int T300Areal = 3;
        int T600Areal = 6;
        int samletAreal = length*width;
        int numberOfT300 = samletAreal/T300Areal;
        int numberOfT600 = samletAreal/T600Areal;

        // Hvis antallet af T300 er mindre end T600 bruges T300
        if (numberOfT300<numberOfT600){
            numberOfTrapezplader = numberOfT300;
        } else {
            numberOfTrapezplader = numberOfT600;
        }
        return numberOfTrapezplader;
    }
    public String roofType(int length, int width){
        String trapezplader = "";
        int T300Areal = 3;
        int T600Areal = 6;
        int samletAreal = (length/100)*(width/100);
        int numberOfT300 = samletAreal/T300Areal;
        int numberOfT600 = samletAreal/T600Areal;

        // Hvis antallet af T300 er mindre end T600 bruges T300
        if (numberOfT300<numberOfT600){
            trapezplader = "T300";
        } else {
            trapezplader = "T600";
        }
        return trapezplader;
    }*/

    // Skur stolpe
    public int shedPosts(boolean shed, int length, int width){
        int shedpost;
        if (shed){
            shedpost = posts(length, width)+2;
        } else {
            shedpost = posts(length, width);
        }
        return shedpost;
    }

}
