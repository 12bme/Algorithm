/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jiseonoh
 */
public class LockedATM {
    private Lock lock;
    private int balance = 100;
    
    public LockedATM() {
        lock = new ReentrantLock();
    }
    
    public int withdraw(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
        } catch(InterruptedException e) {}
        
        lock.unlock();
        return temp;
    }
    
    public int deposit(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(300);
            balance = temp;
        } catch (InterruptedException e) { }
        
        lock.unlock();
        return temp;
    }
}
