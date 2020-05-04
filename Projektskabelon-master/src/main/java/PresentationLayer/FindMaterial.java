package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindMaterial extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        // Her skal der findes de materialer og indsættes i DB i itemlist
/*
        int length = Integer.parseInt(request.getParameter( "carportLength" ));
        int width = Integer.parseInt(request.getParameter( "carportWidth" ));
        int tag = Integer.parseInt(request.getParameter("roofType"));
        int skur = Integer.parseInt(request.getParameter("isShed"));
        int shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
*/

Construction construction = (Construction) request.getSession().getAttribute("carportBase");
        int length = construction.getCarportLength();
        int width = construction.getCarportWidth();
        boolean tag =  construction.getRoof().getIsPitched();
        int skur = construction.getShed().getDepth();
        int shedDepth =  construction.getShed().getDepth();
        int shedWidth = construction.getShed().getWidth();




    // CONSTRUCTION:
        // Stolper intet skur
        int stolpeAntal;
        Material stolpe;
        if (skur == 0){
            stolpeAntal = ConstructionMaterialCalculator.posts(length, width);
                stolpe = LogicFacade.getMaterial("Stolpe");
                    stolpe.setAmount(stolpeAntal);
                    stolpe.setComment("Stolpe");
        } else {
            // Stolper med skur stolper
            stolpeAntal = ShedCalculator.shedPosts(length, width, shedWidth);
                stolpe = LogicFacade.getMaterial("Stolpe");
                    stolpe.setAmount(stolpeAntal);
                    stolpe.setComment("Stolpe");
        }

        // Hulbånd
        int perNumber = ConstructionMaterialCalculator.perforatedBand(length, width);
            Material perforatedBand = LogicFacade.getMaterial("Hulbånd");
                perforatedBand.setAmount(perNumber);
                perforatedBand.setComment("Hulbånd");

        // Beslagskruer
        int bracketScrewsHulAntal = ConstructionMaterialCalculator.bracketScrewsCon(length);
            Material brackeScrews = LogicFacade.getMaterial("Beslagskruer");
                brackeScrews.setAmount(bracketScrewsHulAntal);
                brackeScrews.setComment("Beslagskruer (BLIVER GENTAGET)");


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
        int under360Antal = FunctionLayer.RoofMaterialCalculator.understernboartU360(length, width);
        int under540Antal = FunctionLayer.RoofMaterialCalculator.understernboartU540(length, width);
            Material under360 = LogicFacade.getMaterial("Understernbrædder360");
                under360.setAmount(under360Antal);
                under360.setComment("Understernbrædder 360 cm");
            Material under540 = LogicFacade.getMaterial("Understernbrædder540");
                under540.setAmount(under540Antal);
                under540.setComment("Understernbrædder 540 cm");

        // Oversternbrædder
        int over360Antal = FunctionLayer.RoofMaterialCalculator.oversternboartU360(length, width);
        int over540Antal = FunctionLayer.RoofMaterialCalculator.oversternboartU540(length, width);
            Material over360 = LogicFacade.getMaterial("Oversternbrædder360");
                over360.setAmount(over360Antal);
                over360.setComment("Oversternbrædder 360 cm");
            Material over540 = LogicFacade.getMaterial("Oversternbrædder540");
                over540.setAmount(over540Antal);
                over540.setComment("Oversternbrædder 540 cm");

        // Rem
        int rem600Antal = FunctionLayer.RoofMaterialCalculator.rem600(length, width);
        int rem480Antal = FunctionLayer.RoofMaterialCalculator.rem480(length, width);
            Material rem600 = LogicFacade.getMaterial("Rem600");
                rem600.setAmount(rem600Antal);
                rem600.setComment("Rem 600 cm");
            Material rem480 = LogicFacade.getMaterial("Rem480");
                rem480.setAmount(rem480Antal);
                rem480.setComment("Rem 480 cm");

        // Spær
        int raftNumber = FunctionLayer.RoofMaterialCalculator.raft(length);
            Material raft = LogicFacade.getMaterial("Spær");
                raft.setAmount(raftNumber);
                raft.setComment("Spær");

        // Vandbræt
        int waterboard360Antal = FunctionLayer.RoofMaterialCalculator.vandbræt360(length, width);
        int waterboard540Antal = FunctionLayer.RoofMaterialCalculator.vandbræt540(length, width);
            Material waterboard360 = LogicFacade.getMaterial("Vandbræt360");
                waterboard360.setAmount(waterboard360Antal);
                waterboard360.setComment("Drypnæse 360 cm");
            Material waterboard540 = LogicFacade.getMaterial("Vandbræt540");
                waterboard540.setAmount(waterboard540Antal);
                waterboard540.setComment("Drypnæse 540 cm");

        // Tætningsprofil
        int sealingNumber = FunctionLayer.RoofMaterialCalculator.gasket(width);
            Material sealing = LogicFacade.getMaterial("TætningsprofilJumbo");
                sealing.setAmount(sealingNumber);
                sealing.setComment("Tætningsprofil til tag");

        //Bundskruer (til tag)
        int antalBundskruer = FunctionLayer.RoofMaterialCalculator.bottomScrews(length, width);
            Material bundskruer = LogicFacade.getMaterial("Bundskruer");
                bundskruer.setAmount(antalBundskruer);
                bundskruer.setComment("Bundskruer til taget");

        // Universalbeslag
        int universalbeslagAntalLeft = FunctionLayer.RoofMaterialCalculator.universalBracketsLeft(length);
        int universalbeslagAntalRight = FunctionLayer.RoofMaterialCalculator.universalBracketsRight(length);
            Material universalbeslagLeft = LogicFacade.getMaterial("UniversalbeslagVenstre");
                universalbeslagLeft.setAmount(universalbeslagAntalLeft);
                universalbeslagLeft.setComment("UniversalbeslagVenstre");
            Material universalbeslagRight = LogicFacade.getMaterial("UniversalbeslagHøjre");
                universalbeslagRight.setAmount(universalbeslagAntalRight);
                universalbeslagRight.setComment("UniversalbeslagHøjre");

        //Skruer til vandbræt
        int antalVSkruer = FunctionLayer.RoofMaterialCalculator.waterboardScrews;
            Material vSkruer = LogicFacade.getMaterial("SkruerStern&Vandbræt");
                vSkruer.setAmount(antalVSkruer);
                vSkruer.setComment("Skruer til stern og vandbræt");

        // Beslagskruer
        int beslagskruerAntal = FunctionLayer.RoofMaterialCalculator.bracketScrewsRoof(length);
            Material beslagskruer = LogicFacade.getMaterial("Beslagskruer");
                beslagskruer.setAmount(beslagskruerAntal);
                beslagskruer.setComment("Beslagskruer (BLIVER GENTAGET)");

        // Bræddebolte
        int bræddebolteAntal = FunctionLayer.RoofMaterialCalculator.carriageBolts(length, width);
            Material bræddebolte = LogicFacade.getMaterial("Bræddebolt");
                bræddebolte.setAmount(bræddebolteAntal);
                bræddebolte.setComment("Bræddebolt");

        // Firkantskiver
        int firkantskiverAntal = FunctionLayer.RoofMaterialCalculator.squares(length, width);
            Material firkantskiver = LogicFacade.getMaterial("Firkantskiver");
                firkantskiver.setAmount(firkantskiverAntal);
                firkantskiver.setComment("Firkantskiver");


// SHED
        // Lægte:
        int lægteAntal = ShedCalculator.shedLath;
            Material lægte = LogicFacade.getMaterial("Lægte");
                lægte.setAmount(lægteAntal);
                lægte.setComment("Lægte til z på skur");

        // Løsholter
            // Hvilken type til siden og hvor mange:
            String typeSide = ShedCalculator.løsholterTypeSide(shedDepth);
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

            String typeGavl = ShedCalculator.løsholterTypeGavl(shedWidth);
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
            int antalGavl = ShedCalculator.løsholterAntalGavl(shedWidth);
            int antalSide = ShedCalculator.løsholterAntalSide(shedDepth);
            int antalLøsholter;
            if (løsholterGavl.getSize()!=løsholterSide.getSize()){
                løsholter1 = løsholterGavl;
                    løsholter1.setAmount(antalGavl);
                    løsholter1.setComment("Løsholter til skurets gavl");
                løsholter2 = løsholterSide;
                    løsholter2.setAmount(antalSide);
                    løsholter2.setComment("Løsholter til skurets side");
            } else {
                løsholter1 = løsholterGavl;
                løsholter2 = null;
                    antalLøsholter = antalGavl + antalSide;
                    løsholter1.setAmount(antalLøsholter);
                    løsholter1.setComment("Løsholter til skurets sider og gavle");
            }

        // Lås
        Material lås = LogicFacade.getMaterial("Lås");
            lås.setAmount(ShedCalculator.shedLock);
            lås.setComment("Lås til skur");

        // Hængsel
        Material hængsel = LogicFacade.getMaterial("Hængsel");
            hængsel.setAmount(ShedCalculator.shedHinge);
            hængsel.setComment("Hængsler til skurdør");

        // Vinkelbeslag
        int antalVinkelbeslag = ShedCalculator.vinkelbeslag(shedWidth, shedDepth);
            Material vinkelbeslag = LogicFacade.getMaterial("Vinkelbeslag");
                vinkelbeslag.setAmount(antalVinkelbeslag);
                vinkelbeslag.setComment("Vinkelbeslag");

        String jspSide;
        // Flat tag, intet skur:
        if (!tag && skur == 0){
            System.out.println("Flat tag, intet skur. - pitchedroof:"+tag+"shed depth :"+skur);
            construction.addConstructionMaterial(stolpe);
            construction.addConstructionMaterial(perforatedBand);
            construction.addConstructionMaterial(beslagskruer);

            // TODO beklædning skal være her

         /*   construction.addRoofMaterial(under360);
            construction.addRoofMaterial(under540);
            construction.addRoofMaterial(over360);
            construction.addRoofMaterial(over540);
            construction.addRoofMaterial(rem480);
            construction.addRoofMaterial(rem600);
            construction.addRoofMaterial(raft);
            construction.addRoofMaterial(waterboard360);
            construction.addRoofMaterial(waterboard540);
            construction.addRoofMaterial(sealing);
            construction.addRoofMaterial(bundskruer);
            construction.addRoofMaterial(universalbeslagLeft);
            construction.addRoofMaterial(universalbeslagRight);
            construction.addRoofMaterial(vSkruer);
            construction.addRoofMaterial(beslagskruer);
            construction.addRoofMaterial(bræddebolte);
            construction.addRoofMaterial(firkantskiver);
*/
            jspSide = "styklisteFlatroof";
        // Flat tag, med skur:
        } else if (!tag && skur != 0){
            System.out.println("Flat tag, med skur. - pitchedroof:"+tag+"shed depth :"+skur);


            construction.addConstructionMaterial(stolpe);
            construction.addConstructionMaterial(perforatedBand);
            construction.addConstructionMaterial(beslagskruer);

            // TODO beklædning skal være her
          /*  if (under360Antal>0){
                construction.addRoofMaterial(under360);
            }
            if (under540Antal>0){
                construction.addRoofMaterial(under540);
            }
            if (over360Antal>0){
                construction.addRoofMaterial(over360);
            }
            if (over540Antal>0){
                construction.addRoofMaterial(over540);
            }
            if (rem480Antal>0){
                construction.addRoofMaterial(rem480);
            }
            if (rem600Antal>0){
                construction.addRoofMaterial(rem600);
            }
            construction.addRoofMaterial(raft);
            if (waterboard360Antal>0){
                construction.addRoofMaterial(waterboard360);
            }
            if (waterboard540Antal>0){
                construction.addRoofMaterial(waterboard540);
            }
            construction.addRoofMaterial(sealing);
            construction.addRoofMaterial(bundskruer);
            construction.addRoofMaterial(universalbeslagLeft);
            construction.addRoofMaterial(universalbeslagRight);
            construction.addRoofMaterial(vSkruer);
            construction.addRoofMaterial(beslagskruer);
            construction.addRoofMaterial(bræddebolte);
            construction.addRoofMaterial(firkantskiver);

            construction.addShedMaterial(lægte);
            if (løsholter1.getAntal()>0){
                construction.addShedMaterial(løsholter1);
            }
            construction.addShedMaterial(lås);
            construction.addShedMaterial(hængsel);
            construction.addShedMaterial(vinkelbeslag);*/

            jspSide = "styklisteFlatroofSkur";
        // Pitched tag, intet skur:
        } else if (tag && skur == 0){
            System.out.println("pitched tag, intet skur. - pitchedroof:"+tag+"shed depth :"+skur);

            jspSide = "styklistePitchedroof";
        // Pitched tag, med skur:
        } else {
            System.out.println("pitched tag, med skur. - pitchedroof:"+tag+"shed depth :"+skur);

            jspSide = "styklistePitchedroofSkur";
        }

        HttpSession session = request.getSession();

        session.setAttribute("constuctionList", construction.getFundamentMaterials());
        //session.setAttribute("overlayList", carport.getOverlayMaterials());
      /*  session.setAttribute("roofList", construction.getRoofMaterials());
        session.setAttribute("shedList", construction.getShedMaterials());

*/
        return jspSide;
    }


}
