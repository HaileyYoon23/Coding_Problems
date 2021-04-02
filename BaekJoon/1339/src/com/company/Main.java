package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] alphabet = new int[30];
    public static int result = 0;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            for(int n = 0; n < word.length(); n++) {
                char alpha = word.charAt(word.length() - n - 1);
                alphabet[alpha - 'A'] += Math.pow(10,n);
            }
        }
        Integer[] integerArr = Arrays.stream(alphabet).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, Collections.reverseOrder());
        int index = 0;
        int num = 9;
        while(integerArr[index] != 0) {
            result += integerArr[index] * num;
            num--;
            index++;
        }
        System.out.println(result);
    }
}
