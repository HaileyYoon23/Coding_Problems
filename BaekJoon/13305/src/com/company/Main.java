package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static long[] len;
    public static long[] station;
    public static long sum = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        len = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        station = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long minPrice = station[0];
        for(int i = 0 ; i < N-1; i ++) {
            sum += minPrice * len[i];
            minPrice = Long.min(minPrice, station[i+1]);
        }
        System.out.println(sum);
    }
}
