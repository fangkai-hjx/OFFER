package juc.day01.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T1 {
    volatile  int n = 0;
    public void  add(){
        n++;
    }

    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();//默认非公平锁
        Lock lock = new ReentrantLock(true);//公平锁

    }
}
