package FunctionLayer;

// Materiale type

import java.util.*;

//TODO lav counter udenfor for loop med givne materiale, basically counter på arraylist
//TODO lav width og tickness

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


        // Rem
        int[] remPieces = constructionSizeCalculator.remPieces(construction, construction.getCarportLength(), construction.getConstructionWidth(), construction.getShedDepth());
        int counter = 0;
        Material rem = null;
        for (int remPiece : remPieces) {
            rem = LogicFacade.getMaterialBySize(remPiece);
            rem.setName("SPÆRTRÆ UBEHANDLET");
            rem.setUnit(LogicFacade.getUnitByName(rem.getName()));
            rem.setWidth(LogicFacade.getWidthByID(rem.getId(), rem.getName()));
            rem.setThickness(LogicFacade.getThicknessByID(rem.getId()));
                rem.setName("SPÆRTRÆ UBEHANDLET " + rem.getThickness() + "x" + rem.getWidth());
            rem.setSize(remPiece);
            if (remPiece == rem.getSize()){
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
            spær = LogicFacade.getMaterialBySize(size);
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
            underStern = LogicFacade.getMaterialBySize(underSternObject);
            underStern.setName("TRYKIMPRENERET BRÆDT");
            underStern.setUnit(LogicFacade.getUnitByName(underStern.getName()));
                underStern.setWidth(LogicFacade.getWidthByID(underStern.getId(), underStern.getName()));
                underStern.setThickness(LogicFacade.getThicknessByID(underStern.getId()));
                underStern.setName("TRYKIMPRENERET BRÆDT " + underStern.getThickness() + "x" + underStern.getWidth());
            underStern.setSize(underSternObject);

            if (underSternObject == underStern.getSize()){
                counter2++;
            }
            underStern.setAmount(counter2);
            underStern.setComment("Understern skal monteres på spær");
            woodMaterials.add(underStern);
        }
        // Overstern
        int[] oversternPieces = constructionSizeCalculator.overSternPieces(construction);
        for (int overSternObject : oversternPieces) {
            Material overStern = LogicFacade.getMaterialBySize(overSternObject);
            overStern.setName("TRYKIMPRENERET BRÆDT");
            overStern.setUnit(LogicFacade.getUnitByName(overStern.getName()));
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
            bræddebolt.setComment("Til montering af rem på stolper");
        metalMaterials.add(bræddebolt);
        // Firkantskriver
        Material firkantskriver = LogicFacade.getMaterialByID(17);
            firkantskriver.setName("FIRKANTSKIVER");
            firkantskriver.setAmount(constructionSizeCalculator.remSquaresAmount(construction));
            firkantskriver.setUnit(LogicFacade.getUnitByName(firkantskriver.getName()));
            firkantskriver.setComment("Til montering af rem på stolper");
        metalMaterials.add(firkantskriver);
        // Hulbånd
        Material hulbånd = LogicFacade.getMaterialByID(12);
            hulbånd.setName("HULBÅND");
            hulbånd.setAmount(constructionSizeCalculator.perforatedBandRolls(construction));
            hulbånd.setUnit(LogicFacade.getUnitByName(hulbånd.getName()));
            hulbånd.setComment("Til vindkryds på spær");
        metalMaterials.add(hulbånd);
        // Beslagskruer til hulbånd og spær
        Material beslagskruer = LogicFacade.getMaterialByID(15);
            beslagskruer.setName("BESLAGSKRUER");
            beslagskruer.setAmount(constructionSizeCalculator.bracketScrews(construction));
            beslagskruer.setUnit(LogicFacade.getUnitByName(beslagskruer.getName()));
            beslagskruer.setComment("Til montering af universalbeslag + hulbånd");
        metalMaterials.add(beslagskruer);
        // Universalbeslag Højre
        Material universalbeslagHøjre = LogicFacade.getMaterialByID(13);
            universalbeslagHøjre.setName("UNIVERSALBESLAG");
            universalbeslagHøjre.setAmount(constructionSizeCalculator.universalBracketsRight(construction));
            universalbeslagHøjre.setUnit(LogicFacade.getUnitByName(universalbeslagHøjre.getName()));
            universalbeslagHøjre.setName("UNIVERSALBESLAG Højre");
            universalbeslagHøjre.setComment("Til montering af spær på rem");
        metalMaterials.add(universalbeslagHøjre);
        // Universalbeslag Venstre
        Material universalbeslagVenstre = LogicFacade.getMaterialByID(13);
            universalbeslagVenstre.setName("UNIVERSALBESLAG");
            universalbeslagVenstre.setAmount(constructionSizeCalculator.universalBracketsLeft(construction));
            universalbeslagVenstre.setUnit(LogicFacade.getUnitByName(universalbeslagVenstre.getName()));
            universalbeslagVenstre.setName("UNIVERSALBESLAG Venstre");
            universalbeslagVenstre.setComment("Til montering af spær på rem");
        metalMaterials.add(universalbeslagVenstre);
        // Skruer til stern og vandbræt
        Material skruer = LogicFacade.getMaterialByID(14);
            skruer.setName("SKRUER");
            skruer.setAmount(constructionSizeCalculator.screwAmount);
            skruer.setUnit(LogicFacade.getUnitByName(skruer.getName()));
            skruer.setComment("Til montering af stern&vandbrædt");
        metalMaterials.add(skruer);

        return metalMaterials;
    }






}
