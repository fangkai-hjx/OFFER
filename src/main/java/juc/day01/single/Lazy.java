package juc.day01.single;

/**
 * 懒汉模式
 */
public class Lazy {
    private static Lazy lazy = null;
    private Lazy() {
    }
    private static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
