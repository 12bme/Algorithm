/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview;

import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class Testing {
    public void testAddThreeSorted() {
        MyList<Integer> list = new MyList<Integer>();
        list.addThreeSorted(3, 1, 2);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 2);
        assertEquals(list.get(2), 3);
    }
    
    public class MyList<T> extends ArrayList<T> {
        public void addThreeSorted(T item1, T item2, T item3) {
            this.add(item1);
            this.add(item2);
            this.add(item3);
        }
    }
    
    private boolean assertEquals(Object e1, Object e2) {
        return e1.equals(e2);
    }
}
