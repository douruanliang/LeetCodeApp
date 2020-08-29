package com.mobile.datastruct.node

import com.mobile.datastruct.LNode

/**

@author: douruanliang
@date: 2020/8/28
 单链表
 */
class SingleNode {

}

/**
 * 就地逆序
 *
 * 以上这种方法只需要对链表进行一次遍历，
 * 因此，时间复杂度为O（N），
 * 其中，N为链表的长度。
 * 但是需要常数个额外的变量来保存当前结点的前驱结点与后继结点，因此，空间复杂度为O（1）
 */
fun reverse(head:LNode){

    if(head.next == null){
        return
    }
    var pre:LNode? //前驱节点
    var cur:LNode? //当前节点
    var next:LNode? //后继节点

    cur = head.next
    next = cur?.next
    cur?.next =null

    pre = cur
    cur = next

    while (cur?.next!=null){
        next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }

    cur?.next = pre
    head.next =cur

}
fun main(args :Array<String>){
    println("单列表反转")
    var i =0;
    var head = LNode();
    head.next =null;

    var temp:LNode?
    var cur:LNode? = head;

    while (i<8){
        temp = LNode() //新节点
        temp.data =i;
        temp.next = null;

        cur?.next = temp; //当前的下一个节点指向 新节点
        cur =temp //当前变为新节点
        i++       //下移游标
    }
    // 以上是构建一个链表
    println("逆序前\n")
    cur = head.next

    while (cur?.next!=null){
        print("${cur.data}")
        cur = cur.next
    }
    println("\n逆序后")
    reverse(head)
    cur = head.next
    while (cur?.next!=null){
        print("${cur.data}")
        cur = cur.next
    }
}


/**
 * 方法二：递归法
 */

/**
 * 方法二：插入法
 * 插入法的主要思路：从链表的第二个结点开始，把遍历到的结点插入到头结点的后面,直到遍历结束。
 * 假定原链表为head-＞1-＞2-＞3-＞4-＞5-＞6-＞7，
 *  在遍历到2的时候，将其插入到头结点后，
 *    链表变为head-＞2-＞1-＞3-＞4-＞5-＞6-＞7，
 *    同理将后序遍历到的所有结点都插入到头结点head后，就可以实现链表的逆序。
 */

fun reverse3(head: LNode){

    if(head.next == null){
        return
    }
    var cur:LNode? //当前节点
    var next:LNode? //后继节点 （临时变量）
    cur = head.next?.next  // 从第二个节点开始   2
    head.next?.next = null // 第一个节点为为节点  1

    while (cur!=null){ //2 、3、5
        next = cur.next;   // 3 、4 、6
        cur.next = head.next  // 3-->1 4-->2  6-4
        head.next= next;  // head-->3  head-->4  -6
        cur = next      // 3 ,5
    }

}