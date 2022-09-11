package main.dblinux.origin;

import main.dblinux.config.Logger;

import java.util.Random;

/**
 * @author dblinux
 * @Date 2022/6/5 20:57
 */

public class RandomGenerator implements Runnable {
    private static Logger logger = Logger.getLogger(RandomGenerator.class);
    @Override
    public void run() {
        //生成10个随机数
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(10);
            logger.debug("生成随机数:"+nextInt);
        }
    }
}