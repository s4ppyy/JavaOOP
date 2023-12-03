import java.util.ArrayList;

import static java.lang.Math.abs;

public class Order {

    private ArrayList<Product> order_list;
    private Customer customer;
    private DistrictsList district;
    private Market market;
    private int price;
    private boolean isDelivered;

    private int calculateDeliveryPrice() {
        return abs((market.getDistrict().ordinal() - district.ordinal()) * market.getDeliveryKoeff());
    }

    public Order(Customer customer_c, DistrictsList district_c, Market market_c) {
        order_list = new ArrayList<Product>();
        customer = customer_c;
        district = district_c;
        market = market_c;
        price = 0;
        isDelivered = false;
    }
    public boolean isDelivered(){
        return isDelivered;
    }

    public int CalculateOrderPrice() {
        int price = 0;
        for (var prod :
                order_list) {
            price += prod.getPrice() * prod.getAmount();
        }
        price += calculateDeliveryPrice();
        return price;
    }

    public ArrayList<Product> getOrder_list() {
        return order_list;
    }

    public Market getMarket() {
        return market;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void AddToOrder(Product prodToAdd) {
        var prod = GetProductFromOrder(prodToAdd.getName());
        if (prod != null) {
            prod.setAmount(prod.getAmount() + prodToAdd.getAmount());
            return;
        }
        order_list.add(prodToAdd);
    }

    public Product GetProductFromOrder(String productName) {
        return order_list.stream().filter(toGet -> productName == toGet.getName()).findAny().orElse(null);
    }

    public void DeleteFromOrder(String nameToDelete, int amountToDelete) {
        var prod = order_list.stream().filter(toDelete -> nameToDelete == toDelete.getName()).findAny().orElse(null);
        if (prod == null) {
            System.out.println("netu");
        } else if (prod.getAmount() < amountToDelete) {
            System.out.println("wrong amount");
        } else if (prod.getAmount() == amountToDelete) {
            order_list.remove(prod);
        } else {
            prod.setAmount(prod.getAmount() - amountToDelete);
        }
    }

    public void confirmDeliveranceOrder(){
        if (isDelivered) {
            System.out.println("Already delivered!!!");
            return;
        }
        isDelivered = true;
        System.out.println("Order Delivered!");
    }
}
