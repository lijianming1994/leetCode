package leetcode.stackorqueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class LeetCode1046 {

    /**
     * 思路：每次选择排序，选最大两个数，然后相减
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        //选择排序
        int times = 0;
        while (times < stones.length - 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = i; j < stones.length; j++) {
                    if (stones[j] > stones[i]) {
                        int tmp = stones[j];
                        stones[j] = stones[i];
                        stones[i] = tmp;
                    }
                }
            }
            stones[0] = stones[0] - stones[1];
            if (stones[0] == 0) {
                times++;
            }
            stones[1] = 0;
            times++;
        }
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] != 0) {
                return stones[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] tmp = new int[]{2, 7, 4, 1, 8, 1};
        lastStoneWeight(tmp);
        System.out.println("");
    }
}
