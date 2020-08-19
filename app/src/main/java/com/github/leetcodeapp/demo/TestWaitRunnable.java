package com.github.leetcodeapp.demo;

/**
 * @author: dourl
 * @date: 2020/7/7
 */
public class TestWaitRunnable implements Runnable {

    private final Object obj = new Object();
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        //逻辑快
        TestWaitRunnable waitRunnable = new TestWaitRunnable();
        //子线程 1
        Thread runThread = new Thread(waitRunnable);
        System.out.println("子线程 1");
        runThread.start();
        try {
            //
            System.out.println("主线程 sleep 2 秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程 继续？");
        waitRunnable.setFlag(false);
        //子线程 2
        Thread notifyThread = new Thread(waitRunnable);
        System.out.println("子线程 2");
        notifyThread.start();
    }

    @Override
    public void run() {
        System.out.println("当前线程的名字："+ Thread.currentThread().getName());
        if (flag) {
            testWait();
        } else {
            testNotify();
        }
    }

    private void testNotify() {

        synchronized (obj) {
            try {
                System.out.println("1 秒后 发送通知");
                Thread.sleep(1000);
                obj.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void testWait() {
        synchronized (obj) {
            try {
                System.out.println("线程在同步代码快中执行 0 - 进入等待");
                //线程执行搭配 wait()后一致在等待，不会执行后年的代码
                obj.wait();
                System.out.println("线程在同步代码快中执行 1 - 继续执行");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程在同步代码快中执行 结束");
        }
    }
}
