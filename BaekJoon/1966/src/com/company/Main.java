package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            Deque<Point> deque = new ArrayDeque<>();
            int[] priCnt = new int[10];
            int count = 1;
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            int N = Integer.valueOf(input1[0]);
            int M = Integer.valueOf(input1[1]);
            int pri = 0;
            for(int j = 0; j < N; j++) {
                pri = Integer.valueOf(input2[j]);
                deque.addLast(new Point(j,pri));
                priCnt[pri]++;
            }
            for(int p = 9; p >= 1;) {
                if(priCnt[p] > 0) {
                    Point temp = deque.pollFirst();
                    if(temp.priority != p) {
                        deque.addLast(temp);
                    } else {
                        if(temp.index == M) {
                            sb.append(count+"\n");
                            break;
                        } else {
                            count++;
                        }
                        priCnt[p]--;
                    }
                } else {
                    p--;
                }
            }

        }
        System.out.println(sb);
    }
}

class Point {
    int index;
    int priority;
    Point(int i, int p) {
        this.index = i;
        this.priority = p;
    }
}