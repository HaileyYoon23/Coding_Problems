package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static PriorityQueue<Class> classList = new PriorityQueue<>(new Comparator<Class>() {
        @Override
        public int compare(Class o1, Class o2) {
            if(o1.start < o2.start) return -1;
            else if(o1.start > o2.start) return 1;
            else {
                if(o1.end < o2.end) return -1;
                else if(o1.end > o2.end) return 1;
                else return 0;
            }
        }
    });
    public static PriorityQueue<Class> classRoom = new PriorityQueue<>(new Comparator<Class>() {
        @Override
        public int compare(Class o1, Class o2) {
            if(o1.end < o2.end) return -1;
            else if(o1.end > o2.end) return 1;
            else {
                if(o1.start < o2.start) return -1;
                else if(o1.start > o2.start) return 1;
                else return 0;
            }
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classList.add(new Class(start, end));
        }
        classRoom.add(classList.poll());
        while(!classList.isEmpty()) {
            int roomFastStart = classRoom.peek().start;
            int roomFastEnd = classRoom.peek().end;
            Class classTop = classList.poll();
            if(roomFastEnd <= classTop.start) {
                classRoom.poll();
                classRoom.add(new Class(roomFastStart, classTop.end));
            } else {            // 강의실 추가
                classRoom.add(classTop);
            }
        }
        System.out.println(classRoom.size());
    }
}

class Class {
    int start;
    int end;
    Class(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
