package tc.model;

public class Bankcard {
   private String id;
   private double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bankcard{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}