import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"flow", "flows", "flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            Arrays.sort(strs);
            if (n == 0) return "";
            String str = strs[0];
            int s = 0, e = str.length() - 1, l = 0;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (check(strs, str.substring(0, mid + 1), n)) {
                    l = mid + 1;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            return str.substring(0, l);
        }

        private boolean check(String[] str, String pre, int n) {
            for (int i = 1; i < n; i++) {
                if (!str[i].startsWith(pre)) {
                    return false;
                }
            }
            return true;
        }
    }
}
