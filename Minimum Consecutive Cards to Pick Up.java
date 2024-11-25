// solution1 brutal force with hashmap o(n^2)
class Solution {
    public int minimumCardPickup(int[] cards) {
        if (cards == null || cards.length < 2) return -1;
        
        int n = cards.length;
        int res = n + 1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int l = 0, r = 0; r < n; r++) {
            cnt.put(cards[r], cnt.getOrDefault(cards[r], 0) + 1);
            if (cnt.get(cards[r]) >= 2) {
                while (cnt.get(cards[r]) >= 2) {
                    cnt.put(cards[l], cnt.get(cards[l]) - 1);
                    l++;
                }
                res = Math.min(res, r - (l - 1)+ 1);
            }
        }
        return res == n + 1 ? -1 : res;
    }
}

//Solution2 update idx O(n)
class Solution {
    public int minimumCardPickup(int[] cards) {
        if (cards == null || cards.length < 2) return -1;
        
        int n = cards.length;
        int res = n + 1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (cnt.containsKey(cards[i])) {
                res = Math.min(res, i - cnt.get(cards[i]) + 1);
            }
            cnt.put(cards[i], i);
        }
        return res == n + 1 ? -1 : res;
    }
}
