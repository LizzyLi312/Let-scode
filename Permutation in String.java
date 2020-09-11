class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i + s1.length() <= s2.length(); i++){
            if(check(s2.substring(i, i + s1.length()) , s1)) return true;
        }
        return false;
    }
    private boolean check(String s1, String s2){
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0) return false;
        }
        return true;
    }
}
