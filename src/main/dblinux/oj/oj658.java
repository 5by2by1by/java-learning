package main.dblinux.oj;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author dblinux
 * @Date 2022/8/25 21:54
 */
public class oj658 {

    private Runnable runnable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
            .reset()
                .reset();
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(replacespaces("Mr John Smith    ", 13));
    }

    public static String replacespaces(String S, int length) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < length; ++i) {
            if (S.charAt(i) == ' ') {
                sb.append("20%");
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
