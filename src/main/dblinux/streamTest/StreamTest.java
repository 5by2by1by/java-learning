package main.dblinux.streamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dblinux
 * @Date 2022/6/8 16:01
 */
public class StreamTest {
    public static void main(String[] args) {
        test3();
    }

    public static void useFor() {
        String[] strs = new String[]{"dblinux", "xlb520", "dbl521", "123"};
        // 1）找出长度大于4的字符串。
        List<String> lengthBiggerThan4 = new ArrayList<>();
        for (String str : strs) {
            if (str.length() > 4) {
                lengthBiggerThan4.add(str);
            }
        }
        // 2）将长度大于4的字符串转成大写字母。
        List<String> toUpperCase_ = new ArrayList<>();
        lengthBiggerThan4.forEach(x -> {
            toUpperCase_.add(x.toUpperCase());
        });

        // 3）遍历已经转成大写字母的字符串。
        toUpperCase_.forEach(System.out::println);
    }

    public static void test2() {
        String[] strs = new String[]{"hello", "www", "pbteach", "com"};
        for (int i = 0; i < strs.length; i++) {
            //判断长度
            if (strs[i].length() > 4) {
                //转成大写
                String str_index = strs[i].toUpperCase();
                System.out.println(str_index);
            }
        }
    }

    public static int test3() {
        //排序 + 贪心
        int[][] pairs = {{1,2}, {2, 3}, {3, 4}};
        Arrays.sort(pairs,(o1, o2) -> o1[1] - o2[1]);
        //dp 记录 最大连接处且pairs[i][1]最小下标处的数
        int max = 1 , dp = pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            //查看当前是否可以连接在最大连接数后面
            if(pairs[i][0] > dp) {
                max++;
                dp = pairs[i][1];
            }
        }
        return max;
    }

}
