/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview;

/**
 *
 * @author jiseonoh
 */
public class ThreadAndLock {
    public interface Runnable {
        void run();
    }
    
    public static class RunnableThreadExample implements java.lang.Runnable{
    
        public int count = 0;

        @Override
        public void run() {
            System.out.println("RunnableThread starting.");
            try {
                while(count < 5) {
                    Thread.sleep(500);
                    count++;
                }
            } catch(InterruptedException exc) {
                System.out.println("RunnableThread interrupted.");
            }
            System.out.println("RunnableThread terminating.");
        }
    }
    
    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();
        
        /* 쓰레드 개수가 5가 될때까지 (천천히) 기다린다. */
        while(instance.count != 5) {
            try {
                thread.sleep(250);
            } catch(InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}

class MyThreadExample {
    
    public static class ThreadExample extends java.lang.Thread {
        int count = 0;
        
        public void run() {
            System.out.println("Thread starting.");
            try {
                while(count < 5) {
                    Thread.sleep(500);
                    System.out.println("In Thread, count is " + count);
                    count++;
                }
            } catch (InterruptedException exc) {
                System.out.println("Thread interrupted.");
            }
            System.out.println("Thread terminating.");
        }
    }
    
    public static void main(String args[]) {
        ThreadExample instance = new ThreadExample();
        instance.start();
        
        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }   
}

class MyClass extends Thread {
    private String name;
    private MyObject myObj;
    
    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }
    
    public void run() {
        myObj.foo(name);
    }
}

class MyObject {
    /*
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread : " + name + ".foo(): starting");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread : " + name + ": interrupted.");
        }
    }
    */
    
    public void foo(String name) {
        synchronized(this) {
            // ...
        }
    }
}

