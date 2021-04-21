package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] numbers;
    private static List<Integer> lastLISNumber = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    N = Integer.parseInt(br.readLine());
	    numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
	    lastLISNumber.add(numbers[0]);
	    for(int i = 1; i < N; i++) {
	        writeLISNumber(numbers[i]);
        }
	    System.out.println(lastLISNumber.size());
    }
    private static void writeLISNumber(int n) {
        int start = 0;
        int end = lastLISNumber.size() - 1;
        int mid = 0;
        while(start < end) {
            mid = (start + end) / 2;
            int value = lastLISNumber.get(mid);
            if(value >= n) end = mid;
            else start = mid + 1;
        }
        if(end >= 0 && end < lastLISNumber.size() && lastLISNumber.get(end) >= n) {
            lastLISNumber.set(end, n);
        } else {
            lastLISNumber.add(n);
        }
    }
}
