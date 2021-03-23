package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println(combine(N,M) % 1_000_000_007);
    }
    public static long combine(int n, int m) {
        if(n == m || m == 0) return 1;
        if(m == 1) return n;
        if(n-m > m) {
            return combine(n-1, m) + combine(n-1,m-1);
        } else {
            return combine(n-1, n-m) + combine(n-1,n-m-1);
        }

    }
}
