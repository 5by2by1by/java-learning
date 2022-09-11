package main.dblinux.ThreadLearn.bank;

import main.dblinux.config.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dblinux
 * @Date 2022/6/7 15:34
 */
public class TransferTest {
    private static Logger logger = Logger.getLogger(TransferTest.class);

    static Account from = new Account("01", "dbl", 1000);
    static Account to = new Account("02", "xlb", 1000);

    public static void test1(){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new TransferTask(from, to, 10));
        }
        threadPool.shutdown();
        logger.debug("原账户" + from.getBalance());
        logger.debug("目标账户" + to.getBalance());
    }

    public static void main(String[] args) {
        test1();
    }
}
