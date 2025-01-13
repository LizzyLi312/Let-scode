class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
            p = p.next[c - 'a'];
        }
        p.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }
        return p.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            if (p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        public TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
