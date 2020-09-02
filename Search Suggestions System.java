//TreeMap. if A[i] is the prefix of the A[j] then a[i] is the prefix of a[i + 1], a[i + 2]...a[j-1]. 
//so we can use binary search to find the boundary 
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);
        for(int i = 0; i < products.length; i++){
            map.put(products[i], i);
        }
        String key = "";
        for(char c : searchWord.toCharArray()){
            key += c;
            String ceiling = map.ceilingKey(key); //Returns the least key greater than or equal to the given key, or null if there is no such key.
            String floor = map.floorKey(key + "~"); //Returns the greatest key less than or equal to the given key, or null if there is no such key.
            //add a ~ since we couldn't find a floorkey since when it is the root its the smallest 
            if(ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1))); //min checks if the following 3 are valid
        }
        while(res.size() < searchWord.length()) res.add(new ArrayList<>()); //when there's no word for the charater so the res's size will be smaller than the searchWord
        return res;
    }
}
//time: O(nlogn + nlogn)

//we can also use trie
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for(String p : products){
            insert(p, root);
        }
        return search(searchWord, root);
    }
    private void insert(String p, TrieNode root){ //build Trie. Record the recommedations of every TrieNode
        TrieNode t = root;
        for(char c : p.toCharArray()){
            if(t.sub[c - 'a'] == null) t.sub[c - 'a'] = new TrieNode(); //build trie. if there is a new word then build new nodes
            t = t.sub[c - 'a']; //move to next node
            t.suggestion.offer(p); //offer recommedations
            Collections.sort(t.suggestion); //sort recommedation
            if(t.suggestion.size() > 3) t.suggestion.pollLast(); //if theres more than 3 then poll the last one. maintain 3 minimum strings 
        }
    }
    private List<List<String>> search(String searchWord, TrieNode root){ //dfs search 
        List<List<String>> res = new ArrayList<>();
        for(char c : searchWord.toCharArray()){
            if(root != null) root = root.sub[c - 'a']; //root is not null at first 
            res.add(root == null ? Arrays.asList() : root.suggestion);
        }
        return res;
    }
    class TrieNode{
        TrieNode[] sub = new TrieNode[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
}
//time: O(m * n) since each node we need to do a comparasion
