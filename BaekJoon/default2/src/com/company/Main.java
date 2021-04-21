package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println((new Solution()).solution(s));
    }
}

class Solution {
    private static Stack<Character> stack = new Stack<>();
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for(int k = 0; k < len - 1; k++) {
            stack = new Stack<>();
            stack.add(s.charAt(0));
            int count = 1;
            for(int i = 1; i < len; i++) {
                char c = s.charAt(i);
                boolean check = false;
                if(isReversed(c) && (stack.isEmpty() || !isSame(stack.peek(),c))) {
                    count = 1;
                    break;
                }
                if(!stack.isEmpty() && isSame(stack.peek(), c)) {
                    stack.pop();
                    count--;
                    check = true;
                }
                if(!check) {
                    stack.add(c);
                    count++;
                }
            }
            if(count == 0) answer++;
            s = turnLeft(s);
        }

        return answer;
    }
    private static boolean isSame(char s, char e) {
        switch (s){
            case '[':
                if(e == ']') return true;
                else return false;
            case '(':
                if(e == ')') return true;
                else return false;
            case '{':
                if(e == '}') return true;
                else return false;
            default:
                return false;
        }
    }
    private static String turnLeft(String s) {
        return s.substring(1,s.length()) + s.substring(0,1);
    }
    private static boolean isReversed(char c) {
        switch(c) {
            case '}':
            case ')':
            case ']':
                return true;
            default:
                return false;
        }
    }
}