import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link
 */
class KthLargest {

    PriorityQueue<Integer> pq;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i : nums) {
            addPQ(i);
        }
    }

    public void addPQ(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (pq.size() == k){
            if (pq.peek() < val) {
                pq.poll();
                pq.add(val);
            }
        }
    }
    public int add(int val) {
        addPQ(val);
        return pq.peek();
    }
}