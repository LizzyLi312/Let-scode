//solution1: spfa using queue
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new List[n];
        int[] dist = new int[n];

        /*
        0x3f3f3f is often used to represent a large number (but not too large) to act as a substitute for infinity. It’s large enough to be considered infinity in most graphs but small enough to avoid integer overflow when performing additions.
        */

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        for (int[] ed : edges) {
            int u = ed[0], v = ed[1], w = ed[2] + 1;
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        /*
        In SPFA, a node may be updated multiple times if a shorter path is found. Instead of marking nodes as permanently visited, we use inQueue to prevent duplicate additions to the queue.
        */
        Queue<Integer> que = new LinkedList<>();
        boolean[] inQ = new boolean[n];
        que.offer(0);
        inQ[0] = true;

        while (!que.isEmpty()) {
            int t = que.poll();
            inQ[t] = false;
            for (int[] conn : g[t]) {
                int b = conn[0], w = conn[1];
                if (dist[b] > dist[t] + w) { // the point will not be added to the queue when all the dist are the shortest 
                    dist[b] = dist[t] + w;
                    if (!inQ[b]) {
                        inQ[b] = true;
                        que.offer(b);
                    }
                }
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) res++;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int a = Math.max(0, maxMoves - dist[u]);
            int b = Math.max(0, maxMoves - dist[v]);

            res += Math.min(a + b, w);
        }
        return res;
    }
}
