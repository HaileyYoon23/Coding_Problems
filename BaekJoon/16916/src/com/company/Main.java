package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int[] PI;
    public static void main(String[] args) throws IOException {
	    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	    String string = br.readLine();
	    String pattern = br.readLine();
	    PI = new int[pattern.length()];
        getPI(pattern);
        if(findPattern(string,pattern)) System.out.println(1);
        else System.out.println(0);
    }
    private static boolean findPattern(String string, String pattern) {
        int len = string.length();
        int pattenrLen = pattern.length();
        int j = 0;
        for(int i = 0; i < len; i++) {
            while(j > 0 && string.charAt(i) != pattern.charAt(j)){
                j = PI[j-1];
            }
            if(string.charAt(i) == pattern.charAt(j)) {
                j++;
                if(j == pattenrLen) return true;
            }
        }
        return false;
    }
    private static void getPI(String pattern) {
        int j = 0;
        int len = pattern.length();
        for(int i = 1; i < len; i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = PI[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                PI[i] = ++j;
            }
        }
    }
}
