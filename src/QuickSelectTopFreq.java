import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link https://leetcode.com/problems/top-k-frequent-elements/
 */
public class QuickSelectTopFreq {
    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public int[] topKFrequent(int[] nums, int k) {
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int n = map.size();
            int[] vals = new int[n];
            int i = 0;
            for (int v : map.keySet()) {
                vals[i] = v;
                i++;
            }

            quickSelect(vals, 0, n - 1, n - k);
            return Arrays.copyOfRange(vals, n - k, n);
        }

        public void quickSelect(int[] vals, int lo, int hi, int k) {

            if (lo == hi) return;
            int partIdx = partition(vals, lo, hi);

            if (partIdx == k) {
                return;
            } else if (partIdx > k) {
                quickSelect(vals, lo, partIdx - 1, k);
            } else {
                quickSelect(vals, partIdx + 1, hi, k);
            }
        }

        public int partition(int[] vals, int lo, int hi) {
            int freq = map.get(vals[hi]);
            int i = lo;
            for (int j = lo; j < hi; j++) {
                if (map.get(vals[j]) < freq) {
                    swap(vals, i, j);
                    i++;
                }
            }
            swap(vals, i, hi);
            return i;
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
