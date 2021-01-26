package juc.day01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile CAS atomicInteger  BlockingQueue 线程交互 原子引用
 */
class MyResource {
    private volatile boolean FLAG = true;//默认开启 进行生产和消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    public BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduce() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t停止生产");
    }
    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t超过两秒钟没有取到蛋糕，消费退出！");
                System.out.println();
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
            System.out.println();
            System.out.println();
        }
    }
    public void stop(){
        this.FLAG = false;
    }
}

public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProduce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Produced").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5s时间到===============================");
        myResource.stop();
    }
}
