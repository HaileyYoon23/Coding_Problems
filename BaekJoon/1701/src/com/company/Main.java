package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int maxJ = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int len = string.length();
        for(int i = 0; i < len - 2; i++) {
            String tempStr = string.substring(i,len);
            getPI(tempStr);
        }

        System.out.println(maxJ);
    }
    public static void getPI(String str) {
        int len = str.length();
        int[] pi = new int[len];
        int j = 0;
        for(int i = 1; i < len ; i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j-1];
            }
            if(str.charAt(i) == str.charAt(j)) pi[i] = ++j;
            maxJ = Integer.max(j,maxJ);
        }

    }
}
