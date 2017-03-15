package tc.bean;

import tc.model.Bankcard;

/**
 * Created by stonezhang on 2017/3/12.
 */
public class BankcardVO {
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

    public BankcardVO() {

    }

    public BankcardVO(Bankcard bankcard) {
        this.id = bankcard.getId();
        this.balance = bankcard.getBalance();
    }
}

