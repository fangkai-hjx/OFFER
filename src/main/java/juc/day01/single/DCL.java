package juc.day01.single;

public class DCL {
    private static DCL dcl = null;
    private DCL() {//私有构造函数，外部访问不了
    }
    private static DCL getInstance() {
        if (dcl == null) {//第一次验校
            synchronized (DCL.class) {//同步代码块（类锁）
                if (dcl == null) {//第二次验校
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }
}
