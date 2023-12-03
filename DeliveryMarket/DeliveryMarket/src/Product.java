public class Product {
    private String name;
    private int price;
    private int amount;
    public Product(String name_c, int price_c, int amount_c){
        name = name_c;
        price = price_c;
        amount = amount_c;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
