package com.github.leetcodeapp;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author: dourl
 * @date: 2020/6/9
 */
public class MyStack<E> {

    private Object[] objects;
    private int elementCount;

    public MyStack() {
        this(10);
    }

    public MyStack(int initCapacity) {
        this.objects = new Object[initCapacity];
    }

    //push
    public E push(E element) {
        //elementCount++;
        int elementSize = objects.length;
        System.out.println("扩容前数组大小{}"+elementSize);
        if (elementCount + 1 > elementSize) {
            //扩容
            exCapacity();
        }
        objects[elementCount++] = element;
        return element;
    }

    private void exCapacity() {
       int newCapacity = elementCount * 2;
       /* Object[] newObjects = new Object[elementCount];
        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = objects[i];
        }*/
        objects = Arrays.copyOf(objects,newCapacity);
    }
    //pop
    public E pop() {
        if (elementCount <= 0)
            throw new EmptyStackException();
        E e = (E) objects[--elementCount];
        objects[elementCount] = null;
        return e;

    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);

        myStack.push(100);
        myStack.push(200);
        myStack.push(300);
        myStack.push(400);


        myStack.push(1000);
        myStack.push(2000);
        myStack.push(3000);
        myStack.push(4000);


        while (myStack.size() > 0) {

            System.out.println(myStack.pop());
        }


    }

    private int size() {

        return elementCount;
    }
}
