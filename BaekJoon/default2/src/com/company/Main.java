package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent(1,"First"));
        System.out.println(map.putIfAbsent(1,"Second"));
    }
}
