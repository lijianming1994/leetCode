package leetcode.stackorqueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums[k - 1];
    }
}
