package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken() + "\n");
            int m = Integer.parseInt(st.nextToken());
            for(int i = 0; i < m; i++) {
                String input = br.readLine();
            }
        }
        System.out.println(sb);
    }
}
