import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link
 */
public class RangeSum {

    static class NumArray {

        private int[] st;
        private int[] nums;
        private int n;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.st = new int[4 * n];
            this.nums = nums;
            build(0, n - 1, 1);
        }

        private void build(int start, int end, int treeIndex) {
            if (start == end) {
                st[treeIndex] = nums[start];
                return;
            }

            int mid = getMid(start, end);
            build(start, mid, left(treeIndex));
            build(mid + 1, end, right(treeIndex));
            st[treeIndex] = st[left(treeIndex)] + st[right(treeIndex)];
        }

        public void update(int index, int val) {
            int v = nums[index];
            nums[index] = val;
            updateTree(0, n - 1, 1, val, v, index);
        }

        private void updateTree(int start, int end, int root, int val, int curr, int index) {
            if(index < start || index > end) {
                return;
            }
            st[root] = (st[root] - curr) + val;
            if (start != end) {
                int mid = getMid(start, end);
                updateTree(start, mid, left(root), val, curr, index);
                updateTree(mid + 1, end, right(root), val, curr, index);
            }
        }
        public int sumRange(int left, int right) {
            return sum(left, right, 0, n - 1, 1);
        }

        private int sum(int left, int right, int start, int end, int root) {
            if (left >= start && right <= end) {
                return st[root];
            } else if (left > end || right < start){
                return 0;
            }

            int mid = getMid(start, end);
            return sum(left, right, start, mid, left(root)) + sum(left, right, mid + 1, end, right(root));
        }

        private int getMid(int i, int j) {
            return (i + j) / 2;
        }

        private int left(int i) {
            return 2 * i;
        }

        private int right(int i) {
            return 2 * i + 1;
        }
    }
}
