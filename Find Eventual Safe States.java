class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] g = new List[n];
        int[] out = new int[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int x : graph[i]) {
                g[x].add(i); // i is pointing to x, 
                out[i]++; //here we use outdegree based on the question 
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (out[i] == 0) que.offer(i); //look for start points
        }

        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int t = que.poll();
            ans.add(t);
            for (int p : g[t]) {
                if (--out[p] == 0) que.offer(p);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
