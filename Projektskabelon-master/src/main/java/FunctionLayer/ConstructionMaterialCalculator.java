package FunctionLayer;

// Materiale type

import java.util.*;

import static FunctionLayer.ConstructionSizeCalculator.*;
import static FunctionLayer.LogicFacade.getLengthForMaterials;


public class ConstructionMaterialCalculator {

    public ConstructionSizeCalculator constructionSizeCalculator = new ConstructionSizeCalculator();
    public Construction construction = new Construction();
    public ArrayList<Material> constructionMaterials = construction.getFundamentMaterials();

    //.......................All the materials for construction.............................//
    public ArrayList<Material> constructionMaterialList(Construction construction) throws LoginSampleException {
        ArrayList<Material> woodMaterials = woodMaterials(construction);
        ArrayList<Material> metalMaterials = metalMaterials(construction);

        ArrayList<Material> constructionMaterials = new ArrayList<>();
        construction.setFundamentMaterials(constructionMaterials);
        constructionMaterials.addAll(woodMaterials);
        constructionMaterials.addAll(metalMaterials);
        return constructionMaterials;
    }

    //................................wood materials............................//
    public ArrayList<Material> woodMaterials(Construction construction) throws LoginSampleException {
        ArrayList<Material> woodMaterials = new ArrayList<>();

        // Stolper
        //TODO: sæt stolper i den rigtige størrelse ind i woodMaterials listen
        //Beregning er uden stolper til skur
        double constructionMinHeight = construction.getConstructionHeight() - construction.getRoof().getHeight();
        ArrayList<Integer> actualHeightsOfPostsForConstruction = new ArrayList();

        int carportMinHeight = carportMinHeight((int) constructionMinHeight, construction.getShed().getDepth(),
                construction.getRoof().getTilt());
        int quantityOfCarportPostsRows = postRows(construction.getCarportWidth());
        Integer[] heightsOfPostsPerRow = postsHeights(carportMinHeight, construction.getRoof().getDegree(),
                construction.getConstructionWidth());
        for (int i = 0; i < quantityOfCarportPostsRows - 1; i++) {
            for (int postHeight : heightsOfPostsPerRow) {
                actualHeightsOfPostsForConstruction.add(postHeight);
            }
        }

        ArrayList<Integer> postsMaterialsAvalibleLenghts = getLengthForMaterials("TRYKIMPRENERET STOLPE");

        ArrayList<Material> tempPostsMaterails = new ArrayList<>();
        int restOfAvalibleMaterial = 0;
        int countPosts = 1;
        Material post = null;

        for (int avaliblePostMaterialLength : postsMaterialsAvalibleLenghts) {
            post = LogicFacade.getMaterialBySizeName(avaliblePostMaterialLength, "");
            post.setName("TRYKIMPRENERET STOLPE");
            post.setUnit(LogicFacade.getUnitByName(post.getName()));
            post.setWidth(LogicFacade.getWidthByID(post.getId(), post.getName()));
            post.setThickness(LogicFacade.getThicknessByID(post.getId()));
            post.setName("TRYKIMPRENERET STOLPE" + post.getThickness() + "x" + post.getWidth());
            for (int postHeightForConstruction : actualHeightsOfPostsForConstruction) {
                if (postHeightForConstruction <= avaliblePostMaterialLength) {
                    countPosts++;
                    restOfAvalibleMaterial = avaliblePostMaterialLength % postHeightForConstruction;
                }

                if (restOfAvalibleMaterial != 0)
                    for (int i = postsMaterialsAvalibleLenghts.indexOf(post)-1; i >= 0; i--) {
                        double temp = (double)restOfAvalibleMaterial / postsMaterialsAvalibleLenghts.get(i);
                        Material tempPost = tempPostsMaterails.get(i);
                        int tempQuatityPostsTypePlusOneEkstra = tempPost.getAmount() + 1;
                        tempPost.setAmount(tempQuatityPostsTypePlusOneEkstra);
                    }

                    post.setAmount(countPosts);
                post.setComment("(skriv noget herinde om materialet)");
                tempPostsMaterails.add(post);
            }
        }
        woodMaterials.addAll(tempPostsMaterails);

        // Rem
        int[] remPieces = constructionSizeCalculator.remPieces(construction);
        int counter = 0;
        Material rem = null;
        for (int remPiece : remPieces) {
            rem = LogicFacade.getMaterialBySizeName(remPiece, "");
            rem.setName("SPÆRTRÆ UBEHANDLET");
            rem.setUnit(LogicFacade.getUnitByName(rem.getName()));
            rem.setWidth(LogicFacade.getWidthByID(rem.getId(), rem.getName()));
            rem.setThickness(LogicFacade.getThicknessByID(rem.getId()));
            rem.setName("SPÆRTRÆ UBEHANDLET " + rem.getThickness() + "x" + rem.getWidth());
            rem.setSize(remPiece);
            if (remPiece == rem.getSize()) {
                counter++;
            }
            rem.setAmount(counter);
            rem.setComment("Remme skal monteres på stolper");

            woodMaterials.add(rem);
        }

        // Spær
        int amount = constructionSizeCalculator.roofSpaerAmount(construction);
        int size = constructionSizeCalculator.roofSpaerLength(construction);
        Material spær = null;
        for (int i = 0; i < amount; i++) {
            spær = LogicFacade.getMaterialBySizeName(size, "");
            spær.setName("SPÆRTRÆ UBEHANDLET");
            spær.setUnit(LogicFacade.getUnitByName(spær.getName()));
            spær.setWidth(LogicFacade.getWidthByID(spær.getId(), spær.getName()));
            spær.setThickness(LogicFacade.getThicknessByID(spær.getId()));
            spær.setName("SPÆRTRÆ UBEHANDLET " + spær.getThickness() + "x" + spær.getWidth());
            spær.setSize(size);
            spær.setAmount(amount);

            spær.setComment("Spær skal moteres på remme");
            woodMaterials.add(spær);
        }
        // Understern
        int[] understernPieces = constructionSizeCalculator.underSternPieces(construction);
        int counter2 = 0;
        Material underStern = null;
        for (int underSternObject : understernPieces) {
            underStern = LogicFacade.getMaterialBySizeName(underSternObject, "");
            underStern.setName("TRYKIMPRENERET BRÆDT");
            underStern.setUnit(LogicFacade.getUnitByName(underStern.getName()));
            underStern.setId(2);
            underStern.setWidth(LogicFacade.getWidthByID(underStern.getId(), underStern.getName()));
            underStern.setThickness(LogicFacade.getThicknessByID(underStern.getId()));
            underStern.setName("TRYKIMPRENERET BRÆDT " + underStern.getThickness() + "x" + underStern.getWidth());
            underStern.setSize(underSternObject);

            if (underSternObject == underStern.getSize()) {
                counter2++;
            }
            underStern.setAmount(counter2);
            underStern.setComment("Understern skal monteres på spær");
            woodMaterials.add(underStern);
        }
        // Overstern
        int[] oversternPieces = constructionSizeCalculator.overSternPieces(construction);
        for (int overSternObject : oversternPieces) {
            Material overStern = LogicFacade.getMaterialBySizeName(overSternObject, "");
            overStern.setName("TRYKIMPRENERET BRÆDT");
            overStern.setUnit(LogicFacade.getUnitByName(overStern.getName()));
            overStern.setId(3);
            overStern.setWidth(LogicFacade.getWidthByID(overStern.getId(), overStern.getName()));
            overStern.setThickness(LogicFacade.getThicknessByID(overStern.getId()));
            overStern.setName("TRYKIMPRENERET BRÆDT " + overStern.getThickness() + "x" + overStern.getWidth());
            overStern.setSize(overSternObject);
            overStern.setComment("Overstern skal monteres på understern");
            woodMaterials.add(overStern);
        }
        return woodMaterials;
    }

    //................................metal materials............................//
    public ArrayList<Material> metalMaterials(Construction construction) throws LoginSampleException {
        ArrayList<Material> metalMaterials = new ArrayList<>();

        // Bræddebolte
        Material bræddebolt = LogicFacade.getMaterialByID(16);
        bræddebolt.setName("BRÆDDEBOLT");
        bræddebolt.setAmount(constructionSizeCalculator.remBoltAmount(construction));
        bræddebolt.setUnit(LogicFacade.getUnitByName(bræddebolt.getName()));
        bræddebolt.setId(16);
        bræddebolt.setWidth(LogicFacade.getWidthByID(bræddebolt.getId(), bræddebolt.getName()));
        bræddebolt.setThickness(LogicFacade.getThicknessByID(bræddebolt.getId()));
        bræddebolt.setName("BRÆDDEBOLT " + bræddebolt.getThickness() + "x" + bræddebolt.getWidth());
        bræddebolt.setComment("Til montering af rem på stolper");
        metalMaterials.add(bræddebolt);
        // Firkantskriver
        Material firkantskriver = LogicFacade.getMaterialByID(17);
        firkantskriver.setName("FIRKANTSKIVER");
        firkantskriver.setAmount(constructionSizeCalculator.remSquaresAmount(construction));
        firkantskriver.setUnit(LogicFacade.getUnitByName(firkantskriver.getName()));
        firkantskriver.setId(17);
        firkantskriver.setWidth(LogicFacade.getWidthByID(firkantskriver.getId(), firkantskriver.getName()));
        firkantskriver.setThickness(LogicFacade.getThicknessByID(firkantskriver.getId()));
        firkantskriver.setName("FIRKANTSKIVER " + firkantskriver.getThickness() + "x" + firkantskriver.getWidth());
        firkantskriver.setComment("Til montering af rem på stolper");
        metalMaterials.add(firkantskriver);
        // Hulbånd
        Material hulbånd = LogicFacade.getMaterialByID(12);
        hulbånd.setName("HULBÅND");
        hulbånd.setAmount(constructionSizeCalculator.perforatedBandRolls(construction));
        hulbånd.setUnit(LogicFacade.getUnitByName(hulbånd.getName()));
        hulbånd.setId(12);
        hulbånd.setWidth(LogicFacade.getWidthByID(hulbånd.getId(), hulbånd.getName()));
        hulbånd.setThickness(LogicFacade.getThicknessByID(hulbånd.getId()));
        hulbånd.setName("HULBÅND 10 M " + hulbånd.getThickness() + "x" + hulbånd.getWidth());
        hulbånd.setComment("Til vindkryds på spær");
        metalMaterials.add(hulbånd);
        // Beslagskruer til hulbånd og spær
        Material beslagskruer = LogicFacade.getMaterialByID(15);
        beslagskruer.setName("BESLAGSKRUER");
        beslagskruer.setAmount(constructionSizeCalculator.bracketScrews(construction));
        beslagskruer.setUnit(LogicFacade.getUnitByName(beslagskruer.getName()));
        beslagskruer.setId(15);
        beslagskruer.setWidth(LogicFacade.getWidthByID(beslagskruer.getId(), beslagskruer.getName()));
        beslagskruer.setThickness(LogicFacade.getThicknessByID(beslagskruer.getId()));
        beslagskruer.setName("BESLAGSKRUER " + beslagskruer.getThickness() + "x" + beslagskruer.getWidth());
        beslagskruer.setComment("Til montering af universalbeslag + hulbånd");
        metalMaterials.add(beslagskruer);
        // Universalbeslag Højre
        Material universalbeslagHøjre = LogicFacade.getMaterialByID(13);
        universalbeslagHøjre.setName("UNIVERSALBESLAG");
        universalbeslagHøjre.setAmount(constructionSizeCalculator.universalBracketsRight(construction));
        universalbeslagHøjre.setUnit(LogicFacade.getUnitByName(universalbeslagHøjre.getName()));
        universalbeslagHøjre.setId(13);
        universalbeslagHøjre.setWidth(LogicFacade.getWidthByID(universalbeslagHøjre.getId(), universalbeslagHøjre.getName()));
        universalbeslagHøjre.setName("UNIVERSALBESLAG " + universalbeslagHøjre.getWidth() + " MM. Højre");
        universalbeslagHøjre.setComment("Til montering af spær på rem");
        metalMaterials.add(universalbeslagHøjre);
        // Universalbeslag Venstre
        Material universalbeslagVenstre = LogicFacade.getMaterialByID(13);
        universalbeslagVenstre.setName("UNIVERSALBESLAG");
        universalbeslagVenstre.setAmount(constructionSizeCalculator.universalBracketsLeft(construction));
        universalbeslagVenstre.setUnit(LogicFacade.getUnitByName(universalbeslagVenstre.getName()));
        universalbeslagVenstre.setId(13);
        universalbeslagVenstre.setWidth(LogicFacade.getWidthByID(universalbeslagVenstre.getId(), universalbeslagVenstre.getName()));
        universalbeslagVenstre.setName("UNIVERSALBESLAG " + universalbeslagVenstre.getWidth() + " MM. Venstre");
        universalbeslagVenstre.setComment("Til montering af spær på rem");
        metalMaterials.add(universalbeslagVenstre);
        // Skruer til stern og vandbræt
        Material skruer = LogicFacade.getMaterialByID(14);
        skruer.setName("SKRUER");
        skruer.setAmount(constructionSizeCalculator.screwAmount);
        skruer.setUnit(LogicFacade.getUnitByName(skruer.getName()));
        skruer.setId(14);
        skruer.setWidth(LogicFacade.getWidthByID(skruer.getId(), skruer.getName()));
        skruer.setThickness(LogicFacade.getThicknessByID(skruer.getId()));
        skruer.setName("SKRUER " + skruer.getThickness() + "x" + skruer.getWidth());
        skruer.setComment("Til montering af stern&vandbrædt");
        metalMaterials.add(skruer);

        return metalMaterials;
    }


}
