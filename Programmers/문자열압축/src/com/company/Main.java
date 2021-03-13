package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str0 = ""; // 5
        String str1 = "ababcdcdababcdcd"; // 9
        String str2 = "eabcdabcdabcbcd"; // 14

        System.out.println((new Solution()).solution(str0));
        System.out.println((new Solution()).solution(str1));
        System.out.println((new Solution()).solution(str2));

    }
}

class Solution {
    static int ten(int n) {
        int result = 0;
        while(n > 0) {
            n /= 10;
            result += 1;
        }
        return result;
    }
    public int solution(String s) {
        int answer = 1_001;
        int result = 0;
        int duplicate = 0;
        int cnt = 0;
        String curSubString, prevSubString;
        for(int i = 1; i <= s.length()/2; i++) {
            result = 0;
            duplicate = 0;
            cnt = 1;
            prevSubString = s.substring(0,i);
            for(int j = i; j < s.length();) {
                if(j+i > s.length()) {
                    if(duplicate == 1) result += (i + ten(cnt));
                    else result += i;
                    result += (s.length() - j);
                    break;
                }
                curSubString = s.substring(j, j + i);
                if(prevSubString.equals(curSubString)){
                    duplicate = 1;
                    cnt += 1;
                    if((j + i) == s.length()){
                        result += (i + ten(cnt));
                        break;
                    }
                } else if(duplicate == 1){
                    duplicate = 0;
                    result += (ten(cnt) + i);
                    prevSubString = curSubString;
                    cnt = 1;
                } else {
                    duplicate = 0;
                    cnt = 1;
                    result += i;
                    prevSubString = curSubString;
                }
                if((j + i) == s.length()) {
                    result += i;
                    break;
                }
                j += i;
            }
            if(result!=0) answer = Math.min(answer,result);
        }
        if (answer == 0 || answer == 1001) answer = 1;
        return answer;
    }
}