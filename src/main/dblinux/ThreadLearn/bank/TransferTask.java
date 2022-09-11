package main.dblinux.ThreadLearn.bank;

/**
 * 转账任务类
 * @author dblinux
 * @Date 2022/6/7 15:29
 */
public class TransferTask implements TransferInterface, Runnable{
    private Account from;
    private Account to;
    private float amount;


    public TransferTask(Account from, Account to, float amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void transfer(Account from, Account to, float account) {
        from.subtractAmount(account);
        to.addAmount(account);
    }

    @Override
    public void run() {
        transfer(from, to, amount);
    }
}
