class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        if (k > n) return 0;

        int[] cnt = new int[26];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++; // need to add it to the set first and then process
            while (cnt[s.charAt(i) - 'a'] > 1) {
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
            if (i - j + 1 == k) {
                res += 1;
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
        }
        return res;
    }
}
