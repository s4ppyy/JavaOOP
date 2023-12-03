import java.util.ArrayList;
import java.util.Locale;

public class Customer {
    private int id;
    private String name;
    private CreditCard card;
    private DistrictsList district;
    private ArrayList<Product> customerProducts;
    private Order currentOrder;
    public Customer(int id_c, String name_c, DistrictsList district_c){
        id = id_c;
        name = name_c;
        district = district_c;
        customerProducts = new ArrayList<Product>();
        currentOrder = null;
    }

    public ArrayList<Product> getCustomerProducts() {
        return customerProducts;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public CreditCard getCard() {
        return card;
    }

    public DistrictsList getDistrict() {
        return district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistrict(DistrictsList district) {
        this.district = district;
    }

    public void CreateCard(int pin){
        if (card == null)
            card = new CreditCard(id, pin, 0);
    }

    public void topUp(int balance){
        card.topUp(balance);
    }

    public void withdraw(int subtract, int pin){
        card.Withdraw(subtract, pin);
    }

    public void StartShopping(Market marketToShop) {
        currentOrder = marketToShop.makeOrder(this);
    }
    public void addProductToOrder(String prodName, int amount){
        currentOrder.getMarket().addProductToOrder(prodName, amount);
    }
    public void deleteProductFromOrder(String prodName, int amount){
        currentOrder.getMarket().deleteProductFromOrder(prodName, amount);
    }

    public void ConfirmOrder(int pin){
        currentOrder.getMarket().ConfirmOrder(pin);
    }
}
