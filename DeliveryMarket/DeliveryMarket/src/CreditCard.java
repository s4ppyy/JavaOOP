public class CreditCard {

    private int id;
    private int pin;
    private int balance;

    public CreditCard(int id_c, int pin_c, int balance_c) {
        id = id_c;
        pin = pin_c;
        balance = balance_c;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean checkPin(int pinToCompare) {
        return pin == pinToCompare;
    }

    public void topUp(int add) {
        balance += add;
    }

    public Boolean Withdraw(int subtract, int pin) {
        if (this.getBalance() >= subtract && checkPin(pin)) {
            this.setBalance(this.getBalance() - subtract);
            return true;
        } else if (this.getBalance() < subtract && checkPin(pin)){
            System.out.println("not enough money");
            return false;
        } else {
            System.out.println("Wrong pin");
            return false;
        }
    }

}
