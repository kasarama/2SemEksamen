package FunctionLayer;

public class Main {
    public static void main(String[] args) throws LoginSampleException {
        Order order = new Order();
        Construction construction = new Construction();

        construction.setCarportLength(5000);
        construction.setCarportWidth(4200);
        construction.setConstructionHeight(2000);

        Economy.ordersCostPrice(order);
    }
}
