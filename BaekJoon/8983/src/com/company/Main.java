package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int M, N, L;
    private static int[] huntXLoc;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int result = 0;
	    int[] inputParameter = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
	    M = inputParameter[0]; N = inputParameter[1]; L = inputParameter[2];
	    huntXLoc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
	    for(int i = 0; i < N; i++) {
	        int[] position = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
	        if(position[1] > L) continue;
	        else {
	            int value = L - position[1];
	            int start = 0;
	            int end = M - 1;
	            int mid = 0;
	            while(start <= end && end >= 0 && start < M) {
	                mid = (start + end) / 2;
	                if(Math.abs(position[0] - huntXLoc[mid]) <= value) {
	                    result++;
	                    break;
                    } else {
	                    if(huntXLoc[mid] < position[0]) start = mid + 1;
	                    else end = mid - 1;
                    }
                }
            }
        }
	    System.out.println(result);
    }
}
