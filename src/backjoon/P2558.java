/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;
import java.util.Scanner;

/**
 *
 * @author jiseonoh
 */
public class P2558 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int firstInteger;
        int secondInteger;
        while(true){
            firstInteger = sc.nextInt();
            if(firstInteger > 0) break;
        }
        while(true){
            secondInteger = sc.nextInt();
            if(secondInteger < 10) break;
        }
        System.out.println(firstInteger+secondInteger);
    }
}
