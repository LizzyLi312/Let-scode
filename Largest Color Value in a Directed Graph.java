// topological sort 
class Solution {
    List<Integer>[] g;
    int[] d;
    boolean[] st;
    int n;
    String s;
    public int largestPathValue(String colors, int[][] edges) {
        n = colors.length();
        g = new List[n];
        d = new int[n];
        st = new boolean[26];
        s = colors;
 
        // build graph      
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int in = edge[0], out = edge[1];
            g[in].add(out);
            d[out]++;
            st[colors.charAt(in) - 'a'] = true;
            st[colors.charAt(out) - 'a'] = true;
        }
      
        int res = 1; // min will be 1 if there is no circle 
        for (int i = 0; i < 26; i++) {
            if (!st[i]) continue;
            int t = topSort(i);
            if (t == -1) return -1;
            res = Math.max(res, t);
        }
        return res;
    }

    private int topSort(int k) {
        Queue<Integer> que = new LinkedList<>();
        int[] de = d.clone();

        int[] dist = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (de[i] == 0) { // look for starting points
                que.offer(i);
                dist[i] = s.charAt(i) - 'a' == k ? 1 : 0;
                res = Math.max(res, dist[i]);
            }
        }
        int tot = 0; // check if there is circle 
        while (!que.isEmpty()) {
            int t = que.poll();
            tot++;
            for (int child : g[t]) {
                dist[child] = Math.max(dist[child], dist[t] + (s.charAt(child) - 'a' == k ? 1 : 0));
                if (--de[child] == 0) que.offer(child); // cutting edge 
                res = Math.max(res, dist[child]);
            }
        }
        return tot == n ? res : -1;
    }
}
