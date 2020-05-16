package FunctionLayer;

import java.util.ArrayList;

/**
 * @author  Mia
 * The purpose of this class is to calculate prices and cost of different elements of a construction
 * and of the whole construction
 */
public class Economy {
    // Indkøbspris
    public static double ordersCostPrice(Order order) throws LoginSampleException {
        // Søg efter materiales pris via id
        // Hent prisen fra db og set pris i materialCalculator klasserne
        // Looper igennem arraylisten og får fat på hver materiales pris og antal

        ArrayList<Material> temp = new ArrayList<>();
        temp.addAll(ConstructionMaterialCalculator.constructionMaterialList(order.getConstruction()));
        // TODO sæt roofmateriallisten ind her:
        //temp.addAll()
        // TODO sæt overlaymateriallisten ind her:
        //temp.addAll()

        double[] totalPrices = new double[temp.size()];

        for (int i = 0; i < temp.size(); i++){
            totalPrices[i] = temp.get(i).getPrice()*temp.get(i).getAmount();
        }
        double cost = 0;
        for (double i : totalPrices) {
            cost += i;
        }
        return  cost;
    }

    // Salgsprisen
    public static double ordersSalePrice(Order order) throws LoginSampleException {

        // Salgspris = (Indkøbspris + Fragt)* 25 % skat

        double transport = order.getTransport(); // Transport udgift
        double tax = order.getTAX(); // 0,25

        double salesPriceNoTax = ordersCostPrice(order) + transport;

        double salesPrice = salesPriceNoTax + salesPriceNoTax*tax;

        return salesPrice;
    }

    // Dækningsbidrag og dækningsgrad i %
    public static double setCoverage(Order order) throws LoginSampleException {

        double transport = order.getTransport(); // Transport udgift
        double tax = order.getTAX(); // 0,25
        double cost = ordersCostPrice(order);
        double salesPrice = ordersSalePrice(order);

        // Dækningsbidrag = Salgspris - (Indkøbspris+Fragt) skat?
        double coverageContribution = ((salesPrice*tax)+cost+transport) - salesPrice;

        // Dækningsgrad = ( Dækningsbidrag / cost ) * 100
        double coverage = (coverageContribution/cost)*100;

        return coverage;
    }


}
