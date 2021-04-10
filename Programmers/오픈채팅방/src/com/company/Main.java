package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = (new Solution()).solution(record);
        for(String r: result) System.out.println(r);
    }
}

class Solution {
    private static Queue<Action> queue = new LinkedList<>();
    private static Map<String, String> nickName = new HashMap<>();

    public String[] solution(String[] record) {

        for(int i = 0; i < record.length; i++) {
            String[] cmd = record[i].split(" ");
            switch (cmd[0]) {
                case "Enter":
                    move(0, cmd[1], cmd[2]);
                    break;
                case "Leave":
                    move(1, cmd[1], "");
                    break;
                case "Change":
                    changeNickName(cmd[1], cmd[2]);
                    break;
            }
        }
        String[] answer = new String[queue.size()];
        for(int i = 0; i < answer.length ; i++) {
            Action action = queue.poll();
            switch (action.action) {
                case 0:
                    answer[i] = String.format("%s님이 들어왔습니다.",nickName.get(action.uid));
                    break;
                case 1:
                    answer[i] = String.format("%s님이 나갔습니다.",nickName.get(action.uid));
                    break;

            }
        }

        return answer;
    }
    private static void move(int action, String uid, String name) {
        queue.add(new Action(uid, action));
        if(action == 0) nickName.put(uid, name);
    }
    private static void changeNickName(String uid, String name) {
        nickName.put(uid,name);
    }

}

class Action {
    String uid;
    int action;     // 0 : Enter, 1: Leave
    Action(String uid, int action) {
        this.uid = uid;
        this.action = action;
    }
}