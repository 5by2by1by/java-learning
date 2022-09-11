package main.dblinux.ThreadLearn.basic;

import main.dblinux.config.Logger;

import java.util.Random;

/**
 * 第一个多线程程序
 * @author dblinux
 * @Date 2022/6/5 16:19
 */
public class RandomGenerator implements Runnable{
    private static Logger logger = Logger.getLogger(RandomGenerator.class);
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int nextInt = random.nextInt(10);
            logger.debug("" + nextInt);
        }
    }
}
