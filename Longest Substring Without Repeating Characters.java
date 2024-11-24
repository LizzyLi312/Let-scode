class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int l = 0, r = 0, res = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while(r < n) { // we do not need l < n here
            if (!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            } 
            else {
                set.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r - l); // the result is [l, r)
        }
        return res;
    }
}
