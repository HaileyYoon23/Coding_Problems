package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int[] weights;
    public static ArrayList<Integer> sum1;
    public static ArrayList<Integer> sum2;
    public static int result;
    public static int C;
    public static int N;
    public static int index;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);
        sum1 = new ArrayList<>();
        sum2 = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        weights = new int[N+1];
        result = 0;
        for(int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(inputs[i]);
        }
        DFSHalf(0,0,N/2, sum1);
        DFSHalf(0, N/2, N, sum2);
        Collections.sort(sum2);

        for(int i = 0; i < sum1.size(); i++) {
            index = -1;
            binarySearch(0, sum2.size() - 1, sum1.get(i));
            result += index + 1;
        }

//        DFS(0,0);
        System.out.println(result);
        br.close();

    }

    public static void DFSHalf(int sum, int i, int th, ArrayList arr) {
        if(sum > C) return;
        if(i == th) {
            arr.add(sum);
            return;
        }
        DFSHalf(sum + weights[i], i + 1, th, arr);
        DFSHalf(sum, i + 1, th, arr);
    }

    public static void binarySearch(int start, int end, int v) {
        if(start > end) {
            return;
        }
        int mid = (start + end) / 2;

        if (sum2.get(mid) + v <= C) {
            index = mid;
            binarySearch(mid + 1, end, v);
        } else {
            binarySearch(start, mid - 1, v);
        }
    }

//    public static void DFS(int sum, int k) {
//        if(sum > C) {
//            result -= 1;
//            return;
//        }
//        if(k >= N) return;
//        for(int i = k; i < N; i++) {
//            sum += weights[i];
//            result += 1;
//            DFS(sum,i+1);
//            sum -= weights[i];
//        }
//    }
}
