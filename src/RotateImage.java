import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    static class Solution {
        public void rotate(int[][] m) {
            int n = m.length - 1;
            for (int r = 0; r <= n / 2; r++) {
                for (int c = r; r < n - r; r++) {
                    int temp = m[n - c][r];
                    m[n - c][r] = m[n - r][n - c];
                    m[n - r][n - c] = m[c][n - r];
                    m[c][n - r] = m[r][c];
                    m[r][c] = temp;
                }
            }
        }
    }
}
