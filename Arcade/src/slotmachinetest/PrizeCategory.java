package slotmachinetest;

public class PrizeCategory {

    private String name;
    private int cost;
    private int quantity;

    public PrizeCategory(String nameConstruct, int costConstruct, int quantityConstruct) throws Exception {
        if (nameConstruct.isEmpty()) throw new Exception("Empty string");
        if (costConstruct <= 0) throw new Exception("Invalid number");
        if (quantityConstruct <= 0) throw new Exception("Invalid number");
        name = nameConstruct;
        cost = costConstruct;
        quantity = quantityConstruct;
    }

    public String GetName() {
        return name;
    }

    public int GetCost() {
        return cost;
    }

    public int GetQuantity() {
        return quantity;
    }

    public void SetName(String newName) throws Exception {
        if (newName.isEmpty()) throw new Exception("Empty string");
        name = newName;
    }

    public void SetCost(int newCost) throws Exception {
        if (newCost <= 0) throw new Exception("Invalid number");
        cost = newCost;
    }

    public void SetQuantity(int newQuantity) throws Exception {
        if (newQuantity <= 0) throw new Exception("Invalid number");
        quantity = newQuantity;
    }

    public void GivePrize() throws Exception {
        if (quantity == 0) throw new Exception("Not Enough Prizes");
        quantity--;
        System.out.println("You Are Great!!!");
    }
}
