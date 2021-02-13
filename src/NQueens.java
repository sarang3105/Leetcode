import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link
 */
public class NQueens {

    public static void main(String[] args) {

    }
    static class Solution {
        public List<List<String>> solveNQueens(int n) {

            int[][] board = new int[n][n];
            List<List<String>> ans = new ArrayList<>();
            solve(board, n, 0, 0, ans);
            return ans;
        }

        public void solve(int[][] board, int n, int k, int placed, List<List<String>> ans) {
            if (placed == n) {
                addAnswer(board, ans, n);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (isValid(board, i, k, n)) {
                    board[k][i] = 1;
                    solve(board, n, k + 1, placed + 1, ans);
                    board[k][i] = 0;
                }
            }
        }

        public boolean isValid(int[][] board, int i, int j, int n) {
            if (j == 0) return true;

            for (int r = 0; r < n; r++) {
                if (board[r][i] == 1) return false;
            }

            for (int r = 0; r < n; r++) {
                if (board[j][r] == 1) return false;
            }
            int c = i;
            for (int r = j; r >= 0 && c < n; r--) {
                if (board[r][c] == 1) {
                    return false;
                }
                c++;
            }

            c = i;
            for (int r = j; r >= 0 && c >= 0; r--) {
                if (board[r][c] == 1) {
                    return false;
                }
                c--;
            }
            return true;
        }

        public void addAnswer(int[][] board, List<List<String>> ans, int n) {
            StringBuilder sb = new StringBuilder();
            List<String> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                a.add(sb.toString());
                sb = new StringBuilder();
            }
            ans.add(a);
        }
    }
}
