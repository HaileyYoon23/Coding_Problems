package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();
        result r = solution(T,P);
        System.out.println(r.num);
        for(Object i: r.index) {
            System.out.println(i);
        }
    }

    static int[] piResult(String str) {
        int[] pi = new int[str.length()];
        int j = 0;
        for(int i = 1; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static result solution (String T, String P) {
        result r = new result(0);
        int pi[] = piResult(P);
        int j = 0;
        int entireCnt = 0;
        for(int i = 0; i < T.length(); i++) {
            while(j>0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if(T.charAt(i) == P.charAt(j)) {
                if(j == P.length() - 1) {
                    ++entireCnt;
                    r.index.add(i-j+1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        r.num = entireCnt;
        return r;
    }
}

class result{
    int num;
    ArrayList index = new ArrayList<Integer>();

    result(int n) {
        this.num = n;
    }

}