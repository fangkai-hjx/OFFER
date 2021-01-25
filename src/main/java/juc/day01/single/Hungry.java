package juc.day01.single;

/**
 * 饿汉示
 */
public class Hungry {
    //可能会浪费空间
    private byte[]bytes1 = new byte[1024];
    private byte[]bytes2 = new byte[1024];
    private byte[]bytes3 = new byte[1024];
    private byte[]bytes4 = new byte[1024];
    private Hungry() {
    }
    private final static Hungry hungry = new Hungry();
    public static Hungry getInstance() {
        return hungry;
    }
}
