package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] result;
    public static Person[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        people = new Person[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people[i] = new Person(w,h,i);
        }

        for(int i = 0; i < N; i++) {
            int count  = 1;
            for(int j = 0; j < N; j++) {
                if(people[i].compareTo(people[j]) > 0) {
                    count++;
                }
            }
            result[i] = count;
        }
        for(int i: result) System.out.print(i + " ");
    }
}
class Person implements Comparable<Person>{
    int weight;
    int height;
    int index;
    Person(int w, int h, int i) {
        this.weight = w;
        this.height = h;
        this.index = i;
    }

    @Override
    public int compareTo(Person o) {
        if(this.weight < o.weight && this. height < o.height) {
            return 1;
        } else if (this.weight > o.weight && this. height > o.height) {
            return -1;
        } else return 0;
    }
}