package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] numIntList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        int X = Integer.valueOf(br.readLine());

        int i = 0;
        int j = numIntList.length - 1;
        int sum = 0;
        int result = 0;

        while(i < j) {
            sum = numIntList[i] + numIntList[j];
            if(sum > X){
                j--;
            } else if (sum < X) {
                i++;
            } else {
                result++;
                i++;
                j--;
            }
        }
        System.out.println(result);
    }
}
