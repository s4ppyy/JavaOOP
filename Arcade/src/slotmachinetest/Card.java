package slotmachinetest;

public class Card {

    private int balanceCredit;
    private int balanceTicket;
    private int id;


    public Card(int idConstructor) throws Exception {
        if (idConstructor < 0) throw new Exception("Invalid Number");
        id = idConstructor;
    }

    public int GetBalanceCredit() {
        return balanceCredit;
    }

    public int GetBalanceTicket() {
        return balanceTicket;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int newId) throws Exception {
        if (newId < 0) throw new Exception("Invalid Number");
        id = newId;
    }

    public void SetBalanceCredit(int newBalance) throws Exception {
        if (newBalance < 0) throw new Exception("Invalid Number");
        balanceCredit = newBalance;
    }

    public void SetBalanceTicket(int newBalance) throws Exception {
        if (newBalance < 0) throw new Exception("Invalid Number");
        balanceTicket = newBalance;
    }

    public void TopUpBalanceCredit(int sumTopUp) throws Exception {
        if (sumTopUp <= 0) throw new Exception("Invalid Sum");
        balanceCredit += sumTopUp;
    }

    public void TopUpBalanceTicket(int sumTopUp) throws Exception {
        if (sumTopUp <= 0) throw new Exception("Invalid Sum");
        balanceTicket += sumTopUp;
    }

    public void WithdrawBalanceCredit(int sumWithdraw) throws Exception {
        if (sumWithdraw <= 0 || sumWithdraw > balanceCredit) throw new Exception("Invalid Sum");
        balanceCredit -= sumWithdraw;
    }

    public void WithdrawBalanceTicket(int sumWithdraw) throws Exception {
        if (sumWithdraw <= 0 || sumWithdraw > balanceTicket) throw new Exception("Invalid Sum");
        balanceTicket -= sumWithdraw;
    }
}
