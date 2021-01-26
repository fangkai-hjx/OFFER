package juc.day01.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo03 {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(11,1);
        new Thread(()->{
            final int stamp = atomicReference.getStamp();//获取 版本号
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(11, 22,
                    atomicReference.getReference(), atomicReference.getStamp() + 1));
            System.out.println("a2=>"+stamp);

            System.out.println(atomicReference.compareAndSet(22, 11,
                    atomicReference.getReference(), atomicReference.getStamp() + 1));
            System.out.println("a3=>"+stamp);
        },"a").start();

        new Thread(()->{
            final int stamp = atomicReference.getStamp();//获取 版本号
            System.out.println("b1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(11, 44,
                    stamp, stamp + 1));
            System.out.println("b2=>"+atomicReference.getStamp());

        },"b").start();
    }
}
