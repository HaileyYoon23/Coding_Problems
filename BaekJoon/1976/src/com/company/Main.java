package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] matrix;
    public static boolean[] checked;
    public static int[] destination;
    public static int[] parent;
    public static int N,M;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        checked = new boolean[N+1];
        destination = new int[M+1];
        parent = new int[N+1];
        parent[0] = -1;
        Arrays.fill(parent,-1);
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] > 0) {
                    union(i,j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            destination[i] = Integer.parseInt(st.nextToken());
        }
        boolean c = false;
        int root = findRoot(destination[1]);
        for(int i = 2; i <= M; i++) {
            if(root != findRoot(destination[i])) {
                c = true;
                break;
            }
        }

//        checked[destination[1]] = true;
//        makeParent(destination[1]);

        if(!c) System.out.println("YES");
        else System.out.println("NO");
    }
    public static int findRoot(int index) {
        if(parent[index] < 0 ) return index;
        else {
            int par = findRoot(parent[index]);
            parent[index] = par;
            return par;
        }
    }
    public static void union(int root1, int root2) {
        root1 = findRoot(root1);
        root2 = findRoot(root2);

        if(root1 == root2) return;
        if(parent[root1] < parent[root2]) {
            parent[root1] += parent[root2];
            parent[root2] = root1;
        } else {
            parent[root2] += parent[root1];
            parent[root1] = root2;
        }
    }
}
