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
public class Queue {
    private class Node {
        private Object data;
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString() {
            return String.valueOf(data);
        }
    }
    
    Node first, last;
    
    public void enqueue(Object item) {
        if(null != first) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }
    
    public Object dequeue(Node n) {
        if(null != first) {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
