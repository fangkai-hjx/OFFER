package juc.day01.lock;

import juc.day01.CountryEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.foreach_CountryEnum(i).getCountry()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t****秦一统天下！");
    }
    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习,离开教室！");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();//必须达到0才可以唤醒
        System.out.println(Thread.currentThread().getName() + "\t*******班长最后关门走人");
    }
}
