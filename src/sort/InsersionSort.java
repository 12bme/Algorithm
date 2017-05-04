/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author jiseonoh
 */
class InsersionSortMain {
    
    public static void main(String[] agrs) {
        Integer[] arr = {10, 2, 6, 4, 3, 7, 5};
        InsersionSort1 sort1 = new InsersionSort1();
        sort1.insersionSort(arr);
        
        InsersionSort2 sort2 = new InsersionSort2();
        sort2.insersionSort();
    }
}

/*
Brief Explanation
- The list is always divided into 2 sides: a sorted left-hand side and an unsorted right-hand side.
- The first value in the unsorted side (aka firstUnsorted) gets assigned to itemToInsert.

shifter's job is to fined to location to put itemToInsert.
shifter shifts all the values that are greater than the itemToInsert onew index to their right.
Then itemToInsert is placed in sorted order on the sorted side of the list.
The sorted side just became one element larget and the unsorted side is one element smaller.
This process continues until firstUnsorted has iterated to the end of the list.

Time Complexity
- best time: n
- average time: n^2
- worst time: n^2
*/
class InsersionSort1 {
    int firstUnsorted, shifter;
    Comparable itemToInsert;
    
    public void insersionSort(Comparable[] array) {
        
        for(firstUnsorted = 1; firstUnsorted < array.length; firstUnsorted++) {
            itemToInsert = array[firstUnsorted];
            shifter = firstUnsorted;
            while(shifter < 0 && itemToInsert.compareTo(array[shifter - 1]) < 0) {
                array[shifter] = array[shifter - 1];
                shifter--;
            }
            array[shifter] = itemToInsert; // 기준의 최종 위치.
        }

    }   
}

class InsersionSort2 {
    int[] arr = {10, 2, 6, 4, 3, 7, 5};
    public void insersionSort() {
        for(int i = 1; i < arr.length; i++) {
            int standard = arr[i];          // 기준
            int aux = i - 1;                // 비교할 대상
            
            while(aux >= 0 && standard < arr[aux]) {
                arr[aux + 1] = arr[aux];    // 비교대상이 큰 경우 오른쪽으로 밀어냄
                aux--;
            }
            arr[aux+1] = standard;          // 기준값 저장
        }
        printArr(arr);
    }
    public void printArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
    }
}