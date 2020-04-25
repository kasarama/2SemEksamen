package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class FindMaterial extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        // Her skal der findes de materialer og indsættes i DB i itemlist

        int length = Integer.parseInt(request.getParameter( "length" ));
        int width = Integer.parseInt(request.getParameter( "width" ));
        int tag = Integer.parseInt(request.getParameter("roofType"));
        int skur = Integer.parseInt(request.getParameter("isShed"));

//CarportBuilder carportBuilder = new CarportBuilder();
        RoofMaterialCalculator rCalculator = new RoofMaterialCalculator();
        WoodMaterialCalculator wCalculator = new WoodMaterialCalculator();
        OtherMaterialCalculator oCalculator = new OtherMaterialCalculator();
        Carport carport = new Carport();

// TRÆ
        // Understernbrædder
        int under360Antal = wCalculator.understernboartU360(length, width);
        int under540Antal = wCalculator.understernboartU540(length, width);
            Material under360 = LogicFacade.getMaterial("Understernbrædder360");
                under360.setAntal(under360Antal);
                under360.setComment("Understernbrædder 360 cm");
            Material under540 = LogicFacade.getMaterial("Understernbrædder540");
                under540.setAntal(under540Antal);
                under540.setComment("Understernbrædder 540 cm");

        // Oversternbrædder
        int over360Antal = wCalculator.oversternboartU360(length, width);
        int over540Antal = wCalculator.oversternboartU540(length, width);
            Material over360 = LogicFacade.getMaterial("Oversternbrædder360");
                over360.setAntal(over360Antal);
                over360.setComment("Oversternbrædder 360 cm");
            Material over540 = LogicFacade.getMaterial("Oversternbrædder540");
                over540.setAntal(over540Antal);
                over540.setComment("Oversternbrædder 540 cm");

        // Rem
        int rem600Antal = wCalculator.rem600(length, width);
        int rem480Antal = wCalculator.rem480(length, width);
            Material rem600 = LogicFacade.getMaterial("Rem600");
                rem600.setAntal(rem600Antal);
                rem600.setComment("Rem 600 cm");
            Material rem480 = LogicFacade.getMaterial("Rem480");
                rem480.setAntal(rem480Antal);
                rem480.setComment("Rem 480 cm");

        // Spær
        int spærAntal = wCalculator.raft(length);
            Material spær = LogicFacade.getMaterial("Spær");
                spær.setAntal(spærAntal);
                spær.setComment("Spær");

        // Stolper
        int stolpeAntal = wCalculator.posts(length, width);
            Material stolpe = LogicFacade.getMaterial("Stolpe");
                stolpe.setAntal(stolpeAntal);
                stolpe.setComment("Stolpe");

        // Vandbræt


// SKUR

        // Lægte:
        int lægteAntal = wCalculator.shedLath;
            Material lægte = LogicFacade.getMaterial("Lægte");
                lægte.setAntal(lægteAntal);
                lægte.setComment("Lægte til z på skur");

        // Løsholter


        // TODO - Mia - kig på shed-depth
        /*// Skur beklædning:
        int beklædningAntal = wCalculator.shedTimbering(carport.getShedDepth());
            Material beklædning = LogicFacade.getMaterial("SkurBeklædning");
                beklædning.setAntal(beklædningAntal);
                beklædning.setComment("Beklædning til skur");*/


// TAG



// SKRUER OG BESLAG
     // Bræddebolte
        int bræddebolteAntal = oCalculator.carriageBolts(length, width);
            Material bræddebolte = LogicFacade.getMaterial("Bræddebolt");
            bræddebolte.setAntal(bræddebolteAntal);
            bræddebolte.setComment("Bræddebolt");

     // Firkantskiver
        int firkantskiverAntal = oCalculator.squares(length, width);
            Material firkantskiver = LogicFacade.getMaterial("Firkantskiver");
            firkantskiver.setAntal(firkantskiverAntal);
            firkantskiver.setComment("Firkantskiver");
     // Universalbeslag
        int universalbeslagAntalLeft = oCalculator.universalBracketsLeft(length);
        int universalbeslagAntalRight = oCalculator.universalBracketsRight(length);
            Material universalbeslagLeft = LogicFacade.getMaterial("UniversalbeslagVenstre");
                universalbeslagLeft.setAntal(universalbeslagAntalLeft);
                universalbeslagLeft.setComment("UniversalbeslagVenstre");
            Material universalbeslagRight = LogicFacade.getMaterial("UniversalbeslagHøjre");
                universalbeslagRight.setAntal(universalbeslagAntalRight);
                universalbeslagRight.setComment("UniversalbeslagHøjre");
     // Beslagskruer
        int beslagskruerAntal = oCalculator.bracketScrews(length);
            Material beslagskruer = LogicFacade.getMaterial("Beslagskruer");
            beslagskruer.setAntal(beslagskruerAntal);
            beslagskruer.setComment("Beslagskruer");
     // Hulbånd
        int hulbåndAntal = oCalculator.perforatedBand(length, width);
            Material hulbånd = LogicFacade.getMaterial("Hulbånd");
            hulbånd.setAntal(hulbåndAntal);
            hulbånd.setComment("Hulbånd");

        //Bundskruer (til tag)
        int antalBundskruer = oCalculator.bottomScrews(length, width);
            Material bundskruer = LogicFacade.getMaterial("Bundskruer");
            bundskruer.setAntal(antalBundskruer);
            bundskruer.setComment("Bundskruer til taget");

        //Skruer til vandbræt
        int antalVSkruer = oCalculator.waterboardScrews;
            Material vSkruer = LogicFacade.getMaterial("SkruerStern&Vandbræt");
                vSkruer.setAntal(antalVSkruer);
                vSkruer.setComment("Skruer til stern og vandbræt");

        //Skruer til ydre beklædning
        int antalYSkruer = oCalculator.outherTimbering(length, width);
            Material ySkruer = LogicFacade.getMaterial("SkruerYdreBeklædning");
                ySkruer.setAntal(antalYSkruer);
                ySkruer.setComment("Skruer til ydre beklædning");
        //Skruer til indre beklædning
        int antalISkruer = oCalculator.innerTimbering(length, width);
            Material iSkruer = LogicFacade.getMaterial("SkruerInnerBeklædning");
                iSkruer.setAntal(antalISkruer);
                iSkruer.setComment("Skruer til indre beklædning");

        // Lås
        Material lås = LogicFacade.getMaterial("Lås");
            lås.setAntal(oCalculator.shedLock);
            lås.setComment("Lås til skur");

        // Hængsel
        Material hængsel = LogicFacade.getMaterial("Hængsel");
            hængsel.setAntal(oCalculator.shedHinge);
            hængsel.setComment("Hængsler til skurdør");

        // Tætningsprofil
        int antalTætningsprofil = oCalculator.gasket(width);
            Material tætningsprofil = LogicFacade.getMaterial("SkruerInnerBeklædning");
                iSkruer.setAntal(antalISkruer);
                iSkruer.setComment("Skruer til indre beklædning");

        String jspSide;
        // Flat tag, intet skur:
        if (tag == 0 && skur == 0){
            carport.addWoodMaterial(under360);
            carport.addWoodMaterial(under540);
            carport.addWoodMaterial(over360);
            carport.addWoodMaterial(over540);
            carport.addWoodMaterial(rem600);
            carport.addWoodMaterial(rem480);
            carport.addWoodMaterial(spær);
            carport.addWoodMaterial(stolpe);
            // Vandbrædt
            // Beklædning af carport

            //carport.addTagMaterial(trapeztag);
            // Tagplader

            carport.addOtherMaterial(bræddebolte);
            carport.addOtherMaterial(firkantskiver);
            carport.addOtherMaterial(universalbeslagLeft);
            carport.addOtherMaterial(universalbeslagRight);
            carport.addOtherMaterial(beslagskruer);
            carport.addOtherMaterial(hulbånd);
            carport.addOtherMaterial(bundskruer);
            carport.addOtherMaterial(vSkruer);
            carport.addOtherMaterial(ySkruer);
            carport.addOtherMaterial(iSkruer);

            jspSide = "styklisteFlatroof";
        // Flat tag, med skur:
        } else if (tag == 0 && skur == 1){
            carport.addWoodMaterial(under360);
            carport.addWoodMaterial(under540);
            carport.addWoodMaterial(over360);
            carport.addWoodMaterial(over540);
            carport.addWoodMaterial(rem600);
            carport.addWoodMaterial(rem480);
            carport.addWoodMaterial(spær);
            carport.addWoodMaterial(stolpe);
            carport.addWoodMaterial(lægte);
            // TODO Mia - carport.addWoodMaterial(beklædning);
            // Løsholter
            // Vandbrædt
            // Tagplader
            // Beklædning af carport
            // Skur bund

            carport.addOtherMaterial(bræddebolte);
            carport.addOtherMaterial(firkantskiver);
            carport.addOtherMaterial(universalbeslagLeft);
            carport.addOtherMaterial(universalbeslagRight);
            carport.addOtherMaterial(beslagskruer);
            carport.addOtherMaterial(hulbånd);
            carport.addOtherMaterial(bundskruer);
            carport.addOtherMaterial(vSkruer);
            carport.addOtherMaterial(ySkruer);
            carport.addOtherMaterial(iSkruer);
            carport.addOtherMaterial(lås);
            carport.addOtherMaterial(hængsel);
            // vinkelbeslag

            jspSide = "styklisteFlatroofSkur";
        // Pitched tag, intet skur:
        } else if (tag == 1 && skur == 0){
            jspSide = "styklistePitchedroof";
        // Pitched tag, med skur:
        } else {
            jspSide = "styklistePitchedroofSkur";
        }

        HttpSession session = request.getSession();

        session.setAttribute("woodmateriallist", carport.getWoodMaterialList());
        session.setAttribute("othermateriallist", carport.getOtherMaterialList());


        return jspSide;
    }
}
