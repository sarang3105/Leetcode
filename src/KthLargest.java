import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
class KthLargest {

    PriorityQueue<Integer> pq;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i : nums) addPQ(i);
    }

    public void addPQ(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
    }
    public int add(int val) {
        addPQ(val);
        return pq.peek();
    }
}