package FunctionLayer;

/**
 * @author Magdalena and Mia
 */
public class ConstructionSizeCalculator {
    //todo some of the post are common for sides and the back - remember that when drowing or making itemlist
    //todo method counting shared posts
    //todo we need to update postHights with data about the length to be berried in the ground. We can also ask Tu if
    // the posts could be chosen to be set on a surface instead of in the ground

    final private  static int POSTSIZE=100;
    final private  static int CMPERM=100;
    final private  static int MAXPOSTDISTANCE=3000;
    final private  static int MAXROWSISTANCE=6000;
    final private  static int DOORWIDTH=1000;




    //counts how many posts should there be on one side of a carport or a shed
    public  static int sidePostAmount(int size){
        int numberOfPost;
        size=size-POSTSIZE;
        if(size%MAXPOSTDISTANCE==0){ //
            numberOfPost=size/MAXPOSTDISTANCE+1;
        } else {
            numberOfPost= (( size - size%MAXPOSTDISTANCE)/MAXPOSTDISTANCE)+2; //(750cm -(3*300) =0) 750%300=2 2*300=600 (150????)
        }
        return numberOfPost;
    }


    //counts distance between posts on the side
    public static int postDistanceMax3000(int size) {
        return (size-POSTSIZE)/(sidePostAmount(size)-1);
    }

    //counts how much the roof drops/raises on the given distance in mm
    public static double raising(int angle, int distance){

        return (double) angle* (double) distance/ (double)CMPERM;
    }

    // fills up the array with heights of posts on the one side of the shed or carport starting from the shortest one
    public static Integer[] postsHeights(double height, int angle, int size){
        //todo when calculating postHeights of carport, int height should be the heighest one of shed posts
        int postNumber=sidePostAmount(size);
        int distance = postDistanceMax3000(size);
        Integer[] postHeights = new Integer[postNumber];
        postHeights[0]=(int)height;
        for (int i = 1; i < postHeights.length ; i++) {
            height= height+ raising(angle, distance);
            postHeights[i]=(int)height;
        }

        return postHeights;
    }

    //counts how many rows of post should there be because max distans between posts is 600 cm from side to side
    public static int postRows (int width){
        int rows;
        if(width%MAXROWSISTANCE==0){
            rows=width/MAXROWSISTANCE+1;
        } else {
            rows=(width - width%MAXROWSISTANCE)/MAXROWSISTANCE +2;
        }
        return  rows;
    }


    //////.........SHED FRONT SIDE ........../////////

    //counts number of post on the front side of the shed
    public static int shedFrontPostsAmount(int width) {
        //method cunts posts starting from the door not from the very first post. That missing post comes in door calculation
        width = width - DOORWIDTH-POSTSIZE/2;

        return sidePostAmount(width);
    }

    public static int carportMinHeight(int constuctionsMinHeight,int shedDepth, int raising) {
        //todo returns length of the lowest post of carport
        return (int) (constuctionsMinHeight+raising(raising,shedDepth));
    }


    public static int possibleRems(Construction construction){
        int[] possibleRems = new int[]{3000, 3600, 4200, 4800, 5400, 6000, 6600, 7200};
        int carportLength = construction.getCarportLength();
        int wantedRem = 0;
        int difference = 0;
        // Iterating:
        for (int i = 0; i < possibleRems.length; i++){
            // For hver værdi i arrayet, hvis værdien (i) er under vores længde skal den næste bruges
            // Tag hver forskel, og find den nærmeste positive værdi
            difference = possibleRems[i]-carportLength;
            if (difference>=0){
                wantedRem = (carportLength+difference)/10;
                break;
            }
        }
        return wantedRem;
    }

    public static int[] remPieces (Construction construction){
        //todo count witch lengths of "rem" tree chould be used so the connections ar in the right places if "rem"
        // should be compoused of more than one piece and return them in Integer[]
        /*
            Der findes 45*195: 300, 360, 420, 480, 540, 600, 660, 720
            Vi ved hvor langt der er mellem stolperne (postDistanceMax300)
            og hvor mange stolper der bliver brugt (sidePostAmount).
            1. Hvis længden er over 720 uden skur:
                Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                Samlet på 2. stolpe: (1*300 og 1*480)*2
            2. Hvis konstruktionens længde er over 720 (Det samme gælder hvis skuret kun fylder halvdelen - symetri):
                2A. Hvis carporten er under 720 og skuret er <= 300:
                    (1*tættestPåCarportLængde og 1*300)*2
                2B. Hvis carporten er under 720 og skuret er under 360:
                    (1*tættestPåCarportLængde og 1*360)*2
                2C. Hvis carporten er over 720 og skuret er <= 300:
                    (1*Punkt1 og 1*300)*2
                2D. Hvis carporten er over 720 og skuret er under 360:
                    (1*Punkt1 og 1*360)*2
            3. Hvis bredden er over 600:
                Så skal alt overstående lægges 1 til

        først tjek om construction længde er mindre eller lige med 600
        if not: 1. lav en rem til shed (den bliver mac 3500 mm)
        2. fordel carports længde på 2 lige stykker eller find den stolpe det skal samles på
        3 havd så hvis skur er kun på halve af carportts bredde - hvor skal de samles henne??
        hvis brædde >6000 mm så rem antal gang 2???
         */
        //todo in ConstrucionMaterialCalculator implement the method that will return Material object for each of pieces
        int[] remPieces = new int[0];
        int carportLength = construction.getCarportLength();
        int constructionLength = construction.getConstructionLength();
        int constructionWidth = construction.getConstructionWidth();
        int shedDept = construction.getShedDepth();
        int tmpRem = possibleRems(construction);
        // Hvis shedDept = 0 er der ikke noget skur

        if (constructionWidth<6000){
            if (carportLength>7200 && shedDept == 0){
                // Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                // Samlet på 2. stolpe: (1*300 og 1*480)*2
                remPieces = new int[]{300, 300, 480, 480};
            } else if (carportLength<=7200 && shedDept==0){
                remPieces = new int[]{tmpRem, tmpRem};
            } else if (constructionLength>7200){
                if (carportLength<=7200 && shedDept<=3000){
                    // (1*tættestPåCarportLængde og 1*300)*2
                    remPieces = new int[]{tmpRem, tmpRem, 300, 300};
                } else if (carportLength<=7200 && shedDept<3600){
                    // (1*tættestPåCarportLængde og 1*360)*2
                    remPieces = new int[]{tmpRem, tmpRem, 360, 360};
                } else if (carportLength>7200 && shedDept<=3000){
                    // (1*Punkt1 og 1*300)*2
                    remPieces = new int[]{300, 300, 300, 300, 480, 480};
                } else if (carportLength>7200 && shedDept<3600){
                    // (1*Punkt1 og 1*360)*2
                    remPieces = new int[]{300, 300, 360, 360, 480, 480};
                }
            }
            // Hvis bredden er over 600 cm:
        } else {
            if (carportLength>7200 && shedDept == 0){
                // Length = 750 cm, sidePostAmount = 4, postDistanceMax300 = 246,67 cm
                // Samlet på 2. stolpe: (1*300 og 1*480)*3
                remPieces = new int[]{300, 300, 300, 480, 480, 480};
            } else if (constructionLength>7200){
                if (carportLength<=7200 && shedDept<=3000){
                    // (1*tættestPåCarportLængde og 1*300)*3
                    remPieces = new int[]{tmpRem, tmpRem, tmpRem, 300, 300, 300};
                } else if (carportLength<=7200 && shedDept<3600){
                    // (1*tættestPåCarportLængde og 1*360)*3
                    remPieces = new int[]{tmpRem, tmpRem, tmpRem, 360, 360, 360};
                } else if (carportLength>7200 && shedDept<=3000){
                    // (1*Punkt1 og 1*300)*3
                    remPieces = new int[]{300, 300, 300, 300, 300, 300, 480, 480, 480};
                } else if (carportLength>7200 && shedDept<3600){
                    // (1*Punkt1 og 1*360)*3
                    remPieces = new int[]{300, 300, 300, 360, 360, 360, 480, 480, 480};
                }
            }
        }
        return remPieces;
    }

    // Brædebolte:
    public static int remBoltAmount (Construction construction){
        //todo return number of screw used to montage of rem on the posts. Use the method remPieces
        //todo in ConstrucionMaterialCalculator implement method that will return a material of that screw with size that equals this number
        // 2 brædebolte pr. stolpe
        int carportLength = construction.getCarportLength();
        int carportWidth = construction.getCarportWidth();
        int shedDept = construction.getShedDepth();
        int bolts;
        if (shedDept==0){
            if (carportWidth>6000){
                bolts = (sidePostAmount(carportLength)*3)*2;
            } else {
                bolts = (sidePostAmount(carportLength)*2)*2;
            }
        } else {
            if (carportWidth>6000){
                // -1 fordi carport slutter på den stolpe som skur starter på, 4 bolte til samling mellem carport og skur
                bolts = (sidePostAmount(carportLength)*3)*2 + ((sidePostAmount(shedDept)-1)*3)*2+4;
            } else {
                // -1 fordi carport slutter på den stolpe som skur starter på, 4 bolte til samling mellem carport og skur
                bolts = (sidePostAmount(carportLength)*2)*2 + ((sidePostAmount(shedDept)-1)*2)*2 +4;
            }
        }
        return bolts;
    }

    // Firkantskriver:
    public static int remSquaresAmount (Construction construction){
        //todo return number of screw used to montage of rem on the posts. Use the method remPieces
        //todo in ConstrucionMaterialCalculator implement method that will return a material of that screw with size that equals this number
        // 1 firkantskirver pr. stolpe
        int carportLength = construction.getCarportLength();
        int carportWidth = construction.getCarportWidth();
        int shedDept = construction.getShedDepth();
        int squares;
        if (shedDept==0){
            if (carportWidth>6000){
                squares = sidePostAmount(carportLength)*3;
            } else {
                squares = sidePostAmount(carportLength)*2;
            }
        } else {
            if (carportWidth>6000){
                squares = sidePostAmount(carportLength)*3 + (sidePostAmount(shedDept)-1)*3;
            } else {
                squares = sidePostAmount(carportLength)*2 + (sidePostAmount(shedDept)-1)*2;
            }
        }
        return squares;
    }

    public static int roofSpaerLength (Construction construction) {
        //todo return lengths of spaer
        // Mulige spærlængder: 300, 360, 420, 480, 540, 600, 660, 720
        int cuntructionWidth = construction.getConstructionWidth()*10;
        int spaerLength;
        if (cuntructionWidth<=3000){
            spaerLength = 300;
        } else if (cuntructionWidth<=3600){
            spaerLength = 360;
        } else if (cuntructionWidth<=4200){
            spaerLength = 420;
        } else if (cuntructionWidth<=4800){
            spaerLength = 480;
        } else if (cuntructionWidth<=5400){
            spaerLength = 540;
        } else if (cuntructionWidth<=6000){
            spaerLength = 600;
        } else if (cuntructionWidth<=6600){
            spaerLength = 660;
        } else {
            spaerLength = 720;
        }
        return spaerLength;
    }

    public static int roofSpaerAmount (Construction construction){
        //todo return number of spaer needed for whole construction length
        //todo in ConstrucionMaterialCalculator implement method that will return  2 Materials of beslag
        // - one for left and one for right with amount of number of spaer and one Material that is the beslag skruer where the amount is roofSpaernumber x2x3x3

        // Der skal være max 550 mm mellem spærne
        int constructionLength = construction.getConstructionLength();
        double almostSpaerAmount = constructionLength/550.0 +1;
        int spaerAmount = (int) Math.round(almostSpaerAmount);
        return spaerAmount;
    }

    // Universalbeslag Højre
    public static int universalBracketsRight(Construction construction){
        int universalBracketsRight = roofSpaerAmount(construction);
        return universalBracketsRight;
    }
    // Universalbeslag Venstre
    public static int universalBracketsLeft(Construction construction){
        int universalBracketsLeft = roofSpaerAmount(construction);
        return universalBracketsLeft;
    }

    public static int perforatedBandRolls (Construction construction) {
        //todo implement a method in ConstructionMaterialCalculator that returns hulbånd material , make sure that it is not possible that the crossing piece is longer than 10 m
        //todo return amount of hulbånd needed

        // Hulbånd er 10 meter (10.000 mm) langt pr. rulle
        int carportLength = (construction.getCarportLength());
        int carportWidth = (construction.getCarportWidth());
        double useBandLength = (Math.sqrt((Math.pow(carportLength,2)) + (Math.pow(carportWidth,2))))*2;

        int numberOfRolls;
        if (useBandLength>10){
            numberOfRolls = 2;
        } else {
            numberOfRolls = 1;
        }
        return numberOfRolls;
    }

    // Beslagskruer til hulbånd og spær
    public static int bracketScrews (Construction construction) {
        //todo return amount of screw needed for montage of that band and spaer

        // Beslagskruer til spær:
        int bracketScrewsS = roofSpaerAmount(construction)*9;
        // Beslagskruer til hulbånd:
        int bracketScrewsH = (roofSpaerAmount(construction)-2)*2;
        // Totale antal skruer:
        int total = bracketScrewsS + bracketScrewsH;
        // Skal bruge antallet af pakker og der er 250 stk i 1 pakke:
        int brancketScrewPk = 0;
        if (total<=250){
            brancketScrewPk = 1;
        } else {
            brancketScrewPk = 2;
            System.out.println("Dette er ikke muligt (ConstructionSizeCalculator.bracketScrews)");
        }
        return brancketScrewPk;
    }

    public static int possibleSternSmall(int size, int extra){
        int[] possibleStern = new int[]{3000, 3600, 4200, 4800, 5400, 6000};
        int wantedStern = 0;
        int difference = 0;
        size = size + extra;
        // Iterating:
        for (int i = 0; i < possibleStern.length; i++){
            // For hver værdi i arrayet, hvis værdien (i) er under vores længde skal den næste bruges
            // Tag hver forskel, og find den nærmeste positive værdi
            difference = possibleStern[i]-size;
            if (difference>=0){
                wantedStern = (size+difference)/10;
                break;
            }
        }
        return wantedStern;
    }

    public static int possibleSternDobbelt(int size, int ekstra){
        int[] possibleStern = new int[]{3000, 3600, 4200, 4800, 5400, 6000};
        int wantedStern = 0;
        int difference = 0;
        size = size + ekstra;
        // Iterating:
        for (int i = 0; i < possibleStern.length; i++){
            // For hver værdi i arrayet, hvis værdien (i) er under vores længde skal den næste bruges
            // Tag hver forskel, og find den nærmeste positive værdi
            difference = Math.abs(possibleStern[i]-(size/2));
            if ((size/2)<=possibleStern[i]){
                wantedStern = ((size/2)+difference)/10;
                break;
            }
        }
        return wantedStern;
    }

    public static int[] underSternPieces(Construction construction) {
        //todo caount pieces needet to build a under stern take to consideration that they might need to be connected on the certain length (på middten)
        //todo in ConstrucionMaterialCalculator implement method that will return Materials of that tree for each piece

        // Mulige længder: 300, 360, 420, 480, 540, 600
        // Hvis længden er længere end 540 cm skal der anvendes to af den samme længde som er korteste muligt.
        int[] understernPieces;
        int cunstructionLength = construction.getConstructionLength();
        int cunstructionWidth = construction.getConstructionWidth();
        int frontStern;
        int sideStern;
        int backStern;
        // frontstern skal have 50 mm ekstra, sidestern skal have 25 mm ekstra
        if (cunstructionLength<=5400 && cunstructionWidth<=5400){
            frontStern = possibleSternSmall(cunstructionWidth, 50);
            backStern = possibleSternSmall(cunstructionWidth, 0);
            sideStern = possibleSternSmall(cunstructionLength, 25);
            understernPieces = new int[]{frontStern, backStern, sideStern, sideStern};
        } else if (cunstructionLength<=5400){
            frontStern = possibleSternDobbelt(cunstructionWidth, 50);
            backStern = possibleSternDobbelt(cunstructionWidth, 0);
            sideStern = possibleSternSmall(cunstructionLength, 25);
            understernPieces = new int[]{frontStern, frontStern, backStern, backStern, sideStern, sideStern};
        } else if (cunstructionWidth<=5400){
            frontStern = possibleSternSmall(cunstructionWidth, 50);
            backStern = possibleSternSmall(cunstructionWidth, 0);
            sideStern = possibleSternDobbelt(cunstructionLength,  25);
            understernPieces = new int[]{frontStern, backStern, sideStern, sideStern, sideStern, sideStern};
        } else {
            frontStern = possibleSternDobbelt(cunstructionWidth, 50);
            backStern = possibleSternDobbelt(cunstructionWidth, 0);
            sideStern = possibleSternDobbelt(cunstructionLength, 25);
            understernPieces = new int[]{frontStern, frontStern, backStern, backStern,
                    sideStern, sideStern, sideStern, sideStern};
        }
        return understernPieces;
    }


    public static int[] overSternPieces(Construction construction) {
        //todo caount pieces needet to build a under stern take to consideration that they might need to be connected on the certain length
        //todo in ConstrucionMaterialCalculator implement method that will return Materials of that tree for each piece

        // Hvis længden er længere end 540 cm skal der anvendes to af den samme længde som er korteste muligt.
        int[] oversternPieces;
        int cunstructionLength = construction.getConstructionLength();
        int cunstructionWidth = construction.getConstructionWidth();
        int frontStern;
        int sideStern;
        int backStern;
        // frontstern skal have 100 mm ekstra, sidestern skal have 50 mm ekstra, bagstern skal have 50 mm ekstra
        if (cunstructionLength<=5400 && cunstructionWidth<=5400){
            frontStern = possibleSternSmall(cunstructionWidth, 100);
            backStern = possibleSternSmall(cunstructionWidth, 50);
            sideStern = possibleSternSmall(cunstructionLength, 50);
            oversternPieces = new int[]{frontStern, backStern, sideStern, sideStern};
        } else if (cunstructionLength<=5400){
            frontStern = possibleSternDobbelt(cunstructionWidth, 100);
            backStern = possibleSternDobbelt(cunstructionWidth, 50);
            sideStern = possibleSternSmall(cunstructionLength, 50);
            oversternPieces = new int[]{frontStern, frontStern, backStern, backStern, sideStern, sideStern};
        } else if (cunstructionWidth<=5400){
            frontStern = possibleSternSmall(cunstructionWidth, 100);
            backStern = possibleSternSmall(cunstructionWidth, 50);
            sideStern = possibleSternDobbelt(cunstructionLength, 50);
            oversternPieces = new int[]{frontStern, backStern, sideStern, sideStern, sideStern, sideStern};
        } else {
            frontStern = possibleSternDobbelt(cunstructionWidth, 100);
            backStern = possibleSternDobbelt(cunstructionWidth, 50);
            sideStern = possibleSternDobbelt(cunstructionLength, 50);
            oversternPieces = new int[]{frontStern, frontStern, backStern, backStern,
                    sideStern, sideStern, sideStern, sideStern};
        }
        return oversternPieces;
    }

    // Skruer til stern og vandbræt - 1 pakke er nok til stor carport
    //todo count number of screws needet for montage of both Sterns
    //todo in ConstrucionMaterialCalculator implement method that will return Material of that screw with its size that equals this number
    public static int screwAmount = 1;

}