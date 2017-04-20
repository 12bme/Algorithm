/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/**
 *
 * @author jiseonoh
 */
public class BinaryGap {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int gap = 0;
        if(binaryString.contains("1")){
            String[] binaryStringArray = binaryString.substring(binaryString.indexOf("1"), binaryString.lastIndexOf("1")).split("1");
            for(String zeroString : binaryStringArray) {
                if(gap < zeroString.length()) gap = zeroString.length();
            }
        } else {
            return gap;
        }
        return gap;
    }
}
