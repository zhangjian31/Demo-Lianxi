package test.yixia.com.testapplication;

import org.junit.Test;

/**
 * Created by zhangjian on 2018/5/17.
 */

public class ReverseNode {

    @Test
    public void testReserse() {
        Node node1 = new Node(null, 1);
        Node node2 = new Node(node1, 2);
        Node node3 = new Node(node2, 3);
        Node node4 = new Node(node3, 4);
        Node node5 = new Node(node4, 5);
        printNode(node5);
        printNode(reserse(node5));
    }

    public Node reserse(Node head) {
        Node newHead = null;
        Node nextNode = null;
        Node cur = head;
        while (cur != null) {
            nextNode = cur.next;
            cur.next=newHead;
            newHead= cur;
            cur = nextNode;
        }

        return newHead;
    }

    public void printNode(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
