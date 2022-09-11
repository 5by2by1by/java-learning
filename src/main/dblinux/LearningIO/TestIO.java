package main.dblinux.LearningIO;

import java.io.File;

/**
 * @author dblinux
 * @Date 2022/6/9 9:44
 */
public class TestIO {
    public static void main(String[] args) {
    }



    public static boolean recursionDelete(File file) {
        // 当为目录时
        if (file.isDirectory() && file.exists()) {
            // 列出目录下所以文件（或目录）
            File[] files = file.listFiles();
            // 当数组不为空时
            if (files != null) {
                // 遍历数组
                for (File f : files) {
                    // 递归删除文件（或目录）
                    recursionDelete(f);
                }
            }
        }
        // 删除文件（或目录）
        return file.delete();
    }
}
