package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static long A;
    public static long B;
    public static long C;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        A = inputs[0];
        B = inputs[1];
        C = inputs[2];
        System.out.println(powerMod(A,B,C) % C);

    }
    public static long powerMod(long a, long b, long c) {
        if(b == 0) {
            return 1;
        } else if(b == 1) {
            return a % c;
        } else if(b % 2 > 0) {      // b 는 홀수
            long half = powerMod(a, b/2, c) % c;
            return (((half * half) % c) * a) % c;
        } else {
            long half = powerMod(a, b/2, c) % c;
            return (half * half) % c;
        }
    }
}
