package com.mobile.datastruct.node

import com.mobile.datastruct.LNode

/**

@author: douruanliang
@date: 2020/8/28
给定一个没有排序的链表，去掉其重复项，并保留原顺序，
例如链表1-＞3-＞1-＞5-＞5-＞7，
去掉重复项后变为1-＞3-＞5-＞7。
 */

fun removeDupRecursion(head: LNode): LNode {

    if (head.next == null) return head;
    var pointer: LNode?
    var cur: LNode? = head;

    head.next = removeDupRecursion(head.next!!);

    pointer = head.next

    while (pointer != null) {
        if (head.data == pointer.data) {
            cur!!.next = pointer.next
            pointer = cur.next
        } else {
            pointer = pointer.next
            cur = cur!!.next
        }
    }
    return head;
}

fun main() {

}