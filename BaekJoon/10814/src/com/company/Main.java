package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static ArrayList<Info> infos = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            infos.add(new Info(Integer.parseInt(info[0]),info[1]));
        }
        Collections.sort(infos,((o1, o2) -> {
            if(o1.age > o2.age) return 1;
            else if(o1.age < o2.age) return -1;
            else return 0;
        }));
        for(int i = 0; i < N; i++) {
            System.out.println(String.format("%d %s",infos.get(i).age, infos.get(i).name));
        }
    }
}
class Info {
    int age;
    String name;
    Info(int a, String n) {
        this.age = a;
        this.name = n;
    }
}
