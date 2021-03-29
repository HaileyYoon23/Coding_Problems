package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int lhs = Integer.parseInt(st.nextToken());
            int rhs = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case ("0"):
                    union(lhs, rhs);
                    break;
                case ("1"):
                    if (find(lhs) != find(rhs)) {
                        sb.append("NO\n");
                    } else {
                        sb.append("YES\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);

    }

    public static int find(int index) {
        if (parent[index] < 0) return index;
        return parent[index] = find(parent[index]);
    }

    public static void union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);

        if (root1 == root2) return;
        if (parent[root1] < parent[root2]) {
            parent[root1] += parent[root2];
            parent[root2] = root1;
        } else {
            parent[root2] += parent[root1];
            parent[root1] = root2;
        }
    }
}
