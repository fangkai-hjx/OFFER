package juc.day01.queue;

import java.util.concurrent.*;

public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                blockQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockQueue.put("3");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take "+blockQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take "+blockQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t take "+blockQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
    }
}
