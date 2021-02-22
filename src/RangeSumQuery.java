import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQuery {
    static class NumArray {

        private int[] prefix;

        public NumArray(int[] nums) {
            if (nums.length != 0) {
                this.prefix = new int[nums.length + 1];
                prefix[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    prefix[i] = prefix[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return prefix[j];
            }
            return prefix[j] - prefix[i - 1];
        }
    }
}
