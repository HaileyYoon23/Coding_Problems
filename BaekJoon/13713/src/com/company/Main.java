package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] z;
    public static int R = 0, L = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String pattern = br.readLine();
        N = pattern.length();
        M = Integer.parseInt(br.readLine());
        z = new int[N];

        Zalgorithm(pattern);

        for(int i = 0; i < M; i++) {
            sb.append(z[i] + "\n");
        }
        System.out.println(sb);
    }
    public static void Zalgorithm(String pattern) {
        for(int i = 1; i < N; i++) {
            if(i > R) {
                L = R = i;
                while(R < N && pattern.charAt(R-L) == pattern.charAt(R)) R++;
                z[i] = R - L;
                R--;
            } else {
                int K = i - L;
                if(z[K] <= R - i) z[i] = z[K];
                else {
                    L = i;
                    while(R < N && pattern.charAt(R-L) == pattern.charAt(R)) R++;
                    z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
