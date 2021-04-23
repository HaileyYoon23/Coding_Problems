package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = info[0]; m = info[1];
        visited = new boolean[n+1];
        int result = 0;
        for(int i = 1; i <= m; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();


            
        }




        System.out.println(result);
    }
}
