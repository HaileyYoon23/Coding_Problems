package com.company;

public class Main {

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        System.out.println((new Solution()).solution(dartResult));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length()-1;
        int pow = 1;
        int dup = 0;
        boolean doubleDup = false;
        boolean minus = false;
        int num = 0;
        while(len >= 0) {
            while(!(dartResult.charAt(len) >= '0' && dartResult.charAt(len) <= '9')) {
                char c = dartResult.charAt(len);
                switch (c) {
                    case 'S':
                        pow = 1;
                        break;
                    case 'D':
                        pow = 2;
                        break;
                    case 'T':
                        pow = 3;
                        break;
                    case '*':
                        if(dup > 0) doubleDup = true;
                        dup = 2;
                        break;
                    case '#':
                       minus = true;
                       break;
                }
                len--;
            }
            int tempLen = len;
            while(tempLen >= 0 && (dartResult.charAt(tempLen) >= '0' && dartResult.charAt(tempLen) <= '9')) {
                tempLen--;
            }
            num = Integer.parseInt(dartResult.substring(tempLen+1,len+1));

            // Calculate
            num = (int)Math.pow(num, pow);
            if(doubleDup) {
                num *= 4;
                doubleDup = false;
                dup--;
            } else if(dup > 0) {
                num *= 2;
                dup--;
            }

            if(minus) {
                answer -= num;
                minus = false;
            } else answer += num;
            len = tempLen;
        }

        return answer;
    }
}