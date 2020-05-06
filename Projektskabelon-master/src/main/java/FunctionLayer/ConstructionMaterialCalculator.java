package FunctionLayer;

// Materiale type

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConstructionMaterialCalculator {

// TODO Opsæt ligesom overlayCalculator

    public ConstructionSizeCalculator constructionSizeCalculator = new ConstructionSizeCalculator();
    public Construction construction = new Construction();
    public ArrayList<Material> constructionMaterials = construction.getFundamentMaterials();

    //.......................All the materials for construction.............................//
    public ArrayList<Material> constructionMaterialList(Construction construction) throws LoginSampleException {
        ArrayList<Material> woodMaterials = woodMaterials(construction);
        //ArrayList<Material> metalMaterials = metalMaterials(construction);

        ArrayList<Material> constructionMaterials = new ArrayList<>();
        construction.setFundamentMaterials(constructionMaterials);
        constructionMaterials.addAll(woodMaterials);
        //constructionMaterials.addAll(metalMaterials);
        return constructionMaterials;
    }


    //................................wood materials............................//
    public ArrayList<Material> woodMaterials(Construction construction) throws LoginSampleException {
        ArrayList<Material> woodMaterials = new ArrayList<>();

        // Stolper
        //TODO: sæt stolper i den rigtige størrelse ind i woodMaterials listen

        // TODO alle materialer skal have sat: name, size, amount, unit, comment
        // Rem
        int[] remPieces = constructionSizeCalculator.remPieces(construction, construction.getCarportLength(), construction.getConstructionWidth(), construction.getShedDepth());
        int counter = 0;
        for (int remPiece : remPieces) {
            Material rem = LogicFacade.getMaterialBySize(remPiece);
            rem.setName("45x195 MM. SPÆRTRÆ UBH.");
            rem.setSize(remPiece);
            if (remPiece == rem.getSize()){
                counter++;
            }
            rem.setAmount(counter);
            rem.setUnit(LogicFacade.getUnitByName(rem.getName()));
            rem.setComment("Remme skal monteres på stolper");

            woodMaterials.add(rem);

            System.out.println("Vores rem: " + rem.getName() + ", " + rem.getSize() + ", " + rem.getAmount() + ", " + rem.getUnit() + ", " + rem.getComment());
        }
        // Spær
        int amount = constructionSizeCalculator.roofSpaerAmount(construction);
        int size = constructionSizeCalculator.roofSpaerLength(construction);
        for (int i = 0; i < amount; i++) {
            Material spær = LogicFacade.getMaterialBySize(size);
            spær.setName("45x195 MM. SPÆRTRÆ UBH.");
            spær.setComment("Spær");
            spær.setSize(size);
            spær.setAmount(amount);
            // TODO find material in database
            woodMaterials.add(spær);
        }
        // Understern
        int[] understernPieces = constructionSizeCalculator.underSternPieces(construction);
        for (int underSternObject : understernPieces) {
            Material underStern = LogicFacade.getMaterialBySize(underSternObject);
            underStern.setName("25x200 MM. TRYKIMP. BRÆDT");
            underStern.setComment("Understern");
            underStern.setSize(underSternObject);
            // TODO find material in database
            woodMaterials.add(underStern);
        }
        // Overstern
        int[] oversternPieces = constructionSizeCalculator.overSternPieces(construction);
        for (int overSternObject : oversternPieces) {
            Material overStern = LogicFacade.getMaterialBySize(overSternObject);
            overStern.setName("25x200 MM. TRYKIMP. BRÆDT");
            overStern.setComment("Understern");
            overStern.setSize(overSternObject);
            // TODO find material in database
            woodMaterials.add(overStern);
        }
        return woodMaterials;
    }

    //................................metal materials............................//
    public ArrayList<Material> metalMaterials(Construction construction) throws LoginSampleException {
        ArrayList<Material> metalMaterials = new ArrayList<>();

        // Bræddebolte
        Material bræddebolt = LogicFacade.getMaterialByName("BRÆDDEBOLT 10x120 MM.");

        return metalMaterials;
    }


        // Firkantskriver


        // Hulbånd


        // Beslagskruer til hulbånd og spær


        // Universalbeslag Højre


        // Universalbeslag Venstre


        // Skruer til stern og vandbræt


}
