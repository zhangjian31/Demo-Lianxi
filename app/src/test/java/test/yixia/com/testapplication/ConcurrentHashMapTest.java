package test.yixia.com.testapplication;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangjian on 2018/5/18.
 */

public class ConcurrentHashMapTest {
    private ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    
    public void main() {
        test1();
    }

    private void test1() {
        new Thread() {
            @Override
            public void run() {
                map.put(3, "11");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                map.put(4, "22");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                map.put(7, "33");
            }
        }.start();
        System.out.println(map);
    }
}
