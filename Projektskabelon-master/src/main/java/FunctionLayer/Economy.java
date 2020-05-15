package FunctionLayer;

import java.util.ArrayList;

/**
 * @author  Mia
 * The purpose of this class is to calculate prices and cost of different elements of a construction
 * and of the whole construction
 */
public class Economy {
    // Indkøbspris
    public static double ordersCostPrice(Order order, Construction construction) throws LoginSampleException {
        // Søg efter materiales pris via id
        // Hent prisen fra db og set pris i materialCalculator klasserne
        // Looper igennem arraylisten og får fat på hver materiales pris og antal

        ArrayList<Material> temp = new ArrayList<>();
        temp.addAll(ConstructionMaterialCalculator.constructionMaterialList(construction));
        // TODO sæt roofmateriallisten ind her:
        //temp.addAll()
        // TODO sæt overlaymateriallisten ind her:
        //temp.addAll()

        //double[] prices = {};
        double[] totalPrices = {};

        /*
        Material rem = temp.get(0);
        for (Material material: temp){
            prices = new double[(int) material.getPrice()];
        }

         */

        for (int i = 0; i < temp.size(); i++){
            //prices = new double[(int) temp.get(i).getPrice()];
            totalPrices = new double[(int) (temp.get(i).getPrice()*temp.get(i).getAmount())];
        }
        double cost = 0;
        for (double i : totalPrices) {
            cost += i;
            System.out.println("The sum is " + cost);
        }
        return  cost;
    }

    // Salgsprisen
    public static double ordersSalePrice(Order order, Construction construction) throws LoginSampleException {

        // Salgspris = (Indkøbspris + Fragt)* 25 % skat

        double transport = order.getTransport(); // Transport udgift
        double tax = order.getTAX(); // 0,25

        double salesPriceNoTax = ordersCostPrice(order, construction) + transport;

        double salesPrice = salesPriceNoTax + salesPriceNoTax*tax;

        return salesPrice;
    }

    // Dækningsbidrag og dækningsgrad i %
    public static double setCoverage(Order order, Construction construction) throws LoginSampleException {

        double transport = order.getTransport(); // Transport udgift
        double tax = order.getTAX(); // 0,25
        double cost = ordersCostPrice(order, construction);
        double salesPrice = ordersSalePrice(order, construction);

        // Dækningsbidrag = Salgspris - (Indkøbspris+Fragt) skat?
        double coverageContribution = salesPrice - ((salesPrice*tax)+cost+transport);

        // Dækningsgrad = ( Dækningsbidrag / cost ) * 100
        double coverage = (coverageContribution/cost)*100;

        return coverage;
    }


}
