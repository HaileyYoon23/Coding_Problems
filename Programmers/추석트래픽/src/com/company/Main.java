package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String[] lines = {"2016-09-15 00:00:00.000 3s"};
	    System.out.println((new Solution()).solution(lines));
    }
}

class Solution {
    private static PriorityQueue<Long> startTime = new PriorityQueue<>();
    private static PriorityQueue<Long> endTime = new PriorityQueue<>();
    private static int maxNum = 0;

    public int solution(String[] lines) {

        for(int i = 0; i < lines.length; i++) {
            String[] inputs = lines[i].split(" ");
            String[] str_StartTime = inputs[1].split(":");
            long endTimeInterval = (Long.parseLong(str_StartTime[0]) * 3600
                    + Long.parseLong(str_StartTime[1]) * 60) * 1000
                    + (long)(Double.parseDouble(str_StartTime[2]) * 1000);
            long startTimeInterval = endTimeInterval - (long)(Double.parseDouble(inputs[2].substring(0,inputs[2].length()-1)) * 1000);
            if(endTimeInterval < 0) endTimeInterval = 0;
            startTime.add(startTimeInterval); endTime.add(endTimeInterval);
        }
        findMaxNum();

        return maxNum;
    }

    private static void findMaxNum() {
        long start = 0;
        long time = 1000;
        int num = 0;
        long endTimeInterval = endTime.poll();
        long nextEndTimeInterval;
        while(!startTime.isEmpty() && startTime.peek() <= endTimeInterval) {
            startTime.poll();
            num++;
        }
        while(!endTime.isEmpty()) {
            while(!startTime.isEmpty() && startTime.peek() < endTimeInterval + time - 1) {
                startTime.poll();
                num++;
            }
            nextEndTimeInterval = endTime.poll();
            endTimeInterval = nextEndTimeInterval;
            maxNum = Integer.max(maxNum,num);
            num--;
        }
        maxNum = Integer.max(maxNum,num);
    }
}