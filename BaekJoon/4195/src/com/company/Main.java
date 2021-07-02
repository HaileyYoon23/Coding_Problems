package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int totalUserNum = 0;
    private static Map<String, Integer> UID = new HashMap<>();
    private static int[] unionFind = new int[200_001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        String[] names;
        while((T--) > 0) {
            n = Integer.parseInt(br.readLine());
            resetUnionFind();
            while((n--) > 0) {
                names = br.readLine().split(" ");
                int uid1 = returnUID(names[0]);
                int uid2 = returnUID(names[1]);
                int parent1 = find(uid1);
                int parent2 = find(uid2);

                if (parent1 == parent2) {
                    sb.append(unionFind[parent1] * -1 + "\n");
                } else {
                    int result = union(parent1, parent2);
                    sb.append(result * -1 + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int find(int uid) {
        int parent = unionFind[uid];
        if(parent < 0) {
        }
        else {
            while(parent > 0) {
                uid = parent;
                parent = unionFind[uid];
            }
        }
        return uid;
    }

    private static int union(int uid1, int uid2) {
        int parent1 = find(uid1);
        int parent2 = find(uid2);
        if(unionFind[parent1] < unionFind[parent2]) {
            unionFind[parent1] += unionFind[parent2];
            unionFind[parent2] = parent1;
            return unionFind[parent1];
        } else {
            unionFind[parent2] += unionFind[parent1];
            unionFind[parent1] = parent2;
            return unionFind[parent2];
        }
    }

    private static void resetUnionFind() {
        Arrays.fill(unionFind, -1);
    }
    public static boolean isUserExist(String userName) {
        return UID.containsKey(userName);
    }

    public static int returnUID(String userName) {
        int uid;
        if(!isUserExist(userName)) {     // create UID
            UID.put(userName, totalUserNum);
            uid = totalUserNum;
            totalUserNum++;
        } else {
            uid = UID.get(userName);
        }
        return uid;
    }
}
