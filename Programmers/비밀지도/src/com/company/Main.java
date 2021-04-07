package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String temp = "";
            int line = arr1[i] | arr2[i];
            for(int j = n-1; j >= 0; j--) {
                if((line & (1<<j)) > 0) temp = temp + "#";
                else temp = temp + " ";
            }
            answer[i] = temp;
        }
        return answer;
    }
}