package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] pattern;
    private static int[] palin;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    N = Integer.parseInt(br.readLine());
	    palin = new int[2*N+1];
	    pattern = new int[2*N+1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i <= 2*N; i++) {
	        if(i % 2 == 0) {
	            pattern[i] = -1;
            } else {
	            pattern[i] = Integer.parseInt(st.nextToken());
            }
        }

	    getPalin(pattern);

	    M = Integer.parseInt(br.readLine());

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = end - start + 1;
            int palinValue = palin[end + start - 1];
            if(palinValue >= length) sb.append(1+"\n");
            else sb.append(0+"\n");
        }
        System.out.println(sb);

    }
    private static void getPalin(int[] pattern) {
        int center = 0, mirror = 0, radius = 0;
        int len = pattern.length;
        for(int i = 0; i < len; i++) {
            if(i <= radius) {
                mirror = 2 * center - i;
                palin[i] = Integer.min(palin[mirror], radius - i);
            }
            while((i-palin[i]-1) >= 0 && (i+palin[i]+1) < len
                    && pattern[i-palin[i]-1] == pattern[i+palin[i]+1]) {
                palin[i]++;
            }
            if(i + palin[i] > radius) {
                radius = i + palin[i];
                center = i;
            }
        }
    }
}
