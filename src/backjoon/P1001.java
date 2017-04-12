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
public class P1001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int firstInteger = scan.nextInt();
        int secondInteger = scan.nextInt();
        
        System.out.println(firstInteger - secondInteger);
    }
}
