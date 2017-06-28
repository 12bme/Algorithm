/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.datastructure;

/**
 *
 * @author jiseonoh
 */
public class Stack {
    private class Node {
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node top;
    
    public Object pop() {
        if(top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }
    
    public void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }
    
    Node peek() {
        return top;
    }
}


