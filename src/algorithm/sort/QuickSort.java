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
public class QuickSort {
    public static void main(String[] agrs) {
        Integer[] inputArray = {13, 2, 2, 64, 56, 9, 56,96, 29, 41, 95, 8, 42, 66, 93};
        QuckSort1 quickSort1 = new QuckSort1();
        quickSort1.quickSort(inputArray, 0, (inputArray.length)-1);
        System.out.print("출력값 : ");
        for(Object item : inputArray) System.out.print(item + ", ");    
    }
}

/*
Quick Sort is called a Dived and Conquer algorithm since the list is divided into smaller lists as the sorting occurs.
This version is based on a recursive array based implementation which uses the memory call stack to divide the list.
Two keys to understanding to Quick Sort are:

1) Selecting the pivot value. In this very basic implementation the leftmost (lo) index is selectioned as the pivotValue.

2) Sorting the elements between lo and hi according to the pivot. In this implementation the array is divided into two sides:
a known side and an unknown side. At the beginning only the pivotIndex is in the known side.
firstUnknown begins one index after pivotIndex and incriments through the array looking for values less than the pivotValue.
If firstUnknown is less than the pivotValue (meaning it needs to be on the left side of the pivot),
the pivotIndex incriments, then firstUnknown and pivotIndex swap values.

After firstUnknown has incrimented to the end of the list pivotIndex value is placed at the lo index (bein less than the pivot)
and the pivotValue is placed in it's final resting place in the array.
Note that the pivot never gets pushed on the stack after the partition().
The general behavior is to divide the list into sublists according to a pivot, then recusively call the partition() method.
This continues until the recursion has completed and the list is sorted.

Tip : One major difference between Merge Sort and Quick Sort is in Quick Sort the sorting occurs BEFORE the elements are pushed on the stack.
In Merge Sort, the sorting occurs AFTER the elkements are popped from the stack.

Time Complexity
best time : n log(n)
average time : n log(n)
worst time : n^2
*/
class QuckSort1 {
    public void quickSort(Comparable[] array, int lo, int hi)  {
        if(lo < hi) {
            int pivot = partition(array, lo, hi);
            quickSort(array, lo, pivot - 1);
            quickSort(array, pivot + 1, hi);
        }
    }    
    private int partition(Comparable[] array, int lo, int hi){
        Comparable pivotValue = array[lo];
        int pivotIndex = lo;
        for(int firstUnknown = pivotIndex + 1; firstUnknown <= hi; firstUnknown++) {
            if(array[firstUnknown].compareTo(pivotValue) < 0) {
                pivotIndex++;
                Comparable temp = array[firstUnknown];
                array[firstUnknown] = array[pivotIndex];
                array[pivotIndex] = temp;
            }
        }
        array[lo] = array[pivotIndex];
        array[pivotIndex] = pivotValue;
        
        return pivotIndex;
    }
}
