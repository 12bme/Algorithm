/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backjoon;

/**
 *
 * 2차원 평면 위의 점 N개가 주어진다.
 * 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램 작성
 * 
 * 입력) 첫째 줄에 점의 개수 N(1 <= N <= 100,000)이 주어집니다. 둘째 줄부터 N개의 줄에는 i번점의 위치 Xi와 Yi가 주어집니다.
 *    (-100,000 <= xi, yi <= 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없습니다.
 * 
 * 출력) 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력합니다.
 * 
 * @author jiseonoh
 */
import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point that) {
        if(this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class P11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point[] a = new Point[n];
        for (int i=0; i<n; i++) {
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point(x, y);
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (Point p : a) {
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.print(sb);
    }
    
    public static void solution2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point[] a = new Point[n];
        for (int i=0; i<n; i++) {
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point(x, y);
        }
        Arrays.sort(a, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if(p1.y < p2.y) {
                    return -1;
                } else if (p1.y == p2.y) {
                    if (p1.x < p2.x) {
                        return -1;
                    } else if (p1.x == p2.x) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Point p : a) {
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.print(sb);
    }
}
