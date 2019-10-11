package leetcode.stackorqueue;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class LeetCode451 {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                Integer a = map.get(c);
                map.put(c, a + 1);
            }
        }
        List<Map.Entry<Character, Integer>> li = new ArrayList<>(map.entrySet());
        li.sort((Comparator<Map.Entry>) (o1, o2) -> (((Integer) o2.getValue()) - ((Integer) o1.getValue())));
        StringBuilder sb = new StringBuilder();
        li.forEach((e) -> {
                    for (int i = 0; i < e.getValue(); i++) {
                        sb.append(e.getKey());
                    }
                }
        );
        return sb.toString();

    }
}
