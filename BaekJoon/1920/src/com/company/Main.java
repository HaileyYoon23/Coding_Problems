package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] nums;
    public static int[] check;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int M = Integer.parseInt(br.readLine());
        check = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < M; i++) {
            int s = 0;
            int e = N-1;
            boolean find = false;
            while(s <= e) {
                int m = (s + e) / 2;
                if(nums[m] > check[i]) e = m-1;
                else if(nums[m] < check[i]) s = m+1;
                else {
                    find = true;
                    sb.append(1+"\n");
                    break;
                }
            }
            if(!find) {
                sb.append(0+"\n");
            }
        }
        System.out.println(sb);
    }
}
