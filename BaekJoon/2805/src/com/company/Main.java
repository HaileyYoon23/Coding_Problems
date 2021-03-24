package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] arr;
    public static int N;
    public static int max;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        Long M = Long.parseLong(info[1]);
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        max = arr[N-1];
        sb.append(upperBound(M));

        System.out.print(sb);
    }
    public static long getWoodLength(long height) {
        long result = 0;
        for(int i = 0; i < N; i++) {
            if(height < arr[i]) result += (arr[i] - height);
        }
        return result;
    }
    public static long upperBound(long woodLength) {
        long s = 0;
        long e = max;
        long m = 0;
        long result = 0;
        while(s <= e) {
            m = (s + e) / 2;
            if(getWoodLength(m) >= woodLength) {
                s = m+1;
            }
            else e = m - 1;
        }
        return e;
    }
}
