package main.dblinux.ThreadLearn.bank;

/**
 * @author dblinux
 * @Date 2022/6/7 15:21
 */
public interface TransferInterface {
    /**
     *
     * @param from 原账户
     * @param to  目标账户
     * @param account 转账金额
     */
    void transfer(Account from, Account to, float account);
}
