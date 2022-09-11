package main.dblinux.UnnamedClass;

import java.util.Stack;

/**
 * @author dblinux
 * @Date 2022/5/9 15:28
 */
public class Unnamedobject {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i] == '(' || sArr[i] == '[' || sArr[i] == '{'){
                st.push(sArr[i]);
            }else if(!st.empty() && st.peek() == charOpposite(sArr[i])){
                st.pop();
            }else{
                return false;
            }
        }
        return st.empty();
    }

    public static char charOpposite(char ch){
        if(ch == ')')
            return '(';
        else if(ch == ']')
            return '[';
        else
            return '{';
    }

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            if(st.empty() || st.peek() != s.charAt(i)){
                st.push(s.charAt(i));
            }else{
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
