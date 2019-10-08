package leetcode.stackorqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 */
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (stack.isEmpty()) {
                cur = null;
            } else {
                cur = stack.pop();
            }
        }
        return result;
    }
}
