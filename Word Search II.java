//using trie to find the string. start with. find the prefix
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res){
        int row = board.length, col = board[0].length;
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) return; // c is processed || c is not a next for current character; which means it cannot build a word
        p = p.next[c - 'a'];
        if(p.word != null){ //we found one 
            res.add(p.word);
            p.word = null; //marked as found. in case put it in the res list again
        }
        board[i][j] = '#'; //marked as visited 
            if (i > 0) dfs(board, i - 1, j ,p, res); 
            if (j > 0) dfs(board, i, j - 1, p, res);
            if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
            if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
            board[i][j] = c;
    }
    private TrieNode buildTrie(String[] words){ //build the trie based on the given dict
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode p = root;
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
//time: O(min(m*n, y)*mn) y is the longest word length; since the for loop in the findwords function is m*n. dfs is m * n but the longest would just be y so the result is that
