package main.dblinux.ThreadLearn.basic;

import main.dblinux.config.Logger;

import java.util.concurrent.*;

/**
 * @author dblinux
 * @Date 2022/6/6 14:42
 */
public class ExecutorsTest {
    private static Logger logger = Logger.getLogger(ExecutorsTest.class);

    public static void testExecutor(){
        // 创建一个线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 向线程池提交任务
        for (int i = 0; i < 3; i++) {
            cachedThreadPool.execute(()->{
                logger.info("i");
            });
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void testThreadPoolExecutors(){
        // 创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 20,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 提交8个任务
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolExecutor.execute(()->{
                logger.info("执行任务" + finalI);
            });
            // 休眠1秒，给核心线程足够休眠时间，避免开启辅助线程。
        }
    }

    public static void testNonBlockingAndBlocking(){
        // 定义一个阻塞队列
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                arrayBlockingQueue.put("dblinux");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        // 调用阻塞方法
        try {
            logger.debug("调用阻塞方法...");
            String res1 = arrayBlockingQueue.take();
            logger.debug("非阻塞方法结果：" + res1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testThreadFactory(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                // 特殊要求：将线程工厂中的线程设置为守护线程。
                thread.setDaemon(true);
                return thread;
            }
        });

        fixedThreadPool.execute(()->{
            while(true){
                logger.debug("执行任务...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 确定线程为守护线程？ 主线程休眠3s后退出，那么守护线程肯定也结束打印。
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("任务结束");
    }

    public static void main(String[] args) {
        testThreadFactory();
    }
}
