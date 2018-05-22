package test.yixia.com.testapplication.observer;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Observer implements IObserver {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println(name+":"+data);
    }
}
