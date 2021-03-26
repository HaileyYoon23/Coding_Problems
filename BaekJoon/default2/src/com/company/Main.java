package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t ++) {
            int N = Integer.parseInt(br.readLine());
            sum = 0;
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            reverseSort(0,N-1);
            sb.append(String.format("Case #%d: %d\n",t+1,sum));
        }
        System.out.println(sb);
    }
    public static void reverseSort(int start, int end) {
        if(start == end) return;
        int minIndex = findMinValueIndex(start, end);
        if(start == minIndex) sum += 1;
        else if(arr[start] >= arr[minIndex]) {
            int temp = arr[minIndex];
            arr[minIndex] = arr[start];
            arr[start] = temp;
            sum += (end - start + 1);
        }
        reverseSort(start+1,minIndex);
    }
    public static int findMinValueIndex(int start, int end) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = start; i <= end; i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
