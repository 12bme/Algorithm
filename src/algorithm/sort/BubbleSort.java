/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort;

/**
 *
 * @author jiseonoh
 */
public class BubbleSort {
    /*
    1. 인접한 두 인덱스를 비교해서 정렬이 되어있지 않을 경우 정렬한다.
    2. 리스트 처음부터 끝까지 이런식의 정렬을 하고 나면 제일 마지막 리ㅏ스트에는 제일 큰 값(또는 작은 값)이 저장된다.
    3. 다시 처음 리스트부터 마지막 리스트 이전 리스트까지 서로 이웃한 인덱스를 비교해가며 정렬한다.
    4. 위 방법으로 계속해서 정렬한다.
    */
    public static void main(String[] args) {
        int[] index = {8,4,7,3,1,6,5,2};
        int i, j, temp;
        
        for(i = 0; i < index.length - 1; i++) {
            for(j = 0; j < index.length - 1 - i; j++) {
                if(index[j] > index[j+1]) {
                    temp = index[j];
                    index[j] = index[j+1];
                    index[j+1] = temp;
                }
            }
        }
        
        for(i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }
    }
}
