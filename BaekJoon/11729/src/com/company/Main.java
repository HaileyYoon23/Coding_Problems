package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 3, 2);
        System.out.println(result);
        System.out.println(sb);

    }
    public static void hanoi(int n, int s, int e, int a) {
        if(n == 1) {
            result++;
            sb.append(String.format("%d %d\n",s,e));
            return;
        }
        hanoi(n-1, s, a, e);
        result++;
        sb.append(String.format("%d %d\n",s,e));
        hanoi(n-1,a, e, s);
    }
}
