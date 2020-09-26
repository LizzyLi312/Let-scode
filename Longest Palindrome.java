class Solution {
    public int longestPalindrome(String s) {
        //cc
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(s.charAt(i))){
                set.add(c);
            }
            else{
                count++;
                set.remove(c);
            }
        }
        return set.size() > 0 ? count * 2 + 1 : count * 2;
    }
}
//int[] as counter works the same
