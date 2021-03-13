package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str1 = "(()())()";
        String str2 = ")(";
        String str3 = "()))((()";
        System.out.println((new Solution()).solution(str1));
        System.out.println((new Solution()).solution(str2));
        System.out.println((new Solution()).solution(str3));
    }
}
class Solution {
    static boolean check(String str) {
        int n = str.length();
        String substr;
        int check = 0;
        for(int i = 0; i < n; i++) {
            substr = str.substring(i,i+1);
            if(substr.equals("(")) check++;
            else if (substr.equals(")")){
                if(check == 0) return false;
                check--;
            }
        }
        return true;
    }
    static String recursive(String str) {
        String result = "";
        if (str.equals("")) return "";
        String u,v;
        int count = 0;
        int index = 0;
        while(true) {
            if (str.charAt(index) == '(') count++;
            else if(str.charAt(index) == ')') count--;
            index++;
            if (count == 0) break;
        }
        u = str.substring(0,index);
        v = str.substring(index,str.length());
        if(check(u)) return u + recursive(v);
        result = "(" + recursive(v) + ")";
        if(u.length() > 2) u = u.substring(1,u.length()-1);
        else u = "";
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') result += ")";
            else result += "(";
        }
        return result;
    }
    public String solution(String p) {
        String answer = "";
        if(check(p)) answer = p;
        else answer = recursive(p);
        return answer;
    }
}