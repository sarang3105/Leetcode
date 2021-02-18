import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link
 */
public class LCPTrie {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            Trie t = new Trie();
            for (String s: strs) {
                t.insert(s);
            }
            return t.search(strs[0]);
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public String search(String c) {
            StringBuilder sb = new StringBuilder();
            TrieNode t = root;
            for (char i: c.toCharArray()) {
                if (t.contains(i) && t.children.size() == 1) {
                    sb.append(i+"");
                    t = t.get(i);
                    continue;
                }
                break;
            }
            return sb.toString();
        }

        public void insert(String s) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                if (!temp.contains(s.charAt(i))){
                    temp.addChar(s.charAt(i));
                }
                temp = temp.get(s.charAt(i));
            }
            temp.setWordEnd(true);
        }

        static class TrieNode {
            private Map<Character, TrieNode> children;
            private boolean wordEnd;

            public TrieNode() {
                this.children = new HashMap<>();
                this.wordEnd = false;
            }

            public void setWordEnd(boolean wordEnd) {
                this.wordEnd = wordEnd;
            }
            public void addChar(char c) {
                children.put(c, new TrieNode());
            }
            public TrieNode get(char c) {
                return children.get(c);
            }
            public boolean contains(char c) {
                if (children.containsKey(c)) {
                    return true;
                }
                return false;
            }
        }
    }
}
