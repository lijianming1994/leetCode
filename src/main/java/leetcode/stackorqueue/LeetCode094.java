package leetcode.stackorqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * //TODO 需要重点重复看看， 要时时温习 这个中序遍历
 */
public class LeetCode094 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmpNode = root;
        while (tmpNode != null || !stack.isEmpty()) {
            while (tmpNode != null) {
                stack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            tmpNode = stack.pop();
            linkedList.add(tmpNode.val);
            tmpNode = tmpNode.right;
        }
        return linkedList;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}