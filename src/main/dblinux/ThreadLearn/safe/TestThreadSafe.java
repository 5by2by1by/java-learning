package main.dblinux.ThreadLearn.safe;

import main.dblinux.config.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dblinux
 * @Date 2022/6/7 9:25
 */
public class TestThreadSafe {
    private static Logger logger = Logger.getLogger(TestThreadSafe.class);
    static Object lock = new Object();
    static int sum = 0;
    public static void testSafe(){
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            pool.execute(()->{
                synchronized (lock){
                    sum++;
                }
            });
        }
        pool.shutdown();
        logger.debug("sum = " + sum);
    }

    public static void main(String[] args) {
        testSafe();
    }
}
