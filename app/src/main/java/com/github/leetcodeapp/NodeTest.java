package com.github.leetcodeapp;

/**
 * @author: dourl
 * @date: 2020/6/9
 */
public class NodeTest {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head.next = node2;

        node2.next = node3;

        node3.next = node4;
        //reverse(head);
        recursion_display(5);


    }

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    static int i = 0;

    public static Node reverse(Node head) {

        if (head == null || head.next == null) return head;
        System.out.println("reverse ---- before" + i);

        Node temp = head.next;
        Node neeHead = reverse(head.next);
        System.out.println("reverse ---- after" + i);
        i++;
        temp.next = head;
        head.next = null;
        return neeHead;
    }


    /*
 关于 递归中 递进和回归的理解*/
    public static void recursion_display(int n) {
        int temp = n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("回归:" + temp);
    }
}





