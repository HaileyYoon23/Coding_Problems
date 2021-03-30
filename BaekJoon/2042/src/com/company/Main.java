package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K, H;
    public static int Len;
    public static long[] tree;
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        H = (int)Math.ceil(logConfig(2,N)); Len = (int)Math.pow(2, H+1) + 1;
        arr = new long[N+1]; tree = new long[Len + 1];

        for(int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());

        initSegTree(1,N,1);

        for(int i = 1; i <= (M+K); i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int index = Integer.parseInt(st.nextToken());

            switch (command) {
                case("1"):
                    long value = Long.parseLong(st.nextToken());
                    long diff = value - arr[index];
                    arr[index] = value;
                    updateSegTree(index,diff,1,1,N);
                    break;
                case("2"):
                    int value2 = Integer.parseInt(st.nextToken());
                    long result = sumSegTree(1,1,N,index,value2);
                    sb.append(result+"\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }

    public static long initSegTree(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = initSegTree(start, mid, node*2) + initSegTree(mid+1, end, node*2 + 1);
        }
    }

    public static long sumSegTree(int index, int start, int end, int left, int right) {
        if(start > right || end < left) return 0;
        else if(left <= start && right >= end) return tree[index];
        else {
            int mid = (start + end) / 2;
            return sumSegTree(index * 2 , start, mid, left, right) + sumSegTree(index * 2 +1, mid + 1, end, left, right);
        }
    }

    public static void updateSegTree(int node, long diff, int index, int start, int end) {
        if(node < start || node > end) return;
        tree[index] += diff;

        if(start != end) {
            int mid = (start + end) / 2;
            updateSegTree(node, diff, index*2, start, mid);
            updateSegTree(node, diff, index*2+1, mid + 1, end);
        }
    }
    public static double logConfig(double base, double value) {
        return Math.log(value) / Math.log(base);
    }
}
