package leetcode.stackorqueue;

import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 */
public class LeetCode921 {


    public static int minAddToMakeValid(String S) {

        Stack<Character> stack = new Stack<>();
        char[] str = S.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (")".equals(String.valueOf(str[i]))) {
                if (!stack.isEmpty() && "(".equals(String.valueOf(stack.peek()))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(str[i]);
        }
        return stack.size();
    }
}
