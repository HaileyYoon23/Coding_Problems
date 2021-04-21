package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static long[] frontList;
    private static long[] backList;
    private static int[] A, B, C, D;
    public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
	    N = Integer.parseInt(br.readLine());
	    A = new int[N]; B = new int[N]; C = new int[N]; D = new int[N];
	    frontList = new long[N * N]; backList = new long[N * N];
	    for(int i = 0; i < N; i++) {
	        int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            A[i] = inputs[0]; B[i] = inputs[1]; C[i] = inputs[2]; D[i] = inputs[3];
        }
        makeList(A, B, frontList);
	    makeList(C, D, backList);
	    Arrays.sort(backList);
        for(int i = 0; i < N * N; i++) {
            long value = frontList[i];
            result += findValueAndNumber(value * -1, backList);
        }
        System.out.println(result);
    }
    private static void makeList(int[] lhs, int[] rhs, long[] list) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                list[count++] = lhs[i] + rhs[j];
            }
        }
    }
    private static long findValueAndNumber(long value, long[] list) {
        int start = 0;
        int end = N * N;
        int mid = 0;
        int endRange;
        while(start < end) {
            mid = (start + end) / 2;
            if(list[mid] > value) end = mid;
            else start = mid + 1;
        }
        if(end > 0 && list[end-1] == value) {
            endRange = end;
            start = 0;
            end = N * N - 1;
            while(start < end) {
                mid = (start + end) / 2;
                if(list[mid] >= value) end = mid;
                else start = mid + 1;
            }
            return endRange - start;
        } else return 0;
    }
}
