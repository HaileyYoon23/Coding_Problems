package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static long[] result = new long[2501];
    private static final int max = 1_000_000_007;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    N = Integer.parseInt(br.readLine());
	    result[0] = 1;
	    result[1] = 1;
        for(int i = 2; i <= 2500; i++) {
            for(int k = 0; k < i; k++) {
                result[i] += result[k] * result[i - k - 1];
                result[i] %= max;
            }
            result[i] %= max;
        }
	    for(int i = 0; i < N; i++) {
	        int n = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {
                sb.append(result[n/2] + "\n");
            } else sb.append(0 + "\n");
        }

	    System.out.println(sb);
    }
}
