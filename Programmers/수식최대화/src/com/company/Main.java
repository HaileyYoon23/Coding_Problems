package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String expression = "177-661*999*99";//-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99";
        System.out.println((new Solution()).solution(expression));
    }
}

class Solution {
    private static Stack<Long> numberStack = new Stack<>();
    private static Stack<Character> operationStack = new Stack<>();
    private static Queue<Long> numberBeforeParsing = new LinkedList<>();
    private static Queue<Character> operationBeforeParsing = new LinkedList<>();
    private static int multiPri, plusPri, minusPri;
    private static long maxResult = 0;
    public long solution(String expression) {
        long answer = 0;

        // Initial String Parsing
        for(int i = 1; i <= 6; i++) {
            int len = expression.length();
            int r = len-1;
            prioritySet(i);
            for(int l = len-1; l >= 0; l--) {
                char c = expression.charAt(l);
                if(c == '-' || c == '*' || c == '+') {
                    numberBeforeParsing.add(Long.parseLong(expression.substring(l+1,r+1)));
                    r = l - 1;
                    operationBeforeParsing.add(c);
                } else{

                }
            }
            numberBeforeParsing.add(Long.parseLong(expression.substring(0,r+1)));

            numberStack.add(numberBeforeParsing.poll());
            operationStack.add(operationBeforeParsing.poll());
            numberStack.add(numberBeforeParsing.poll());
            while(!operationBeforeParsing.isEmpty()) {
                char operationTop = operationStack.peek();
                char operationNew = operationBeforeParsing.poll();
                while(priorityCompare(operationTop, operationNew) > 0 && !operationStack.isEmpty()) {
                    long a = numberStack.pop();
                    long b = numberStack.pop();
                    operationStack.pop();
                    numberStack.add(calculate(a,b,operationTop));
                    if(!operationStack.isEmpty()) operationTop = operationStack.peek();
                }
                operationStack.add(operationNew);
                numberStack.add(numberBeforeParsing.poll());
            }
            while(numberStack.size() != 1) {
                long a = numberStack.pop();
                long b = numberStack.pop();
                char c = operationStack.pop();
                numberStack.add(calculate(a,b,c));
            }

            maxResult = Long.max(maxResult, Math.abs(numberStack.pop()));

        }

        return maxResult;
    }

    private static long calculate(long a, long b, char c) {
        switch (c) {
            case '*':
                return a * b;
            case '-':
                return a - b;
            case '+':
                return a + b;
            default:
                return -1;
        }
    }
    private static void prioritySet(int version) {
        multiPri = (version + 1) / 2;
        plusPri = (6 - version) % 3 + 1;
        minusPri = (version >= 3) ? (version - 2) / 2 : (version + 4) / 2;
    }

    private static int priorityCompare(char c1, char c2) {
        int c1Pri = priorityGet(c1); int c2Pri = priorityGet(c2);
        return c1Pri - c2Pri;
    }

    private static int priorityGet(char c1) {
        switch (c1) {
            case '*':
                return multiPri;
            case '+':
                return plusPri;
            case '-':
                return minusPri;
            default:
                return -1;
        }
    }
}