class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String s = "#" + words[i];
            for (int j = words[i].length() - 1; j >= 0; j--) { // store words with suffix in trie 
                s = words[i].charAt(j) + s;
                insert(s, i);
            }
        }
    }
    
    public int f(String pref, String suff) {
        return search(suff + "#" + pref);
    }

    private void insert(String s, int idx) {
        TrieNode p = root;
        for (char c : s.toCharArray()) {
            int u = c == '#' ? 26 : c - 'a';
            if (p.next[u] == null) p.next[u] = new TrieNode();
            p = p.next[u];
            p.id = idx;
        }
    }

    private int search(String s) {
        TrieNode p = root;
        for (char c : s.toCharArray()) {
            int u = c == '#' ? 26 : c - 'a';
            if (p.next[u] == null) return -1;
            p = p.next[u];
        }
        return p.id;
    }

    class TrieNode {
        int id;
        TrieNode[] next;
        public TrieNode() {
            this.next = new TrieNode[27]; // 26 english letters + #
            this.id = 0;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
