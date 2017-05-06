/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;
import java.util.*;
import java.io.*;

/**
 *
 * @author jiseonoh
 */
public class P1764 {
    public static void main(String args[]) throws IOException {
    }
    
    public static void treemapSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        TreeMap<String, Integer> d = new TreeMap<String, Integer>();
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            d.put(name, 1);
        }
        for(int i=0; i<m; i++) {
            String name = br.readLine();
            Integer v = d.get(name);
            if (v == null) v = 0;
            v += 2;
            d.put(name, v);
        }
        ArrayList<String> a = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : d.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 3) a.add(key);
        }
        System.out.println(a.size());
        for(String name : a) {
            System.out.println(name);
        }
    }
    
    public static void hashmapSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        HashMap<String, Integer> d = new HashMap<String, Integer>();
        for (int i=0; i<n; i++) {
            String name = br.readLine();
            d.put(name, 1);
        }
        for (int i=0; i<m; i++) {
            String name = br.readLine();
            Integer v = d.get(name);
            if(v == null) v =0;
            v += 2;
            d.put(name, v);
        }
        ArrayList<String> a = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : d.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value == 3) a.add(key);
        }
        System.out.println(a.size());
        Collections.sort(a);
        for(String name : a) {
            System.out.println(name);
        }
    }
}
