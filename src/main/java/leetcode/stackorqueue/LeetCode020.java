package leetcode.stackorqueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * //TODO 不知道为什么ac不了
 */
public class LeetCode020 {

    public static void main(String[] args) {
        String s = "([( )()])";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (String.valueOf(strs[i]).trim().isEmpty()) {

            } else if (")".equals(String.valueOf(strs[i]))) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("(")) {
                    stack.pop();
                }
            } else if ("}".equals(String.valueOf(strs[i]))) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("{")) {
                    stack.pop();
                }
            } else if ("]".equals(String.valueOf(strs[i]))) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("[")) {
                    stack.pop();
                }
            } else {
                stack.push(String.valueOf(strs[i]));
            }
        }
        return stack.isEmpty();
    }
}
