package juc.day01.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    //写操作
    public void put(String key, Object value) {
        final ReentrantReadWriteLock.WriteLock writeLock = rwlock.writeLock();
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入:" + key);
            TimeUnit.SECONDS.sleep(1);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }

    }

    //读操作
    public void get(String key) {
        final ReentrantReadWriteLock.ReadLock readLock = rwlock.readLock();
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读取");
            TimeUnit.SECONDS.sleep(1);
            final Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成:" + result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
}

public class ReadAndWriteLock {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, "a" + String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, "b" + String.valueOf(i)).start();
        }
    }
}
