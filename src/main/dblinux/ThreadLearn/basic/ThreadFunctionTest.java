package main.dblinux.ThreadLearn.basic;

import main.dblinux.config.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dblinux
 * @Date 2022/6/6 8:45
 */
public class ThreadFunctionTest {
    private static Logger logger = Logger.getLogger(ThreadFunctionTest.class);

    public static void testSleep(){
        logger.info("thread start!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {    // 休眠过程中可以中断线程，所以要捕获中断异常
            throw new RuntimeException(e);
        }
        logger.info("thread end!");
    }

    public static void testSleepMulti(){
        new Thread(()->{
            logger.info("subThread start!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {    // 休眠过程中可以中断线程，所以要捕获中断异常
                throw new RuntimeException(e);
            }
            logger.info("subThread end!");
        }).start();

        logger.info("main start!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {    // 休眠过程中可以中断线程，所以要捕获中断异常
            throw new RuntimeException(e);
        }
        logger.info("main end!");
    }

    public static void testTimeUnit() throws InterruptedException {
        new Thread(()->{
            logger.info("subThread start!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("subThread end!");
        }).start();

        logger.info("main start!");
        TimeUnit.SECONDS.sleep(2);
        logger.info("main end!");
    }

    // 测试线程中断，主线程向新线程发起中断请求，新线程收到的话则结束运行。
    public static void testInterrupt(){
        Thread thread = new Thread(() -> {
            logger.info("sub Thread start");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    logger.info("interrupt received~");
                    logger.info("interrupt end");
                    break;
                }
            }
            logger.info("sub thread end");
        });
        thread.start();
        logger.info("main interrupt");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }


    public static void testInterruptExit(){
        Thread thread = new Thread(() -> {
            logger.info("new thread start");
            while (true) {
                if(Thread.interrupted()){
                    logger.info("善后工作");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    logger.info("i am interrupted");
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        logger.info("main interrupt");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }

    // 需求：启动t1和t2两个线程分别统计1月、2月的销售额，最后在主线程汇总。
    public static void testJoin(){
        Thread t1 = new Thread(() -> {
            logger.info("开始统计1月份数据");
            // 休眠两秒，表示在统计数据。
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("结束统计1月份数据");
        });

        Thread t2 = new Thread(() -> {
            logger.info("开始统计2月份数据");
            // 休眠两秒，表示在统计数据。
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("结束统计2月份数据");
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("开始汇总");
    }

    public static void stateTest(){
        Thread t1 = new Thread(() -> {

        }, "t1");

        Thread t2 = new Thread(() -> {
            for (; ; ) ;
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t3");

        Thread t4 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t5 = new Thread(() -> {

        }, "t5");

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        logger.info("t1状态为：" + t1.getState());
        logger.info("t2状态为：" + t2.getState());
        logger.info("t3状态为：" + t3.getState());
        logger.info("t4状态为：" + t4.getState());
        logger.info("t5状态为：" + t5.getState());
    }

    public static void testDaemon(){
        Thread t1 = new Thread(() -> {
            logger.info("测试守护线程");
        });
        t1.setDaemon(true);
        t1.start();
    }

    // 实现采集程序
    public static void spider(){
        Thread t1 = new Thread(() -> {

        });

        Thread t2 = new Thread(() -> {

        });

        t1.setDaemon(true);t2.setDaemon(true);
        t1.start(); t2.start();

    }

    Executors executors;

    public static void main(String[] args) throws InterruptedException {
        System.out.println();
    }
}
