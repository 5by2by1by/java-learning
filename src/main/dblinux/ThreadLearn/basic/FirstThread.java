package main.dblinux.ThreadLearn.basic;

import main.dblinux.config.Logger;

/**
 * @author dblinux
 * @Date 2022/6/5 12:22
 */
public class FirstThread {
    private static Logger logger = Logger.getLogger(FirstThread.class);
    public static void main(String[] args) {
        logger.info("主线程");
        TaskCreate();
    }

    //创建线程，以执行任务
    public static void testMulti(){
        // 创建任务对象
        RandomGenerator randomGenerator = new RandomGenerator();
        // 创建线程对象
        Thread t1 = new Thread(randomGenerator);
        Thread t2 = new Thread(randomGenerator);
        // 启动线程
        t1.start();
        t2.start();
    }

    static class task1 implements Runnable{

        @Override
        public void run() {
            logger.info("执行任务1");
        }
    }

    static class task3 extends Thread{
        @Override
        public void run() {
            logger.info("执行任务3");
        }
    }
    public static void TaskCreate(){
        // 创建任务对象的四种方式
        // 1. 实现Runnable接口
        new Thread(new task1(), "t1").start();
        // 2. 使用Lambda表达式实现
        Runnable task2 = ()->{
            logger.debug("task2");
        };
        new Thread( task2, "t2").start();

        new Thread(()->{
            logger.info("执行任务2");
        }, "t2").start();

        // 3. 继承Thread类
        new Thread(new task3(), "t3").start();

        // 4. 内部类
        new Thread(new Thread(){
            @Override
            public void run() {
                logger.debug("t4");
            }
        }, "t4").start();
    }


}