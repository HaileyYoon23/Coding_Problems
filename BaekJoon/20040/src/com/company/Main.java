package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int n,m;
    private static int[] parent;
    private static List<Integer> d = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = info[0]; m = info[1];
        visited = new boolean[n+1];
        parent = new int[n];
        int result = 0;
        boolean find = false;
        Arrays.fill(parent, -1);

        for(int i = 1; i <= m; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if(!union(inputs[0], inputs[1]) && !find) {
                result = i;
                find = true;
            }
        }
        System.out.println(result);
    }
    private static int find(int n) {
        int parentNum = parent[n];
        if(parentNum < 0) return n;
        else return find(parentNum);
    }
    private static boolean union(int lhs, int rhs) {
        int parentLhs = find(lhs);
        int parentRhs = find(rhs);
        if(parentLhs == parentRhs) return false;
        if(parent[parentLhs] < parent[parentRhs]) {
            parent[parentLhs] += parent[parentRhs];
            parent[parentRhs] = parentLhs;
        } else {
            parent[parentRhs] += parent[parentLhs];
            parent[parentLhs] = parentRhs;
        }
        return true;
    }

}
