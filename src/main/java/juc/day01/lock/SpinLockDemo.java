package juc.day01.lock;

import spring.xunhuangyilai.A;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    //原子应用<线程>
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void  myLock(){
        Thread thread =Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(thread.getName()+"\t waitting");
        }
        System.out.println(Thread.currentThread().getName()+"\t come in+++++++++++");
    }
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t come out----------");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }).start();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }).start();
    }
}
