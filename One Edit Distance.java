//only works for there is one character difference between s nd t
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){ //we found the different character between two strings
            //	substring(int beginIndex) [beginIdx, s.length())
                if(s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i  +1)); //check after replace this character the rest of the strings.
                else if(s.length() < t.length()) return s.substring(i).equals(t.substring(i + 1)); //check delete character from t
                else return t.substring(i).equals(s.substring(i + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1; //do they really have a length difference of 1
    }
}
//time: O(min(s.length(), t.length()))
