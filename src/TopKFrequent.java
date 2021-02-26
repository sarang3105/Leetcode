import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                m.put(nums[i], m.getOrDefault(nums[i], 1) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                pq.add(new int[]{e.getKey(), e.getValue()});
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll()[0];
            }
            return ans;
        }
    }
}
