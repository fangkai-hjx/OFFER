package juc.day01.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);//模拟3个停车位
        for (int i = 0; i < 6; i++) {//模拟六部汽车
            new Thread(()->{
                try {
                    semaphore.acquire();// -1
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);//停车3秒
                    System.out.println(Thread.currentThread().getName()+"\t停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();// +1
                }
            },String.valueOf(i)).start();
        }
    }
}
