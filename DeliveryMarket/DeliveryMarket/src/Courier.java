import static java.lang.Math.abs;

public class Courier {
    private static final int milliseconds = 1000;
    private String name;
    private int speed;
    private Order order;

    private int countDeliveryTime() {
        return abs((order.getMarket().getDistrict().ordinal() - order.getCustomer().getDistrict().ordinal()) / speed * 10) * milliseconds;
    }

    public Courier(String name_c, int speed_c, Order order_c) {
        name = name_c;
        speed = speed_c;
        order = order_c;
    }

    public void UpdateOrder(Order newOrder) {
        order = newOrder;
    }

    public void DeliverOrder() {
        System.out.println("Delivering order...");
        try {
            Thread.sleep(countDeliveryTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var customerProducts = order.getCustomer().getCustomerProducts();
        customerProducts.addAll(order.getOrder_list());
        order.confirmDeliveranceOrder();
    }
}
