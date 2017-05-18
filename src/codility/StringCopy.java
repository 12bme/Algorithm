/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class StringCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringCopySolution solution = new StringCopySolution();
        System.out.println(solution.solve(input));
    }
}

class StringCopySolution {
    public String solve(String input) {
        int length = input.length();
        if(input.length() <= 1) return input;
        String result = "";
        char[] inputCharacters = new char[length]; // Reverse String 용
        for(int index=0; index < length; index++){
            inputCharacters[index] = input.charAt(index);
            result += input.charAt(index);
        }
        return result;
    }
}
