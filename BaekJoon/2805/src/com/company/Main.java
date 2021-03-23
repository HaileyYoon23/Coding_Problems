package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int [] arr;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Arrays.stream(arr).sum();
        int sIdx = 0;
        int eIdx = arr.length - 1;
        int sValue = 0;
        int eValue = arr[eIdx];
        int mValue;
        int sol = 0;
        int mIdx = 0;
        while(true) {
            mIdx = (sIdx + eIdx) / 2;
            mValue = (sValue + eValue) / 2;
            if(mIdx == 0) {
                sol = sum - (N) * mValue;
            } else if(mValue < arr[mIdx] - 1 && mValue >= arr[mIdx-1]) {
                sol = sum - (N-mIdx) * mValue;
            }
        }

    }
}
