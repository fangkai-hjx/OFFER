package juc.day01;

/**
 * 单例模式
 */
public class SinletonDmeo {
    private static SinletonDmeo instance = null;

    //单例模式就是不允许别人构造对象，所以把构造函数设成private的。
    private SinletonDmeo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法！");
    }

    public static SinletonDmeo getInstance() {
        if (instance == null) {
            instance = new SinletonDmeo();
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程（main线程的操作。。。）
//        System.out.println(SinletonDmeo.getInstance() == SinletonDmeo.getInstance());
//        System.out.println(SinletonDmeo.getInstance() == SinletonDmeo.getInstance());
//        System.out.println(SinletonDmeo.getInstance() == SinletonDmeo.getInstance());
//        System.out.println();
//        System.out.println();
//        System.out.println();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SinletonDmeo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
