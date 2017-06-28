/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/*
N x N개의 방에 임의의 양수가 들어있습니다. 왼쪽 위에서 출발해서 맨 오른쪽 아래로 이동하려 할 때,
지나치는 방들의 숫자의 합이 최대가 되는 경로를 택했을 때 나오는 최댓값을 구하시오.
(단, 이동은 오른쪽 혹은 아래쪽으로만 가능하고, 위로 혹은 왼쪽으로 이동이 불가하고, 대각선으로의 이동도 불가능 합니다.)

- 입력
첫째 줄에 테스트의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성된다.
첫째 줄에 가로칸의 개수 N이 주어진다. 그리고 그 다음줄부터 N개의 행값이 주어진다.

예)
1
4
6 7 12 5
5 3 11 18
7 17 3 3 
8 10 14 9

- 출력
최적의 경로로 이동했을 때, 경로상의 값들을 더한 값을 출력한다.

예) 1번 테스트의 경우 더한 최댓값이 68인 경우
# 1: 68

[풀이]
전형적인 다이나믹 프로그래밍 문제이다. 그러나, 다이나믹 예제로 앞에서 다뤘던 '피보나치 수열'이나
'파스칼의 삼각형'이 수열의 관계식을 그리 어렵지 않게 유추할 수 있고, 그 관계식만 찾아내면 프로그래밍이 어렵지 않았던데 반해,
이 문제는 수열처럼 간단한 관계식을 찾아낼수 없다. 좀 더 깊게 생각해야 합니다.

이동은 좌상단에서 우하단으로 한다고 했다. 경로상에 있는 모든 값들을 더했을 때 최대가 되는 최적의 경로를 찾아야 되는 것이고,
그렇다면, 제일 마지막 종착점이 우하단에 최종적으로 도착해야 하는데, 이 최종점에서 생각해보자.

이 최종점에서 보면, 그 전에 있을 수 있는 방은 좌측이거나 상단이다.

3이 들어있는 위쪽에서 오는 것이 좋은지, 14가 있는 왼쪽에서 오는 것이 좋은지는,
만약에 3까지의 경로최댓값과 14까지의 경로 최댓값을 안다면, 두 개를 비교해서 더 큰 값을 택하면 될 것이고,
답은 둘 중에서 큰 값에 마지막 방의 숫자인 9를 더한 것이 된다.
(다이나믹 알고리즘을 사용할 수 있을것 같은 느낌이 든다.)

좀 더 경우의 수를 생각해보자.
좌상단 방의 경우는 출발점이 되고, 제일 위칸에 있는 수는, 올 수 있는 방향이 왼쪽에서 밖에 없다.
제일 왼쪽에 있는 숫자의 경우는 위에서 부터 오는 경우만 존재할 것이다.

이제, 다이나믹 프로그래밍스럽게 되도록 식을 만들어 보자. 먼저 사용되는 표현에 대한 정의를 하자
- 방으로 구성된 테이블을, 좌상단에서 우하단으로 증가하는 행렬로 보고, 행과열은 0에서부터 시작하고,
  행은 i, 열은 j로 나타내기로 하자.
- m(i, j) : (i,j)에 해당하는 방의 값
- c(i, j) : (i, j)까지 최적의 경로로 왔을 때 최댓값

위에서 생각한 각 경우의 수를 고려하면서, 정의한 표현을 가지고 수식으로 나타내보자.
- c(0, 0) = m(0, 0) // 좌상단 방의 경우
- c(0, j) = c(0, j-1) + m(0, j), j>0 // 맨 위에 있는 방의 경우
- c(i, 0) = c(i-1, 0) + m(i, 0), i>0 // 맨 왼쪽에 있는 방의 경우
- c(i,j) = Max(c(i-1), j), c(i, j-1)) + m(i, j), i>0, j>0 //일반적인 경우, 위 혹은 왼쪽 중 최대인 곳 + 자신의 값

경우의 수가 좀 더 많긴 하지만 '피보나치 수열'이나 '파스칼의 삼각형'처럼
점화식 형태의 수식이 도출되었고, 이제 프로그래밍을 할 수 있겠다.

이를 효율성을 고려하지 않고 그대로 수식 그대로를 재귀호출형태로 코딩하면 다음과 같겠다.

*/

import java.util.Scanner;

/**
 * @author jiseonoh
 */
class MaxMatrixPath {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T, N;
        
        T = sc.nextInt();
        
        for(int testNum=1; testNum<=T; testNum++) {
            N = sc.nextInt();
            int[][] m = new int[N][N];
            int[][] cache = new int[N][N];
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    m[r][c] = sc.nextInt();
                }
            }
            cache[0][0] = m[0][0];
            System.out.println("#"+testNum+": " + cost(m, N-1, N-1, cache));
        }
    }
    
    private static int cost(int[][] m, int i, int j) {
        if(i==0 && j==0) return m[0][0];
        
        if(i==0) return cost(m, 0, j-1) + m[0][j];
        if(j==0) return cost(m, i-1, 0) + m[i][0];
        
        return (Math.max(cost(m, i-1, j), cost(m, i, j-1)) + m[i][j]);
    }
    
    private static int cost(int[][] m, int i, int j, int[][] cache) {
        if(i==0 && j==0)
            return cache[0][0];
        
        if(i==0){
            cache[i][j] = (cache[0][j-1] != 0) ? (cache[0][j-1] + m[0][j])
                     : (cost(m,0,j-1,cache) + m[0][j]);
            return cache[i][j];
        }
        
        if(j==0) {
            cache[i][j] = (cache[i-1][0] != 0) ? (cache[i-1][0] + m[i][0])
                     : (cost(m, i-1, 0, cache) + m[i][0]);
            return cache[i][j];
        }
        
        int A = (cache[i-1][j] != 0) ? (cache[i-1][j]) : (cost(m, i-1, j, cache));
        int B = (cache[i][j-1] != 0) ? (cache[i][j-1]) : (cost(m, i, j-1, cache));
        cache[i][j] = Math.max(A, B) + m[i][j];
        return cache[i][j];
    }
}
