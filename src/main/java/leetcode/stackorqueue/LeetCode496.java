package leetcode.stackorqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
// TODO 非常经典！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> maxStack = new Stack<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (maxStack.isEmpty()) {
                maxStack.push(nums2[i]);
            } else {
                while (!maxStack.isEmpty() && maxStack.peek() < nums2[i]) {
                    int tmp = maxStack.pop();
                    if (!maxStack.isEmpty()) {
                        resultMap.put(tmp, maxStack.peek());
                    } else {
                        resultMap.put(tmp, -1);
                    }
                }
                maxStack.push(nums2[i]);
            }
        }
        while (!maxStack.isEmpty()) {
            int tmp = maxStack.pop();
            if (!maxStack.isEmpty()) {
                resultMap.put(tmp, maxStack.peek());
            } else {
                resultMap.put(tmp, -1);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = resultMap.get(nums1[i]);
        }
        return result;

    }
}
