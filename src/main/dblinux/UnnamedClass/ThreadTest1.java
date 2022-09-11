package main.dblinux.UnnamedClass;

/**
 * @author dblinux
 * @Date 2022/5/9 15:30
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        System.out.println("hello, leetcodeTest");
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i + 1;
                int j = 1;
                for(; j < needle.length(); ++j){
                    if(haystack.charAt(k) != needle.charAt(j)){
                        break;
                    }else{
                        k++;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}