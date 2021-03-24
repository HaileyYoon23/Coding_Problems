package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static long[] nums;
    public static long[] checks;
    public static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).sorted().toArray();
        int M = Integer.parseInt(br.readLine());
        checks = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        for(int i = 0; i < M; i++) {
            int upIdx = upperBound(checks[i]);
            int lowIdx = lowerBound(checks[i]);
            if(nums[lowIdx] == checks[i]) {
                sb.append((upIdx-lowIdx+1) + " ");
            } else sb.append(0 + " ");
        }
        System.out.println(sb);
    }
    public static int upperBound(long n) {
        int s = 0;
        int e = N-1;
        int m = 0;
        while(s < e) {
            m = (s + e ) / 2;
            if(nums[m] <= n) s = m + 1;
            else e = m;
        }
        if(nums[e] != n) e -= 1;
        return e;
    }
    public static int lowerBound(long n) {
        int s = 0;
        int e = N-1;
        int m = 0;
        while(s < e) {
            m = (s + e) / 2;
            if(nums[m] >= n) e = m;
            else s = m+1;
        }
        return e;
    }
}
