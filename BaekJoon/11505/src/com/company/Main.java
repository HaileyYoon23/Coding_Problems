package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K, H;
    public static int Len;
    public static long[] arr;
    public static long[] tree;
    public static int CHK = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        H = (int) Math.ceil(logConfig(2,N)); Len = (int) Math.pow(2, H+1);
        arr = new long[N+1]; tree = new long[Len + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        initSegTree(1,N,1);
        for(int i = 1; i <= (M+K); i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int index = Integer.parseInt(st.nextToken());

            switch (command) {
                case("1"):
                    long prevValue = arr[index];
                    long changedValue = Integer.parseInt(st.nextToken());
                    arr[index] = changedValue;
                    updateSegTree(index,1,N,1,prevValue,changedValue);
                    break;
                case("2"):
                    int index2 = Integer.parseInt(st.nextToken());
                    long result = mulSegTree(1,1,N,index,index2) % CHK;
                    sb.append(result+"\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);

    }
    public static long mulSegTree(int index, int start, int end, int left, int right) {
        if(start > right || end < left) return 1;
        if(start >= left && end <= right) return tree[index];
        int mid = (start + end) / 2;
        return (mulSegTree(index*2, start, mid, left, right) * mulSegTree(index*2 + 1, mid+1, end, left, right)) % CHK;
    }

    public static void updateSegTree(int node, int start, int end, int index, long prevValue, long changedValue) {
        if(node < start || node > end) return;
        if(start != end) {
            int mid = (start + end) / 2;
            updateSegTree(node, start, mid, index*2, prevValue, changedValue);
            updateSegTree(node, mid + 1, end, index*2 + 1, prevValue, changedValue);
            tree[index] = (tree[index*2] * tree[index*2 + 1]) % CHK;
        } else {
            tree[index] = changedValue;
        }
    }

    public static long initSegTree(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start] % CHK;
        } else {
            int mid = (start + end) / 2;
            return tree[node] = (initSegTree(start, mid, node*2) * initSegTree(mid + 1, end, node * 2 + 1)) % CHK;
        }
    }

    public static double logConfig(int base, int value) {
        return Math.log(value) / Math.log(base);
    }
}
