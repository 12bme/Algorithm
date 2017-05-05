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
public class SelectionSort {
    public static void main(String[] agrs) {
        Integer[] arr = {10, 2, 6, 4, 3, 7, 5};
        SelectionSort1 sort1 = new SelectionSort1();
        sort1.selectionSort(arr);
        
        int[] arr2 = {10, 2, 6, 4, 3, 7, 5};
        SelectionSort2 sort2 = new SelectionSort2();
        sort2.selectionSort(arr2);
    }
}


/*
Brief Explanation
- start begins at the front of the list and cur begins at the index ahead of start.
- cur then iterates to the end of the list looking for the smallest value.
- Once cur reaches the end of the list, start and smallest swap values.

Time Complexity
- best time: n^2
- average time: n^2
- worst time: n^2
*/
class SelectionSort1 {
    public void selectionSort(Comparable[] array) {
        // 변수는 이런식으로 잡는게 더 좋을까.
        int start, smallest, cur;
        Comparable temp;
        
        for(start = 0; start < array.length-1; start++) {
            smallest = start;
            for(cur = start + 1; cur < array.length; cur++) {
                if(array[cur].compareTo(array[smallest]) < 0)
                    smallest = cur;
            }
            temp = array[start];
            array[start] = array[smallest];
            array[smallest] = temp;
        }
    }
}

/*
선택정렬의 연산시간
- 연산시간 공식 : O(n^2) = n(n-1) - (n-1)/2 = n(n-1)/2

선택정렬의 장점
- 데이터의 양이 적을 때, 아주 좋은 성능을 나타낸다.
- 작은 값을 선택하기 위해서 비교는 여러번 하지만 교환횟수가 작다

선택정렬의 단점
- 가장 작은 값과 현재값을 교환하는 방식이라 현재값이 뒤쪽의 어디로 갈지 알수 없으므로 안전성이 없다.
- 100개 이상의 자료에 대해서는 속도가 급격히 떨어져서 적절히 사용되기가 힘들다.
*/
class SelectionSort2 {
    public void selectionSort(int[] arr) {
        int size = arr.length;
        int min;    // 최솟값을 가진 데이터의 인덱스 저장 변수
        int temp;
        
        for(int i = 0; i < size-1; i++) { // size - 1 : 마지막 요소는 자연스럽게 정렬됨
            min = i;
            for(int j = i+1; j < size; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

// 공간복잡도는 O(n)으로
class SelectionSort3 {
    public void selectionSort(int[] array) {
        
    }
}


