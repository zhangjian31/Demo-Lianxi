package test.yixia.com.testapplication.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2018/5/21.
 */

public class Observable implements IObservable {
    private List<IObserver> list;
    private String msg;

    public Observable() {
        list = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notiftUpdate() {
        if (list == null)
            return;
        for (int i = 0; i < list.size(); i++) {
            IObserver o = list.get(i);
            o.update(msg);
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notiftUpdate();
    }

    public String getMsg() {
        return msg;
    }
}
