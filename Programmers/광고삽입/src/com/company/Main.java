package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String playTime = "02:03:55";
	    String advTime = "00:14:15";
	    String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
	    System.out.println((new Solution()).solution(playTime, advTime, logs));
    }
}

class Solution {
    private static PriorityQueue<Long> startTime = new PriorityQueue<>();
    private static PriorityQueue<Long> endTime = new PriorityQueue<>();
    private static ArrayList<Node> nodeList = new ArrayList<>();
    private static PriorityQueue<Node> resultList = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.value < o2.value) return 1;
            else if(o1.value > o2.value) return -1;
            else {
                if(o1.startTime > o2.startTime) return 1;
                else return -1;
            }
        }
    });
    public String solution(String play_time, String adv_time, String[] logs) {
//        if(play_time.equals(adv_time)) return "00:00:00";
        String answer = "";
        for(String str: logs) convertToTimeAndInsert(str);
        long adTime = convertToTimeInterval(adv_time.split(":"));
        long totalTime = convertToTimeInterval(play_time.split(":"));
        long start = 0;
        int count = 0;
        int nextCount = 1;
        long end = startTime.poll();
        long interval = end - start;
        nodeList.add(new Node(start,0,adTime));
        while(!endTime.isEmpty()) {
            for(int i = 0; i < nodeList.size();) {
                nodeList.set(i, parsing(nodeList.get(i), interval, count));
                if(nodeList.get(i).leftTime == 0) {
                    resultList.add(nodeList.get(i));
                    nodeList.remove(i);
                }
                else i++;
            }
            count = nextCount;
            if(!startTime.isEmpty()) {
                if(startTime.peek() < endTime.peek()) {     // start 먼저 들어옴
                    if(end == startTime.peek()) {
                        start = end;
                        end = startTime.poll();
                    } else {
                        nextCount++;
                        start = end;
                        end = startTime.poll();
                    }
                } else if(startTime.peek() > endTime.peek()) {
                    nextCount--;
                    start = end;
                    end = endTime.poll();
                } else {
                    start = end;
                    end = endTime.poll();
                }
            } else {
                nextCount--;
                start = end;
                end = endTime.poll();
            }
            interval = end - start;
            nodeList.add(new Node(start,0,adTime));
        }
        for(int i = 0; i < nodeList.size();) {
            nodeList.set(i, parsing(nodeList.get(i), interval, count));
            if(nodeList.get(i).leftTime == 0) {
                resultList.add(nodeList.get(i));
                nodeList.remove(i);
            }
            else i++;
        }
        for(int i = 0; i < nodeList.size();) {
            nodeList.set(i, parsing(nodeList.get(i), totalTime - end, 0));
            if(nodeList.get(i).leftTime == 0) {
                resultList.add(nodeList.get(i));
                nodeList.remove(i);
            }
            else i++;
        }

        return timeToString(resultList.peek().startTime);
    }

    private static String timeToString(long time) {
        int hour = (int)time / 3600;
        int min = (int)(time - hour * 3600) / 60;
        int sec = (int)time % 60;
        return String.format("%02d:%02d:%02d",hour,min,sec);
    }
    private static Node parsing(Node node, long interval, int count) {
        Node result = node;
        if(node.leftTime > interval) {
            result.value += interval * count;
            result.leftTime -= interval;
        } else {
            result.value += node.leftTime * count;
            result.leftTime = 0;
        }
        return result;
    }
    private static void convertToTimeAndInsert(String str_Time) {
        String[] times = str_Time.split("-");
        String[] str_startTimes = times[0].split(":");
        String[] str_endTimes = times[1].split(":");
        long startTimeInterval = convertToTimeInterval(str_startTimes);
        long endTimeInterval = convertToTimeInterval(str_endTimes);
        startTime.add(startTimeInterval);
        endTime.add(endTimeInterval);
    }
    private static int convertToTimeInterval(String[] str_Times) {
        return Integer.parseInt(str_Times[0]) * 3600 + Integer.parseInt(str_Times[1]) * 60 + Integer.parseInt(str_Times[2]);
    }
}

class Node {
    long startTime;
    long value;
    long leftTime;
    Node(long startTime, long value, long leftTime) {
        this.startTime = startTime;
        this.value = value;
        this.leftTime = leftTime;
    }
}