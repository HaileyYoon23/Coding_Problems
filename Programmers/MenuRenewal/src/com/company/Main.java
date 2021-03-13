package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] str = {"ABCDEFGHIJK", "JK",};
        int[] cour = {2};
        Solution s = new Solution();
        String[] result = s.solution(str,cour);

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class comb {
    public String str = "";
    public int max = 0;

    public comb(String str, int max) {
        this.str = str;
        this.max = max;
    }
}

class Solution {
    Queue<comb> q = new LinkedList<>();
    int alphabetNum = 'Z' - 'A' + 1;
    int[] existBit = new int[alphabetNum];
    char[] result = new char[10];
    int maxNum = 0;
    public int numOfOne(int bit) {
        int i;
        for(i = 0; bit != 0; i++)
        {
            bit &= (bit - 1);
        }
        return i;
    }
    public void pushToQueue(int courseNum) {
        if(q.peek() != null) {
            if(q.peek().max < maxNum) {
                q.clear();
                String str = "";
                for(int k = 0; k < courseNum; k++) {
                    str += result[k];
                }
                q.offer(new comb(str,maxNum));
            } else if(q.peek().max == maxNum) {
                String str = "";
                for(int k = 0; k < courseNum; k++) {
                    str += result[k];
                }
                q.offer(new comb(str,maxNum));
            }
        } else {
            String str = "";
            for(int k = 0; k < courseNum; k++) {
                str += result[k];
            }
            q.offer(new comb(str, maxNum));
        }
    }
    public void setMaxInQueue(int startIdex, int courseNum, int leftCourse, int prevBit) {
        if(leftCourse == 0) {
            int res = numOfOne(prevBit);
            if(res >= maxNum && res > 1){
                maxNum = res;
                pushToQueue(courseNum);
            }
            return;
        }
        for(int i = startIdex; i < alphabetNum; i++) {
            if(numOfOne(prevBit) < maxNum | numOfOne(existBit[i]) < maxNum | numOfOne(existBit[i]) < 2) continue;
            result[courseNum - leftCourse] = (char)('A' + i);
            setMaxInQueue(i + 1, courseNum, leftCourse - 1, prevBit & existBit[i]);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new LinkedList<>();
//        String[] answer = new String[alphabetNum];
        int temp = 0;
        int answerNum = 0;

        for(int i = 0; i < orders.length; i++) {
            String str = orders[i];
            for(int j = 0; j < str.length(); j++) {
                existBit[str.charAt(j) - 'A'] |= (1 << i);
            }
        }

        for(int i = 0; i < course.length; i++) {
            setMaxInQueue(0,course[i], course[i],0xFFFF);
            while(q.size() > 0) {
                answer.add(q.poll().str);
                answerNum++;
            }
            maxNum = 0;
            q.clear();
        }
        String[] realAnswer = new String[answerNum];
        for(int i = 0; i < answerNum; i++) {
            realAnswer[i] = answer.get(i);
        }

        Arrays.sort(realAnswer);

        return realAnswer;
    }
}