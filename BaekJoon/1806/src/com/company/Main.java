package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] numIntList;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int S = Integer.parseInt(info[1]);
        String[] input = br.readLine().split(" ");
        numIntList = new int[N+1];
        for(int i = 0; i < N; i++) {
            numIntList[i] = Integer.parseInt(input[i]);
        }
//        int[] numIntList = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
        int i = 0, j = 0;
        int minCount = Integer.MAX_VALUE;
        int sum = 0;

        while(j <= N && i <= N) {
            if(sum >= S && minCount > (j - i)) {
                minCount = (j - i);
            }
            if(sum < S) {
                sum += numIntList[j++];
            } else {
                sum -= numIntList[i++];
            }
        }

        if(minCount != Integer.MAX_VALUE) {
            System.out.println(minCount);
        } else {
            System.out.println(0);
        }
    }
}
