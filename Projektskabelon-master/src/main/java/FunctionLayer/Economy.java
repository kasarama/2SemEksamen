package FunctionLayer;

import java.util.ArrayList;

/**
 * @author  Mia
 * The purpose of this class is to calculate prices and cost of different elements of a construction
 * and of the whole construction
 */
public class Economy {

    // TODO 1.) Hent priser og antal fra DB (orders?)
    // TODO 2.) Udregn cost

    public static double ordersCostPrice(Order order) throws LoginSampleException {
        //TODO implement thismethod (all materials together
        // Søg efter materiales pris via id
        // Hent prisen fra db og set pris i materialCalculator klasserne
        // Looper igennem arraylisten og får fat på hver materiales pris og antal

        ArrayList<Material> temp = ConstructionMaterialCalculator.woodMaterials(order.getConstruction());

        Material rem = temp.get(1);
        System.out.println(rem.getId() + ", " + rem.getPrice());
        //rem.getPrice();

        double cost = 234.5;
        return  cost;

    }

    public static double setCoverage(Order order) {
        //TODO implement this method so it vil return coverage that depends on transport, tax and cost price
        double coverage = 65.0;
        return coverage;
    }

    public static double ordersSalePrice(Order order) {
        //TODO implement thismethod
        // so it returns saleprace that depends on cost, coverage, tax and transport
        // there is a nice konstant in Order: order.getTAX and it's value is 0.25.
        // You can use it for tax calculation if it makes sense


        double salePrice = 1234.50;
        return salePrice;
    }

}
