class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        HashSet<String> set = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){ //sort the words by the length
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        for(int i = 0; i < words.length; i++){
            if(canForm(set, words[i])) res.add(words[i]);
            set.add(words[i]);
        }
        return res;
    }
    private boolean canForm(HashSet<String> set, String word){
        if(set.isEmpty()) return false; //corner case: the first time chekcing 
        boolean[] dp = new boolean[word.length() + 1]; //word break I
        dp[0] = true; //use memory to optimize the process 
        for(int i = 1; i <= word.length(); i++){ //check[j, i)
            for(int j = 0; j < i; j++){
                if(!dp[j]) continue;
                if(set.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
//time: O(nlogn + n ^2) = O(n^2)
