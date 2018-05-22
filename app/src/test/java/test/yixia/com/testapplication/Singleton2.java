package test.yixia.com.testapplication;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                instance = new Singleton2();
            }
        }
        return instance;
    }

}
