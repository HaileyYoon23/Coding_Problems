package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static ArrayList<Integer> crane = new ArrayList<>();
    public static ArrayList<Integer> boxes = new ArrayList<>();
    public static int result = 0;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	        crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
	    int maxCraneWeight = crane.get(0);
	    boolean possible = true;
	    M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < M; i++) {
	        int input = Integer.parseInt(st.nextToken());
	        if(input > maxCraneWeight) possible = false;
	        boxes.add(input);
        }
	    Collections.sort(boxes, Collections.reverseOrder());
	    if(!possible) System.out.println(-1);
        else {
            while(!boxes.isEmpty()) {
                for(int i = 0; i < crane.size(); i++) {
                    if(crane.get(i) >= boxes.get(0)) {
                        boxes.remove(0);
                    } else {
                        int newIndex = LowerBound(crane.get(i));
                        if(crane.get(i) >= boxes.get(newIndex)) {
                            boxes.remove(newIndex);
                        }
                    }
                    if(boxes.isEmpty()) break;
                }
                result++;
            }
            System.out.println(result);
        }
    }
    public static int LowerBound(int value) {
        int start = 0;
        int end = boxes.size() - 1;
        int mid = 0;
        while(start < end) {
            mid = (start + end) / 2;
            if(boxes.get(mid) <= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
