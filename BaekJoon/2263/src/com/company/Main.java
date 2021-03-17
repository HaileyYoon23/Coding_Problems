package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static int[] inOrder;
    public static int[] postOrder;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        inOrder = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        preOrder(0,N-1,0,N-1);
    }

    public static void preOrder(int inS, int inE, int postS, int postE) {


        int root = postOrder[postE];
        sb.append(root + " ");

//        preOrder(,postS + ());
    }
}
