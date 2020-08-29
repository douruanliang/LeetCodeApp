package com.mobile.datastruct.node

import com.mobile.datastruct.LNode

/**

@author: douruanliang
@date: 2020/8/29
 */

/**
 * 找到中间节点
 */
private fun findMiddleNode(head:LNode?):LNode?{
    if (head?.next ==null) return head

    var fast:LNode? = head;
    var slow:LNode? = head;
    var showPre:LNode? = head; //记录新的分界点

    while (fast!=null && fast.next!=null) {
        showPre = slow;
        slow = slow?.next;
        fast = fast.next?.next;
    }
     // 把列表断开
    showPre?.next == null;
    return slow;
}

/**
 *单列表反转
 */
private fun reverse(head: LNode?):LNode?{
    if (head?.next ==null) return head

    var pre:LNode = head //前驱
    var cur = head.next; //当前
    var next:LNode ? //后继
    pre.next = null

    while (cur!=null){
        next = cur.next
        cur.next = pre
        pre = cur
        cur =  next
    }
    return pre
}

/**
 * 对列表进行排序
 *  cur1         cur2
 *  1-2-3-4 ,    8-7-6-5
 */
private fun reorder(head: LNode?){
    if (head?.next ==null) return ;
    //前半部分列表第一个节点
    var cur1:LNode? = head.next;
    val mid = findMiddleNode(head.next)
    // 后半部分链表逆序后的第一个节点
    var cur2= reverse(mid);
    var temp:LNode? // 新的节点
    //开始合并
    while (cur1?.next!=null){
        temp = cur1.next   // 保留原先的 2  3
        cur1.next = cur2   // 指向新的头 8// 1->8  3 ->6
        cur1 = temp    //2    下移  4

        temp = cur2?.next //7 6
        cur2?.next = cur1  // 7->2 5 ->4
        cur2 = temp;  // 移动到你下一个 7  6
    }

    cur1?.next = cur2

}