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
public class MergeSort {
    public static void main(String[] args) {
        
    }
}

class MergeSrot1 {
    public void mergeSort(Comparable[] array, int first, int last) {
        if(first < last) {
            int mid = (first + last) / 2;  // 중간값을 구한다.
            // 재귀 호출이라서, 콜스택 레벨 마지막부터 코드가 실행된다.
            // (first 1개 -> 2개 ... -> n개 배열 정렬 -> second 1개 -> 2개 ... -> n개 배열 정렬)
            //   ==> 이후 전체 정렬
            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
    }
    
    public void merge(Comparable[] array, int first, int mid, int last) {
        Comparable[] temp = new Comparable[array.length];
        int first1 = first, first2 = mid + 1;
        int last1 = mid, last2 = last;
        int index = first;
        
        while(first1 <= last1 && first2 <= last2) {
            if (array[first1].compareTo(array[first2]) < 0) {
                temp[index] = array[first1];
                first1++;
            } else {
                temp[index] = array[first2];
                first2++;
            }
            index++;
        }
        
        while(first1 <= last1) {
            temp[index] = array[first1];
            first1++;
            index++;
        }
        
        while(first2 <= last2) {
            temp[index] = array[first2];
            first2++;
            index++;
        }
        
        for(index = first; index <= last; index++) {
            array[index] = temp[index];
        }
    }
}
