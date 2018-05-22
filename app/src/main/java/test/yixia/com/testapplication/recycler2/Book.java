package test.yixia.com.testapplication.recycler2;

/**
 * Created by zhangjian on 2018/5/22.
 */

public class Book {
    int type;//1-text 2-image
    String name;
    int resId;

    @Override
    public String toString() {
        return "Book{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", resId=" + resId +
                '}';
    }
}
