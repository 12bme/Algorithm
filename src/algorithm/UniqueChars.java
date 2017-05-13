/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Scanner;

/**
 *
 * @author jiseonoh
 * 
 * 
 * 코딩 인터뷰 완전 분석 - python 문자열에 포함된 문자들이 전부 유일한 지 검사하는 알고리즘
Time Complexity: O(n)
Space Complexity: O(n)

Implement an algorithm to determine if a string has all unique characters.
What if you can not use additional data structures?

[A][B][C][D] -> PASS
[A][B][A][D] -> FAIL

질문의 순서
1) 각 캐릭터들을 한번씩 비교한다? O(N^2)
2) 더나은 방법이 있을까.. 가장 빠른 속도로 접근할 수 있는 건 무엇일까.
3) 알파벳을 히쉬에 저장하고, 해쉬의 복잡도 O(n)
4) 그래.. 더 향상시킬 수 있는 방법이 있을까
5) 일단 캐릭터는 아스키문자 (총 256자 니까) 만약 256 개보다 많다면 걔는 중복이 있는것.
 */
public class UniqueChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        executeAlgorithm(input);
    }
    public static boolean executeAlgorithm(String input) {
        if(input.length() > 128)
            return false;
        
        boolean[] charSet = new boolean[256];
        for(int i = 1; i<input.length(); i++) {
            int value = input.charAt(i);
            if(charSet[value]) return false;
            charSet[value] = true;
        }
        return true;
    }
}
