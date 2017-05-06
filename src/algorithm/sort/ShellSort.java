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
public class ShellSort {
    public static void main(String[] agrs) {
        
    }
}

/*
Review the explanation of Insertion Sort since Shell Sort is considered a generalized Insertion Sort.
The behavior is similar to Insertion Sort, as firstUnsorted's value gets assigned to itemToInsert.
Instead of shifter looking just one index to the left,
it looks one hap distance to the left and continues in multiples of the gap distance until it has found a value less than itemToInsert.
The gap continues to be halved each time the nested inner loops complete until ti's value is 0.

Tip: Similar to Insertion Sort itemToInsert is always compared with values behind it in the list (to the left, on the sorted side).
Tip: The very last pass through the array is an Insertion Sort because the gap value is 1.

Time Complexity
- best time: depends on gap sequence
- average time: depends on gap sequence
- worst time: depends on gap sequence
*/
class ShellSort1 {
    public void shellSort1(Comparable[] array) {
        int gap, firstUnsorted, shifter;
        Comparable itemToInsert;
    
        for(gap = array.length/2; gap > 0; gap /= 2) {
            for(firstUnsorted = gap; firstUnsorted < array.length; firstUnsorted++) {
                itemToInsert = array[firstUnsorted];
                shifter = firstUnsorted;
                while(shifter >= gap && itemToInsert.compareTo(array[shifter-gap])<0) {
                    array[shifter] = array[shifter - gap];
                    shifter -= gap;
                }
                array[shifter] = itemToInsert;
            }
        }
    }
}

/*
쉘 정렬은 삽입 정렬의 단점을 보완하기 위해서 Donald Shell이 1958년에 고안한 방법입니다.
삽입 정렬은 Array 전체에 대해서 정렬을 수행하게 됩니다.
최악의 경우, 다시말해서 오름차순 정렬을 해야하는데, Array가 내림차순 정렬이 되어있는 경우
연산이 많아지게 될 수 밖에 없습니다.

쉘 정렬의 기본적인 아이디어는 삽입정렬을 하기 전에 정리를 해야한다는 것인데요.
그렇다면, 어떻게 정리를 해야 할가요?
삽입 정렬은 모든 원소에 대해서 검사를 하지만,
쉘 정렬의 경우, 앞에서 구한 어떠한 간격만큼 떨어진 원소에 대해서 삽입정렬을 먼저 수행하고,
그 간격을 점점 줄여 계속 삽입정렬을 하는 방법을 취합니다.

간격은 결국 1이 될 것이며, 1이 되는 때는 곧, 삽입 정렬을 수행하는 것과 동일합니다.
하지만 이미 array가 어느정도 정리되어 있기 때문에, 삽입 정렬에 소모되는 연산이 줄어드는 것입니다.

간격을 어떻게 설정할 것인가?
일단, 배열의 길이를 토대로 설정하는 방법을 생각해 볼 수 있습니다.
배열의 길이를 N이라고 잡았을 때, 첫번째 간격을 N/2, 두번째 간격을 N/4 ... 와 같이 잡는 방법이 있습니다.
N/3, N/9 ... 와 같이 잡을 수도 있습니다.

Donald Shell은 처음에 간격을 2^k (k는 0 이상의 자연수) 혹은 2^k-1로 잡았으며,
Marcin Ciura의 연구에 의하면 1,4,10,23,57,132,301,701,1750 ... 과
같은 간격을 사용하는 것이 연산 시간을 많이 줄인하고 합니다.

아래의 코드는 간격을 N/3-1로 잡고 코딩을 한 것입니다.
*/
class ShellSort2 {
    public static <T extends Comparable<? super T>> void shellsort(T[] array){
        int compareIdx;
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
            for(int idx = gap; idx < array.length; idx++) {
                T temp = array[idx];
                for(compareIdx = idx; 
                        compareIdx >= gap && temp.compareTo(array[compareIdx - gap]) < 0; 
                        compareIdx -= gap) {
                    array[compareIdx] = array[compareIdx - gap];
                }
                array[compareIdx] = temp;
            }
        }
    }
}
/*
쉘 정렬(shell sort)은 Donald L. Shell 이라는 사람이 제안한 방법으로 삽입정렬이
어느 정도 정렬된 데이터에 대해서는 상당히 빠른 것에 착안한 방법입니다.
쉘정렬은 일반적으로 삽입정렬의 O(n^2)보다 빠릅니다.

쉘 정렬은 내부적으로는 삽입정렬의 방법을 씁니다. 삽입정렬처럼 전체 데이터를 한번에 정렬하는 것이 
아니라 일정한 기준에 따라 여러 개의 부분으로 나누고, 각 부분에서 삽입정렬을 이용합니다.
각 부분의 정렬이 완료되면 다시 더 적은 부분으로 나누어 이전 과정을 반복합니다.
이러한 과정은 부분이 1일때까지 반봅합니다.

쉘 정렬은 삽입정렬에 비해 다음과 같은 2가지 장점이 있습니다.
- 연속적이지 않은 부분 파일에서 자료의 교환이 일어나면 더 큰 거리를 이동합니다.
  반면 삽입정렬에서는 한번에 한칸씩만 이동되므로 교환되는 아이템들은 삽입정렬에 비해 최종 위치에 더 가까이 있을 가능성이 높아집니다.
- 부분 파일은 어느 정도 정렬이 된 상태이기 때문에 부분 파일의 개수가 1이 되게 되면 쉘 정렬은 삽입정렬의 특성처럼 빠르게 수행됩니다.
쉘 정렬의 시간 복잡도는 대략 최악의 경우 O(n^2)이지만 평균적인 경우에는 O(n^1.5)로 수렴됩니다.
*/