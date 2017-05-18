package codility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int[] myIntArray = {};
        PermMissingElemSolution mySolution = new PermMissingElemSolution();
        System.out.println(mySolution.solution(myIntArray));
    }
}

class PermMissingElemSolution {
    public int solution(int[] A) {
        if(null == A) return 1; 
        
        int length = A.length;
        if(length == 0) return length;
        
        ArrayList<String> tempList = new ArrayList<>();
        for(int number = 1; number <= length+1; number++) tempList.add(Integer.toString(number));
        for(int index = 0; index < length; index++) tempList.remove(Integer.toString(A[index]));
        return Integer.parseInt(tempList.get(0));
    }
}
