package main.dblinux.origin;

import main.dblinux.config.Logger;

/**
 * @author dblinux
 * @Date 2022/6/5 20:56
 */

public class ThreadFirst {
    private static Logger logger = Logger.getLogger(ThreadFirst.class);

    public static void main(String[] args) {
//        logger.debug("调试信息");
//        logger.warn("警告信息");
//        logger.info("普通信息");
//        logger.debug("启动多个线程执行多任务");
        test1();
    }

    //启动一个线程执行一个任务
    public static void test1() {
        //创建任务对象
        RandomGenerator randomGenerator = new RandomGenerator();
        //创建thread对象
        Thread thread = new Thread(randomGenerator);
        //启动线程
        thread.start();
    }

    //启动多个线程执行多个任务
    public static void test1_1() {
        //创建任务对象
        RandomGenerator randomGenerator = new RandomGenerator();
        //创建t1对象
        Thread t1 = new Thread(randomGenerator);
        //创建t2对象
        Thread t2 = new Thread(randomGenerator);
        //启动线程
        t1.start();
        t2.start();
    }
}