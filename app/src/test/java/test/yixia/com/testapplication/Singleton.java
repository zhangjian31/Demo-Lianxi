package test.yixia.com.testapplication;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){
    }
    public static Singleton getInstance(){
        return instance;
    }

}
