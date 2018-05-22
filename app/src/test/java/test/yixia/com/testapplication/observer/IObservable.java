package test.yixia.com.testapplication.observer;

/**
 * Created by zhangjian on 2018/5/21.
 */

public interface IObservable {
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public  void notiftUpdate();
}
