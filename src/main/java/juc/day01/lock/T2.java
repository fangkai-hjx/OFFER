package juc.day01.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone{
    private Lock lock = new ReentrantLock();
    public void sendSMS(){
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ------sendSMS");
            sendEmail();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
//            lock.unlock();
        }
    }
    public void sendEmail(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ++++++sendEmail");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 可重入锁
 */
public class T2 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"t1").start();

        new Thread(()->{
            phone.sendSMS();
        },"t2").start();
    }
}
