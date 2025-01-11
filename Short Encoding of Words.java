//solution1 remove prefix 
class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) return 0;

        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }
}

//solution2 trie 
class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) return 0;

        int res = 1;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            
            boolean newWord = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (p.isEnd && !newWord) res -= (word.length() - i); // if we visit a old word which is the prefix of this new word, we need to subtract it from answer
                if (p.next[word.charAt(i) - 'a'] == null) { // expand what we have in the trie
                    p.isEnd = false;
                    newWord = true;
                    p.next[word.charAt(i) - 'a'] = new TrieNode();
                }
                p = p.next[word.charAt(i) - 'a'];
            }
            if (newWord) res += word.length() + 1;
        }
        return res;
    }

    class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        public TrieNode() {
            next = new TrieNode[26];
            isEnd = true;
        }
    }
}
