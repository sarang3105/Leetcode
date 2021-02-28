import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @link
 */
public class SearchInRotated {
    public static void main(String[] args) {

    }

    static class Solution {
        public int search(int[] nums, int t) {

            int start = 0, end = nums.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == t) {
                    return mid;
                } else if (nums[mid] >= nums[start]) {
                    if (nums[mid] >= t && nums[start] <= t) {
                        end = mid -1;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] <= nums[start]) {
                    if (nums[mid] < t && nums[end] >= t) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
