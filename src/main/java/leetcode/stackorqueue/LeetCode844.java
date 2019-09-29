package leetcode.stackorqueue;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class LeetCode844 {
    public static boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if ("#".equals(String.valueOf(s[i]))) {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(s[i]);
            }
        }
        for (int i = 0; i < t.length; i++) {
            if ("#".equals(t[i])) {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(t[i]);
            }
        }
        if (sStack.size() != tStack.size()) {
            return false;
        }
        while (!sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        backspaceCompare(s,t);
    }
}
