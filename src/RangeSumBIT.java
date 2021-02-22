/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link
 */
public class RangeSumBIT {
    public static void main(String[] args) {
        NumArray a = new NumArray(new int[]{9, 8});
    }

    static class NumArray {

        private int[] nums;
        private int[] BIT;
        private int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.BIT = new int[n + 1];
            for (int i = 0; i < n; i++) {
                updateBIT(i, nums[i]);
            }
        }

        public void update(int idx, int val) {
            int d = val - nums[idx];
            updateBIT(idx, d);
            nums[idx] = val;
        }

        public void updateBIT(int idx, int val) {
            idx = idx + 1;
            while (idx <= n) {
                BIT[idx] += val;
                idx += idx & -idx;
            }
        }

        public int sumRange(int left, int right) {
            return sum(right) - sum(left - 1);
        }

        public int sum(int idx) {
            idx = idx + 1;
            int sum = 0;
            while (idx > 0) {
                sum += BIT[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}
