class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] g = new List[n];
        boolean[] inQ = new boolean[n];
        double[] prob = new double[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0], b = edge[1];
            double p = succProb[i];
            g[a].add(new double[]{(double)b, p});
            g[b].add(new double[]{(double)a, p});
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(start_node);
        inQ[start_node] = true;
        prob[start_node] = 1;
        while (!que.isEmpty()) {
            int t = que.poll();
            inQ[t] = false;

            for (double[] child : g[t]) {
                int node = (int)child[0];
                double pb = child[1];
                if (prob[node] < prob[t] * pb) {
                    prob[node] = prob[t] * pb;
                    if (!inQ[node]) {
                        inQ[node] = true;
                        que.offer(node);
                    }
                }
            }
        }
        return prob[end_node];
    }
}
