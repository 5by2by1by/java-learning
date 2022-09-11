package main.dblinux.basicJava;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author dblinux
 * @Date 2022/3/11 19:28
 */

public class Main {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int resourcesNum = cin.nextInt();
        int taskNums = cin.nextInt();
        int colNums = 2;
        int[][] taskAttributes = new int[taskNums][colNums];
        for (int row = 0; row < taskNums; row++) {
            for (int col = 0; col < colNums; col++) {
                taskAttributes[row][col] = cin.nextInt();
            }
        }
        cin.close();
        int result = taskScheduler(resourcesNum, taskAttributes);
        System.out.println(result);
    }

    private static int taskScheduler(int resourcesNum, int[][] taskAttributes) {
        // 在此补充你的代码
        int res = 1000000008;
        int tasks = taskAttributes.length;
        int mintime = taskAttributes[0][0];
        if (resourcesNum >= tasks) {
            for (int i = 1; i < taskAttributes[i][0]; i++) {
                mintime = Math.min(mintime, taskAttributes[i][0]);
            }
        }
        return mintime == 100000008 ? 1 : mintime;
    }
}
