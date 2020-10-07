package com.mobile.datastruct;

import androidx.annotation.Nullable;

import com.mobile.datastruct.frameWork.Singleton;

/**
 * @author: douruanliang
 * @date: 2020/9/23
 */
public class UserThreadLocal {

    public static ThreadLocal<Integer> mThreadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 10;
        }
    };
    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("name:" +Thread.currentThread().getName()+"start");
            Integer s = mThreadLocal.get();
            s = s+id;
            mThreadLocal.set(s);
            System.out.println("name:" +Thread.currentThread().getName()+"end"+
                    mThreadLocal.get());
        }
    }



    static  class JumpQueue implements Runnable{
        private Thread m;

        public JumpQueue(Thread m) {
            this.m = m;
        }

        @Override
        public void run() {
            try {
                m.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "<-----terminated");
        }
    }
    public static void main(String[] args) {

       /* new TestThread(100).run();
        Thread[] threads = new Thread[3];
        for (int i =0;i<3;i++){
            threads[i] = new Thread(new TestThread(i));
            threads[i].start();
        }*/


       // join

        Thread previous = Thread.currentThread();

        for (int i=0;i<10;i++){
            // i = 0 , main join
            // i = 1 ,  thread-1 join
            Thread thread = new Thread(new JumpQueue(previous));
            thread.start();
            previous = thread;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"terminated");

    }
}
