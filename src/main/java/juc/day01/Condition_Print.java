package juc.day01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间按顺序调用，实现A->B->C 三个线程启动，要求如下
 * AA 打印 5 次，BB打印10次，CC打印15次
 * 紧接着
 * AA 打印 5 次，BB打印10次，CC打印15次
 * 来 10 轮
 */
class Hello{
    private int number =1;//A1  B2  C3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while (number != 1){
                c1.await();//会释放锁，其他线程执行Condition.signal()，之前的线程会重新获得锁，继续执行，
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            number =2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while (number != 2){
                c2.await();//会释放锁，其他线程执行Condition.signal()，之前的线程会重新获得锁，继续执行，
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            number =3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while (number != 3){
                c3.await();//会释放锁，其他线程执行Condition.signal()，之前的线程会重新获得锁，继续执行，
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            number =1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class Condition_Print {
    public static void main(String[] args) {
        final Hello hello = new Hello();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                hello.print5();
            }
        },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                hello.print10();
            }
        },"BBB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                hello.print15();
            }
        },"CCC").start();
    }
}
