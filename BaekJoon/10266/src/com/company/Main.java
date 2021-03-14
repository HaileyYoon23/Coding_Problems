package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] firstPos = br.readLine().split(" ");
        String[] secondPos = br.readLine().split(" ");

        String target = "";
        StringBuilder tempTarget = makeCombineBin(firstPos);
        String pattern = makeCombineBin(secondPos).toString();
        target = tempTarget.append(tempTarget).toString();

        if (KMP(target, pattern)) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }

    public static StringBuilder makeCombineBin(String[] targetPos) {
//        String result = String.format("%" + 360_000 + "s","0").replace(' ', '0');
        StringBuilder sb = new StringBuilder(String.format("%" + 360_000 + "s","0").replace(' ', '0'));
        for(String s: targetPos) {
            int v = Integer.valueOf(s);
            sb.setCharAt(v,'1');
        }
        return sb;
    }
    public static boolean KMP(String target, String pattern) {
        boolean result = false;
        int[] pi = getPi(pattern);
        int j = 0;

        for(int i = 0; i < target.length(); i++) {
            while(j > 0 && target.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(target.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    public static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;

        for(int i = 1; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }

        return pi;
    }
}
