/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort;
import java.util.*;

/**
 *
 * @author jiseonoh
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] inputArray = {13, 2, 2, 64, 56, 9, 56,96, 29, 41, 95, 8, 42, 66, 93};
        MergeSrot1 mergeSort1 = new MergeSrot1();
        mergeSort1.mergeSort(inputArray, 0, (inputArray.length)-1);
        System.out.print("출력값 : ");
        for(Object item : inputArray) System.out.print(item + ", ");    
        //executer();
    }
    
    public static void executer() {
      
        do {
            System.out.println(",로 구분하여 정렬하고싶은 값을 입력해주세요");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            System.out.println("입력값 : " + input);
            Comparable[] inputArray = input.split(",");
            MergeSrot1 mergeSort1 = new MergeSrot1();
            mergeSort1.mergeSort(inputArray, 0, (inputArray.length)-1);
            System.out.print("출력값 : ");
            for(Object item : inputArray) System.out.print(item + ", ");    
            System.out.println("\n계속 진행하시겠습니까?");
            if(!sc.nextLine().startsWith("y")) break;
            
        } while(true);
    }
}

/*
Merge Sort is called a Divide and Conquer algorithm since the list is divided into sublists as the sorting occurs.
This recursive array based implemestation uses the memory call stack to divide the list. (메모리 콜스택을 사용)

The behavior in MergeSort() is as follows: The list is divided in half (if an there's an odd number of elements, the left hand side is the larger side).
The halves are pushed onto the stack based on mergeSort()'s recursive call sequence, effectively making sublists.
As base cases are hit and the left and right sublists are popped from the stack the merge() method is called which sorts the popped sublists.
This recursive behavior of dividing the list into sublists, then merging and sorting the sublists continues until the recursion has completed and the lists is sorted.

Tip: One major difference between Merge Sort and Quick Sort is with Merge Sort the sorting occurs AFTER the the elements are popped from the stack.
In Quck Sort the sorting occurs BEFORE the elements are pushed on the stack.

Time Complexity
best time: n log(n)
average time: n log(n)
worst time: n log(n)
*/
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
