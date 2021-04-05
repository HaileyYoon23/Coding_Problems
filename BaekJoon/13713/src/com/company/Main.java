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
        L = N-1; R = N-1;
        Zalgorithm(pattern);

        for(int m = 0; m < M; m++) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == N) {
                sb.append(N+"\n");
            } else {
                sb.append(z[cmd-1]+"\n");
            }
        }
        System.out.println(sb);
    }
    public static void Zalgorithm(String pattern) {
        for(int i = N-2; i >= 0; i--) {
            if(i < R) {
                L = R = i;
                while(R >= 0 && pattern.charAt(N-1-(L-R)) == pattern.charAt(R)) R--;
                z[i] = L - R;
                R++;
            } else {
                int K = N - 1 - (L - i);
                if(z[K] <= i - R) z[i] = z[K];
                else {
                    L = i;
                    while(R >= 0 && pattern.charAt(N-1-(L-R)) == pattern.charAt(R)) R--;
                    z[i] = L - R;
                    R++;
                }
            }
        }
    }
}
