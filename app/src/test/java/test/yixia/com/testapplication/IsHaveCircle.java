package test.yixia.com.testapplication;

import android.util.Log;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangjian on 2018/5/16.
 */

public class IsHaveCircle {


    public Node isHaveCircleAndFindWhere(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node a = head;
        Node b = head;
        while (b.next.next != null) {
            a = a.next;
            b = b.next.next;
            if (a.value == b.value) {
                Node p = head;
                Node q = a;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return q;
            }
        }

        return null;
    }

    @Test
    public void testHead() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n4;

        Node node = isHaveCircleAndFindWhere(n1);
        System.out.print("i = " + node == null ? "null" : node.value);
    }


}
