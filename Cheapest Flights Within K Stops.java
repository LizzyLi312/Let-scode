// solution1: dijstra
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] g = new List[n];
        int[][] cost = new int[n][K + 2];
        
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            Arrays.fill(cost[i], 0x3f3f3f);
        }
        cost[src][0] = 0;

        for (int [] flight : flights) {
            int a = flight[0], b = flight[1], c = flight[2];
            g[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int price = t[0], stop = t[1], node = t[2];
            
            if (node == dst) return price;
            if (stop == K + 1) continue; // we need to check this after checking node == dst since when stop = k + 1 and if we met dst the it will skip the right answer 
            
            for (int[] child : g[node]) {
                int a = child[0], b = child[1]; //node, cost
                if (price + b < cost[a][stop + 1]) {
                        cost[a][stop + 1] = price + b;
                        pq.offer(new int[]{price + b, stop + 1, a});
                    }
                }
        }
        return -1;
    }
}

// solution2 bellman ford
