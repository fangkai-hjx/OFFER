package juc.day01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加一个减，来五轮
 * 线程操作资源类
 * 判断 干活 唤醒 ---》严防多线程环境下的虚假唤醒
 */
class Resource{
    private int num=0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add(){
        lock.lock();
        try {
            //判断
            while (num != 0){//等待 不能生产
                condition.await();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //通知唤醒
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void sub(){
        lock.lock();
        try {
            while (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ProdConsumer_Tradition {
    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                resource.add();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                resource.sub();
            }
        },"BBB").start();
    }
}
