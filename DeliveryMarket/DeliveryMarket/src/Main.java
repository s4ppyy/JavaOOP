public class Main {
    public static void main(String[] args) {
        var market = new Market("Lenta", DistrictsList.Komendantskiy, 10);
        var customer = new Customer(0, "Andrey", DistrictsList.Murino);
        market.addProductToMarket("Beer", 299, 10);
        market.createCourier("Rayan Gosling v filme Drive", 20);
        customer.CreateCard(6969);
        customer.topUp(1000);
        customer.StartShopping(market);
        customer.addProductToOrder("Beer", 2);
        customer.ConfirmOrder(6969);
        System.out.println(customer.getCard().getBalance()); // Check if everything is ok...
        System.out.println(customer.getCustomerProducts().get(0).getName());
        System.out.println(customer.getCustomerProducts().get(0).getAmount());
        System.out.println(market.getMarketBalance());
        System.out.println(market.getProductRange().get(0).getName());
        System.out.println(market.getProductRange().get(0).getAmount());
    }
}