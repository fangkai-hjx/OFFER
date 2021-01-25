package juc.day01;


import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Mydata {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();//带原子性的i++

    public void add() {
        this.number = 60;
    }

    public void addPlus() {
        //亲注意：number前面加了volatile修饰，不保证原子性
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

public class Volatile01 {
    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    mydata.addPlus();
                    mydata.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待前面20个线程是否全部完成
        while (Thread.activeCount() > 2) {//main gc线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally int number value: " + mydata.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomicIntegert number value: " + mydata.atomicInteger);
    }

    //使用Volatile保证原子性，及时通知其他线程主物理内存的值以及改变
    private static void seeOKByVolatile() {
        Mydata mydata = new Mydata();//资源类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.add();
            System.out.println(Thread.currentThread().getName() + "\t update value " + mydata.number);
        }, "AAA").start();
        //第二个线程 main
        while (mydata.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

    public void mySort() {
        int x = 11;//语句1
        int y = 12;//语句2
        x = x + 5;//语句3
        y = x * x;//语句4
    }
}
