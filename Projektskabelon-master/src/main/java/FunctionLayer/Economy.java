package FunctionLayer;

/**
 * @author  Mia
 * The purpose of this class is to calculate prices and cost of different elements of a construction
 * and of the whole construction
 */
public class Economy {

    public static double ordersSalePrice(Order order) {
        //TODO implement thismethod
        // so it returns saleprace that depends on cost, coverage, tax and transport
        // there is a nice konstant in Order: order.getTAX and it's value is 0.25.
        // You can use it for tax calculation if it makes sense


        double salePrice = 1234.50;
        return salePrice;
    }

    public static double ordersCostPrice(Order order) {
        //TODO implement thismethod (all materials together
        double cost = 234.5;
        return  cost;

    }

    public static double setCoverage(Order order) {
        //TODO implement this method so it vil return coverage that depends on transport, tax and cost price
        double coverage = 65.0;
        return coverage;
    }
}
