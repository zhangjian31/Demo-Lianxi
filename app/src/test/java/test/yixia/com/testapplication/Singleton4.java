package test.yixia.com.testapplication;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Singleton4 {
    private Singleton4() {
    }

    private static class Holder {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Holder.instance;
    }
}
