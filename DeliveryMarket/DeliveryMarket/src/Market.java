import java.util.ArrayList;

public class Market {
    private ArrayList<Product> productRange;
    private String name;
    private DistrictsList district;
    private int deliveryKoeff;
    private Order currentOrder;
    private Courier courier;
    private int marketBalance;

    private Product getProduct(String productName) {
        return productRange.stream().filter(toGet -> productName == toGet.getName()).findAny().orElse(null);
    }

    public Market(String name_c, DistrictsList district_c, int deliveryKoeff_c) {
        productRange = new ArrayList<Product>();
        name = name_c;
        district = district_c;
        deliveryKoeff = deliveryKoeff_c;
        currentOrder = null;
        courier = null;
        marketBalance = 0;
    }

    public String getName() {
        return name;
    }

    public DistrictsList getDistrict() {
        return district;
    }

    public int getMarketBalance() {
        return marketBalance;
    }

    public ArrayList<Product> getProductRange() {
        return productRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeliveryKoeff() {
        return deliveryKoeff;
    }

    public void setDeliveryKoeff(int deliveryKoeff) {
        this.deliveryKoeff = deliveryKoeff;
    }

    public Order makeOrder(Customer customer) {
        currentOrder = new Order(customer, customer.getDistrict(), this);
        courier.UpdateOrder(currentOrder);
        return currentOrder;
    }

    public void createCourier(String name, int speed) {
        if (courier == null)
            courier = new Courier(name, speed, currentOrder);
    }

    public void setProductPrice(String prod, int newPrice) {
        var productToSetPrice = getProduct(prod);
        if (productToSetPrice != null) {
            productToSetPrice.setPrice(newPrice);
            return;
        }
        System.out.println("No such prod");
    }

    public void addProductToMarket(String name, int price, int amount) {
        var productToAdd = getProduct(name);
        if (productToAdd != null) {
            productToAdd.setPrice(price);
            productToAdd.setAmount(productToAdd.getAmount() + amount);
            return;
        }
        productToAdd = new Product(name, price, amount);
        productRange.add(productToAdd);
    }

    public void removeProductFromMarket(String name, int amount) {
        var prodToRemove = getProduct(name);
        if (prodToRemove == null) {
            System.out.println("No such prod");
        } else if (prodToRemove.getAmount() < amount) {
            System.out.println("not enough to remove");
        } else if (prodToRemove.getAmount() == amount) {
            productRange.remove(prodToRemove);
        } else {
            prodToRemove.setAmount(prodToRemove.getAmount() - amount);
        }
    }

    public void addProductToOrder(String productName, int amount) {
        var prod = getProduct(productName);
        if (prod == null) {
            System.out.println("No such product");
        } else if (prod.getAmount() < amount) {
            System.out.println("Not enough products");
        } else {
            var customerProduct = new Product(prod.getName(), prod.getPrice(), amount);
            removeProductFromMarket(productName, amount);
            currentOrder.AddToOrder(customerProduct);
        }
    }

    public void deleteProductFromOrder(String productName, int amount) {
        var prodToDelete = currentOrder.GetProductFromOrder(productName);
        if (prodToDelete == null) {
            System.out.println("No such product");
        } else if (prodToDelete.getAmount() < amount) {
            System.out.println("Not enough products");
        } else {
            prodToDelete.setAmount(amount);
            productRange.add(prodToDelete);
            currentOrder.DeleteFromOrder(productName, amount);
        }
    }

    public void ConfirmOrder(int pin) {
        if (!currentOrder.getCustomer().getCard().Withdraw(currentOrder.CalculateOrderPrice(), pin) || currentOrder.isDelivered()) return;
        marketBalance += currentOrder.CalculateOrderPrice();
        courier.DeliverOrder();
    }
}
