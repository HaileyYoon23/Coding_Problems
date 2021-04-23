package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static Deque<Integer>[] deques;
    private static List<Integer> numbers = new ArrayList<>();
    private static Queue<Number> numberToPutArray = new PriorityQueue<>(new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return o1.value - o2.value;
        }
    });
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    deques = new ArrayDeque[N];
	    int goalNumber = N * N;
	    int temp = N;
	    boolean firstTry = true;
	    for(int i = 0; i < N; i++) {
	        deques[i] = new ArrayDeque<>();
        }
	    while((temp--) > 0) {
	        int index = 0;
	        int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
	        for(int v: inputs) {
                if(firstTry) {
                    numberToPutArray.add(new Number(v,index));
                } else deques[index].addLast(v);
                index++;
            }
	        firstTry = false;
        }
	    while(numbers.size() < goalNumber) {
	        Number number = numberToPutArray.poll();
	        numbers.add(number.value);
	        if(!deques[number.column].isEmpty()) {
	            numberToPutArray.add(new Number(deques[number.column].pollFirst(), number.column));
            }
        }
	    System.out.println(numbers.get(goalNumber - N));
    }
}

class Number {
    int value;
    int column;
    Number(int value, int column) {
        this.value = value;
        this.column = column;
    }
}