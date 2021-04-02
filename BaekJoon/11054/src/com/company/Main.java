package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] nums;
    public static int[] DP1;
    public static int[] DP2;
    public static int[] DPSum;
    public static int maxSum = 0;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    DP1 = new int[N]; DP2 = new int[N]; DPSum = new int[N];
	    nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
	    DP1[0] = 1;
        for(int i = 1; i < N; i++) {
            DP1[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i] && DP1[i] <= DP1[j]) {
                    DP1[i] = DP1[j] + 1;
                }
            }
        }
        DP2[N-1] = 1;
        for(int i = N-1; i >= 0; i--) {
            DP2[i] = 1;
            for(int j = i+1; j < N; j++) {
                if(nums[j] < nums[i] && DP2[i] <= DP2[j]) {
                    DP2[i] = DP2[j] + 1;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            maxSum = Integer.max(maxSum, DP1[i] + DP2[i]);
        }
        System.out.println(maxSum - 1);
    }
}
