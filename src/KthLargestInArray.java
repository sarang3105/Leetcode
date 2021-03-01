import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInArray {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i : nums) {
                if (pq.size() < k) {
                    pq.add(i);
                } else if (pq.size() == k && pq.peek() < i) {
                    pq.poll();
                    pq.add(i);
                }
            }
            return pq.peek();
        }
    }
}
