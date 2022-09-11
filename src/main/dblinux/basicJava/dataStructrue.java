package main.dblinux.basicJava;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dblinux
 * @Date 2022/1/2 23:35
 */
public class dataStructrue {

    /**
     * 功能输出！ （快速生成方法注释：在方法上输入/** + 回车。）
     * @param index
     * @param obj
     */
    public static void print(int index, Object obj){
        System.out.println(String.format("{%d}, %s", index, obj.toString()));
    }

    public static void arraylistTest(){
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Taobao");
        sites.add("Wiki");
        sites.add("Runoob");
        sites.add("Weibo");
        sites.add("Google");
        Collections.sort(sites);  // 字母排序
        for (String i : sites) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1, 0, 2, 5, 3};
    }
}
