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

        int length = Integer.parseInt(request.getParameter( "carportLength" ));
        int width = Integer.parseInt(request.getParameter( "carportWidth" ));
        int tag = Integer.parseInt(request.getParameter("roofType"));
        int skur = Integer.parseInt(request.getParameter("isShed"));
        int shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));

        ConstructionCalculator cc = new ConstructionCalculator();
        RoofMaterialCalculator rc = new RoofMaterialCalculator();
        ShedCalculator sc = new ShedCalculator();
        OverlayCalculator oc = new OverlayCalculator();
        Carport carport = new Carport();

    // CONSTRUCTION:
        // Stolper intet skur
        int stolpeAntal;
        Material stolpe;
        if (skur == 0){
            stolpeAntal = cc.posts(length, width);
                stolpe = LogicFacade.getMaterial("Stolpe");
                    stolpe.setAntal(stolpeAntal);
                    stolpe.setComment("Stolpe");
        } else {
            // Stolper med skur stolper
            stolpeAntal = sc.shedPosts(length, width, shedWidth);
                stolpe = LogicFacade.getMaterial("Stolpe");
                    stolpe.setAntal(stolpeAntal);
                    stolpe.setComment("Stolpe");
        }

        // Hulbånd
        int hulbåndAntal = cc.perforatedBand(length, width);
            Material hulbånd = LogicFacade.getMaterial("Hulbånd");
                hulbånd.setAntal(hulbåndAntal);
                hulbånd.setComment("Hulbånd");
        // Beslagskruer
        int beslagskruerHulAntal = cc.bracketScrewsCon(length);
            Material beslagskruerHulbånd = LogicFacade.getMaterial("Beslagskruer");
                beslagskruerHulbånd.setAntal(beslagskruerHulAntal);
                beslagskruerHulbånd.setComment("Beslagskruer (BLIVER GENTAGET)");


/*
    // BEKLÆDNING:
        // Skur beklædning
        int beklædningAntal = oc.shedTimbering(skurDybde);
            Material skurBeklædning = LogicFacade.getMaterial("SkurBeklædning");
                skurBeklædning.setAntal(beklædningAntal);
                skurBeklædning.setComment("Beklædning til skur");
        // Ydre beklædning
        int ydreBeklædningAntal = oc.outherTimbering(length, width);
            Material ydreBeklædning = LogicFacade.getMaterial("SkurBeklædning");
                skurBeklædning.setAntal(beklædningAntal);
                skurBeklædning.setComment("Beklædning til skur");

               // Skur beklædning:
        int beklædningAntal = wCalculator.shedTimbering(carport.getShedDepth());
        Material beklædning = LogicFacade.getMaterial("SkurBeklædning");
        beklædning.setAntal(beklædningAntal);
        beklædning.setComment("Beklædning til skur");

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
*/


    // ROOF:
        // Understernbrædder
        int under360Antal = rc.understernboartU360(length, width);
        int under540Antal = rc.understernboartU540(length, width);
            Material under360 = LogicFacade.getMaterial("Understernbrædder360");
                under360.setAntal(under360Antal);
                under360.setComment("Understernbrædder 360 cm");
            Material under540 = LogicFacade.getMaterial("Understernbrædder540");
                under540.setAntal(under540Antal);
                under540.setComment("Understernbrædder 540 cm");
        // Oversternbrædder
        int over360Antal = rc.oversternboartU360(length, width);
        int over540Antal = rc.oversternboartU540(length, width);
            Material over360 = LogicFacade.getMaterial("Oversternbrædder360");
                over360.setAntal(over360Antal);
                over360.setComment("Oversternbrædder 360 cm");
            Material over540 = LogicFacade.getMaterial("Oversternbrædder540");
                over540.setAntal(over540Antal);
                over540.setComment("Oversternbrædder 540 cm");
        // Rem
        int rem600Antal = rc.rem600(length, width);
        int rem480Antal = rc.rem480(length, width);
            Material rem600 = LogicFacade.getMaterial("Rem600");
                rem600.setAntal(rem600Antal);
                rem600.setComment("Rem 600 cm");
            Material rem480 = LogicFacade.getMaterial("Rem480");
                rem480.setAntal(rem480Antal);
                rem480.setComment("Rem 480 cm");
        // Spær
        int spærAntal = rc.raft(length);
            Material spær = LogicFacade.getMaterial("Spær");
                spær.setAntal(spærAntal);
                spær.setComment("Spær");

        // Vandbræt
        int vandbræt360Antal = rc.vandbræt360(length, width);
        int vandbræt540Antal = rc.vandbræt540(length, width);
            Material vandbræt360 = LogicFacade.getMaterial("Vandbræt360");
                vandbræt360.setAntal(vandbræt360Antal);
                vandbræt360.setComment("Drypnæse 360 cm");
            Material vandbræt540 = LogicFacade.getMaterial("Vandbræt540");
                vandbræt540.setAntal(vandbræt540Antal);
                vandbræt540.setComment("Drypnæse 540 cm");

        // Tætningsprofil
        int antalTætningsprofil = rc.gasket(width);
            Material tætningsprofil = LogicFacade.getMaterial("TætningsprofilJumbo");
                tætningsprofil.setAntal(antalTætningsprofil);
                tætningsprofil.setComment("Tætningsprofil til tag");

        //Bundskruer (til tag)
        int antalBundskruer = rc.bottomScrews(length, width);
            Material bundskruer = LogicFacade.getMaterial("Bundskruer");
                bundskruer.setAntal(antalBundskruer);
                bundskruer.setComment("Bundskruer til taget");

        // Universalbeslag
        int universalbeslagAntalLeft = rc.universalBracketsLeft(length);
        int universalbeslagAntalRight = rc.universalBracketsRight(length);
            Material universalbeslagLeft = LogicFacade.getMaterial("UniversalbeslagVenstre");
                universalbeslagLeft.setAntal(universalbeslagAntalLeft);
                universalbeslagLeft.setComment("UniversalbeslagVenstre");
            Material universalbeslagRight = LogicFacade.getMaterial("UniversalbeslagHøjre");
                universalbeslagRight.setAntal(universalbeslagAntalRight);
                universalbeslagRight.setComment("UniversalbeslagHøjre");

        //Skruer til vandbræt
        int antalVSkruer = rc.waterboardScrews;
            Material vSkruer = LogicFacade.getMaterial("SkruerStern&Vandbræt");
                vSkruer.setAntal(antalVSkruer);
                vSkruer.setComment("Skruer til stern og vandbræt");

        // Beslagskruer
        int beslagskruerAntal = rc.bracketScrewsRoof(length);
            Material beslagskruer = LogicFacade.getMaterial("Beslagskruer");
                beslagskruer.setAntal(beslagskruerAntal);
                beslagskruer.setComment("Beslagskruer (BLIVER GENTAGET)");

        // Bræddebolte
        int bræddebolteAntal = rc.carriageBolts(length, width);
            Material bræddebolte = LogicFacade.getMaterial("Bræddebolt");
                bræddebolte.setAntal(bræddebolteAntal);
                bræddebolte.setComment("Bræddebolt");

        // Firkantskiver
        int firkantskiverAntal = rc.squares(length, width);
            Material firkantskiver = LogicFacade.getMaterial("Firkantskiver");
                firkantskiver.setAntal(firkantskiverAntal);
                firkantskiver.setComment("Firkantskiver");


// SHED
        // Lægte:
        int lægteAntal = sc.shedLath;
            Material lægte = LogicFacade.getMaterial("Lægte");
                lægte.setAntal(lægteAntal);
                lægte.setComment("Lægte til z på skur");

        // Løsholter
            // Hvilken type til siden og hvor mange:
            String typeSide = sc.løsholterTypeSide(shedDepth);
            Material løsholterSide;
            if (typeSide.equals("Løsholter240")){
                Material løsholter240 = LogicFacade.getMaterial("Løsholter240");
                løsholterSide = løsholter240;
            } else if (typeSide.equals("Løsholter270")){
                Material løsholter270 = LogicFacade.getMaterial("Løsholter270");
                løsholterSide = løsholter270;
            } else {
                Material løsholter360 = LogicFacade.getMaterial("Løsholter360");
                løsholterSide = løsholter360;
            }
            String typeGavl = sc.løsholterTypeGavl(shedWidth);
            Material løsholterGavl;
            if (typeGavl.equals("Løsholter240")){
                Material løsholter240 = LogicFacade.getMaterial("Løsholter240");
                løsholterGavl = løsholter240;
            } else if (typeGavl.equals("Løsholter270")){
                Material løsholter270 = LogicFacade.getMaterial("Løsholter270");
                løsholterGavl = løsholter270;
            } else {
                Material løsholter360 = LogicFacade.getMaterial("Løsholter360");
                løsholterGavl = løsholter360;
            }
            // Hvis løsholterGavlTypen er den samme som løsholterSideTypen så skal den lægge antallet sammen til
            // 1 samlet løsholter:
            Material løsholter1;
            Material løsholter2;
            int antalGavl = sc.løsholterAntalGavl(shedWidth);
            int antalSide = sc.løsholterAntalSide(shedDepth);
            int antalLøsholter;
            if (løsholterGavl.getSize()!=løsholterSide.getSize()){
                løsholter1 = løsholterGavl;
                    løsholter1.setAntal(antalGavl);
                    løsholter1.setComment("Løsholter til skurets gavl");
                løsholter2 = løsholterSide;
                    løsholter2.setAntal(antalSide);
                    løsholter2.setComment("Løsholter til skurets side");
            } else {
                løsholter1 = løsholterGavl;
                løsholter2 = null;
                    antalLøsholter = antalGavl + antalSide;
                    løsholter1.setAntal(antalLøsholter);
                    løsholter1.setComment("Løsholter til skurets sider og gavle");
            }

        // Lås
        Material lås = LogicFacade.getMaterial("Lås");
            lås.setAntal(sc.shedLock);
            lås.setComment("Lås til skur");

        // Hængsel
        Material hængsel = LogicFacade.getMaterial("Hængsel");
            hængsel.setAntal(sc.shedHinge);
            hængsel.setComment("Hængsler til skurdør");

        // Vinkelbeslag
        int antalVinkelbeslag = sc.vinkelbeslag(shedWidth, shedDepth);
            Material vinkelbeslag = LogicFacade.getMaterial("Vinkelbeslag");
                vinkelbeslag.setAntal(antalVinkelbeslag);
                vinkelbeslag.setComment("Vinkelbeslag");

        String jspSide;
        // Flat tag, intet skur:
        if (tag == 0 && skur == 0){
            carport.addConstructionMaterial(stolpe);
            carport.addConstructionMaterial(hulbånd);
            carport.addConstructionMaterial(beslagskruer);

            // TODO beklædning skal være her

            carport.addRoofMaterial(under360);
            carport.addRoofMaterial(under540);
            carport.addRoofMaterial(over360);
            carport.addRoofMaterial(over540);
            carport.addRoofMaterial(rem480);
            carport.addRoofMaterial(rem600);
            carport.addRoofMaterial(spær);
            carport.addRoofMaterial(vandbræt360);
            carport.addRoofMaterial(vandbræt540);
            carport.addRoofMaterial(tætningsprofil);
            carport.addRoofMaterial(bundskruer);
            carport.addRoofMaterial(universalbeslagLeft);
            carport.addRoofMaterial(universalbeslagRight);
            carport.addRoofMaterial(vSkruer);
            carport.addRoofMaterial(beslagskruer);
            carport.addRoofMaterial(bræddebolte);
            carport.addRoofMaterial(firkantskiver);

            jspSide = "styklisteFlatroof";
        // Flat tag, med skur:
        } else if (tag == 0 && skur == 1){

            carport.addConstructionMaterial(stolpe);
            carport.addConstructionMaterial(hulbånd);
            carport.addConstructionMaterial(beslagskruer);

            // TODO beklædning skal være her
            if (under360Antal>0){
                carport.addRoofMaterial(under360);
            }
            if (under540Antal>0){
                carport.addRoofMaterial(under540);
            }
            if (over360Antal>0){
                carport.addRoofMaterial(over360);
            }
            if (over540Antal>0){
                carport.addRoofMaterial(over540);
            }
            if (rem480Antal>0){
                carport.addRoofMaterial(rem480);
            }
            if (rem600Antal>0){
                carport.addRoofMaterial(rem600);
            }
            carport.addRoofMaterial(spær);
            if (vandbræt360Antal>0){
                carport.addRoofMaterial(vandbræt360);
            }
            if (vandbræt540Antal>0){
                carport.addRoofMaterial(vandbræt540);
            }
            carport.addRoofMaterial(tætningsprofil);
            carport.addRoofMaterial(bundskruer);
            carport.addRoofMaterial(universalbeslagLeft);
            carport.addRoofMaterial(universalbeslagRight);
            carport.addRoofMaterial(vSkruer);
            carport.addRoofMaterial(beslagskruer);
            carport.addRoofMaterial(bræddebolte);
            carport.addRoofMaterial(firkantskiver);

            carport.addShedMaterial(lægte);
            if (løsholter1.getAntal()>0){
                carport.addShedMaterial(løsholter1);
            }
            carport.addShedMaterial(lås);
            carport.addShedMaterial(hængsel);
            carport.addShedMaterial(vinkelbeslag);

            jspSide = "styklisteFlatroofSkur";
        // Pitched tag, intet skur:
        } else if (tag == 1 && skur == 0){
            jspSide = "styklistePitchedroof";
        // Pitched tag, med skur:
        } else {
            jspSide = "styklistePitchedroofSkur";
        }

        HttpSession session = request.getSession();

        session.setAttribute("constuctionList", carport.getConstructionMaterials());
        //session.setAttribute("overlayList", carport.getOverlayMaterials());
        session.setAttribute("roofList", carport.getRoofMaterials());
        session.setAttribute("shedList", carport.getShedMaterials());


        return jspSide;
    }


}
