package test.yixia.com.testapplication;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }
}