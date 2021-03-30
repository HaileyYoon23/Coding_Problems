package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    preSum = new int[N+1];
	    st = new StringTokenizer(br.readLine());

	    for(int i = 1; i <= N; i++) {
	        preSum[i] = preSum[i-1] + Integer.parseInt(st.nextToken());
        }

	    for(int i = 1; i <= M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());

	        sb.append(preSum[b] - preSum[a-1]);
	        sb.append("\n");
        }
        System.out.println(sb);
    }
}
