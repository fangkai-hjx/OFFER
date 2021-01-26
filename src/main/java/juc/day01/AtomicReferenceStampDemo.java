package juc.day01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带时间戳的原子引用
 */
public class AtomicReferenceStampDemo {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
       new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+atomicStampedReference.getStamp());
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
           System.out.println(Thread.currentThread().getName()+"\t第二次版本号"+atomicStampedReference.getStamp());
           atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
           System.out.println(Thread.currentThread().getName()+"\t第三次版本号"+atomicStampedReference.getStamp());
       },"t1").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);//足够t1完成ABA操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 200, stamp, stamp + 1));
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+atomicStampedReference.getStamp());
        },"t2").start();
    }
}
