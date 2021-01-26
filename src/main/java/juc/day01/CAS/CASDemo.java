package juc.day01.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        //狸猫换太子
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.compareAndSet(10, 12);
        atomicInteger.compareAndSet(12, 10);

        atomicInteger.compareAndSet(10, 22);

        System.out.printf(String.valueOf(atomicInteger.get()));
    }
}
