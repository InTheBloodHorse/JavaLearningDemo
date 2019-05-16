package inthebloodhorse.algorithm.string;

import java.util.*;

/*
    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

    示例:

    输入:
    words = ["oath","pea","eat","rain"] and board =
    [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]

    输出: ["eat","oath"]
 */
class TrieNode {
    public Map<Integer, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

public class FindWords {

    private TrieNode root;


    private void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children.get(index) == null) {
                p.children.put(index, new TrieNode());
            }
            p = p.children.get(index);
        }
        p.isWord = true;
    }

    private boolean search(String word) {
        TrieNode p = find(word);
        return p != null && p.isWord == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children.get(index) == null) {
                return null;
            }
            p = p.children.get(index);
        }
        return p;
    }


    private int n, m;

    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int[][] vis;

    private boolean judge(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private void dfs(char[][] board, StringBuilder stringBuilder, int x, int y, List<String> ans) {
        vis[x][y] = 1;
        if (startsWith(stringBuilder.toString()) == false) return;
        if (search(stringBuilder.toString()) == true) {
            ans.add(stringBuilder.toString());
        }
        for (int i = 0; i < 4; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];
            if (judge(nX, nY) && vis[nX][nY] == 0) {
                StringBuilder ne = new StringBuilder(stringBuilder.append(board[nX][nY]));
                dfs(board, ne, nX, nY, ans);
                stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
                vis[nX][nY] = 0;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        Map<Integer, Integer> head = new HashMap<>();
        for (String word : words) {
            head.put(word.charAt(0) - 'a', 1);
            insert(word);
        }
        n = board.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            m = board[i].length;
            for (int j = 0; j < m; j++) {
                if (head.get(board[i][j] - 'a') != null) {
                    vis = new int[n + 5][m + 5];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(board[i][j]);
                    dfs(board, stringBuilder, i, j, ans);
                }
            }
        }
        Set<String> set = new HashSet<>(ans);
        List<String> result = new ArrayList<>(set);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b'}, {'a', 'a'}
        };
        String[] st = new String[]{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        System.out.println(new FindWords().findWords(board, st));
    }
}
