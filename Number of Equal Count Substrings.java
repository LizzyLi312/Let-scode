class Solution {
    public int equalCountSubstrings(String s, int count) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int n = s.length();

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        
        for (int unique = 1; unique <= set.size(); unique++) {
            int[] cnt = new int[26];
            int window = count * unique; // each unique letter in the substring, it appears exactly count times in the substring. So every words needs to be appear count times 
            int hasCount = 0; // 
            for (int i = 0; i < n; i++) {
                cnt[s.charAt(i) - 'a']++;
                if (cnt[s.charAt(i) - 'a'] == count) hasCount++;
                if (i >= window) {
                    cnt[s.charAt(i - window) - 'a']--;
                    if (cnt[s.charAt(i - window) - 'a'] == count - 1) hasCount--;
                }
                if (hasCount == unique) res++;
            }
        }

        return res;
    }
}
