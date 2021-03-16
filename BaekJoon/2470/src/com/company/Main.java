package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] numIntList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int i = 0;
        int prevI = i;
        int j = numIntList.length - 1;
        int prevJ = j;
        int sum = 0;
        int minSum = 1_000_000_001;
        int resultI = i;
        int resultJ = j;
        while (i < j) {
            sum = numIntList[i] + numIntList[j];
            if(minSum > Math.abs(sum)) {
                resultI = i;
                resultJ = j;
                minSum = Math.abs(sum);
            }
            if(sum > 0) {
                prevJ = j;
                j--;
            } else if(sum < 0) {
                prevI = i;
                i++;
            } else {
                resultI = i;
                resultJ = j;
                break;
            }
        }
        System.out.println(numIntList[resultI]+" "+numIntList[resultJ]);
    }
}
