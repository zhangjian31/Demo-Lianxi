package test.yixia.com.testapplication.observer;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Test {
    @org.junit.Test
    public void test(){
        Observable observable =new Observable();

        Observer observer1 =new Observer("Observer1");
        Observer observer2 =new Observer("Observer2");

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.setMsg("update");
    }
}
