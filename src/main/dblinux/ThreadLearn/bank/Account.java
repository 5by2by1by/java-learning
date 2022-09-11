package main.dblinux.ThreadLearn.bank;

/**
 * @author dblinux
 * @Date 2022/6/7 15:18
 */
public class Account {
    private String id;
    private String name;
    private float balance;

    public Account(String id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    /**
     * 扣减金额
     * @param amount
     */
    public synchronized void subtractAmount(float amount){
        if(this.balance < amount){
            throw new RuntimeException("余额不足");
        }
        this.balance -= amount;
    }

    /**
     * 增加金额
     * @param amount
     */
    public synchronized void addAmount(float amount){
        this.balance += amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
