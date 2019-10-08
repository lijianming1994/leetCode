package leetcode.stackorqueue;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class LeetCode173 {
    public static void main(String[] args) {
        TreeNode treeNode = null;
//        TreeNode treeNode = new TreeNode(7);
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(15);
//        TreeNode treeNode3 = new TreeNode(9);
//        TreeNode treeNode4 = new TreeNode(20);
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
        BSTIterator bstIterator = new BSTIterator(treeNode);
        bstIterator.next();
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
//        System.out.println(bstIterator.next());
    }
}


class BSTIterator {

    TreeNode curr;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        if(!stack.isEmpty()) {
            curr = stack.pop();
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int result = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        if (!stack.isEmpty())
            curr = stack.pop();
        return result;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return curr != null;
    }
}
