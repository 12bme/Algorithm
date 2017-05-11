/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;

import java.math.*;
import java.util.*;

/**
 * 문제) 실수 a와 정수 b가 주어졌을때, a의 b제곱을 정확하게 계산하는 프로그램을 작성하시오.
 * 
 * 입력) 첫째 줄에 a와 b가 주어진다. (0<a<100, 1<=b<=100) a는 최대 소수점 9자리이며, 소수가 0으로 끝나느 경우는 없습니다.
 * 출력) 첫째 출에 a의  b제곱을 출력합니다.
 * 
 * 
 * @author jiseonoh
 */
public class P10827 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // BigInteger와 비슷하지만 정확한 실수연산을 하는 자료형
        BigDecimal a = sc.nextBigDecimal();
        int b = sc.nextInt();
        
        BigDecimal c = a.pow(b);
        // 출력할때 c.toString()은 정확한 값이 나오지 않으므로, toPlainString 메소드를 써야함.
        System.out.println(c.toPlainString());
    }
}
