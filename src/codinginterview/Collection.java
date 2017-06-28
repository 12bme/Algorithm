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
public class Collection {
    public static void main(String[] agrs) {
        ArrayList<String> myArr = new ArrayList<String>();
        myArr.add("one");
        myArr.add("two");
        System.out.println(myArr.get(0)); // <one> 출력
        
        Vector<String> myVect = new Vector<String>();
        myVect.add("one");
        myVect.add("two");
        System.out.println(myVect.get(0));
        
        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.add("two");
        myLinkedList.addFirst("one");
        Iterator<String> iter = myLinkedList.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("one", "uno");
        map.put("two", "dos");
        System.out.println(map.get("one"));
    }
}
