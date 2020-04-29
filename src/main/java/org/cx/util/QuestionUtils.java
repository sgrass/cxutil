package org.cx.util;

import java.util.ArrayList;
import java.util.List;

public class QuestionUtils {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,5)+Math.pow(2,6));
        System.out.println(resolveAnswerToString(108));
    }

    public static List<Integer> resolveAnswer(int answer) {
        List<Integer> answers = new ArrayList<>();
        for (int i = 4; i < 12; i++) {
            answers.add(answer & (1 << i));
        }
        return answers;
    }

    public static List<String> resolveAnswerToString(int answer) {
        List<Integer> answers = resolveAnswer(answer);
        List<String> ret = new ArrayList<>();
        for (Integer a : answers) {
            if (a == Math.pow(2, 4)) {
                ret.add("A");
            }
            if (a == Math.pow(2, 5)) {
                ret.add("B");
            }
            if (a == Math.pow(2, 6)) {
                ret.add("C");
            }
            if (a == Math.pow(2, 7)) {
                ret.add("D");
            }
            if (a == Math.pow(2, 8)) {
                ret.add("E");
            }
            if (a == Math.pow(2, 9)) {
                ret.add("F");
            }
            if (a == Math.pow(2, 10)) {
                ret.add("G");
            }
            if (a == Math.pow(2, 11)) {
                ret.add("H");
            }
        }
        return ret;
    }
}
