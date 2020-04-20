package com.architect.thread02_model.save;

class ThreadDemo01 implements Runnable {
    // 同时多个线程共享100
    private int count = 100;
    private Object object = new Object();
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (count > 0) {
            save();
        }
    }

    public void save1() {
        synchronized (object) {

        }
    }

    public synchronized void save() {
        if(count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售" + (100 - count +1) + "张票");
            count--;
        }
    }
}


public class ThreadSave {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        Thread t1 = new Thread(threadDemo01, "窗口1");
        Thread t2 = new Thread(threadDemo01, "窗口2");
        t1.start();
        t2.start();
    }
}
