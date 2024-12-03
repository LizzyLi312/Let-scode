class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        if (queries == null || queries.length == 0) return new int[]{};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if (maxHeap.size() == k) {
                int curMax = maxHeap.poll();
                maxHeap.offer(Math.min(curMax, dist));
            } else {
                maxHeap.offer(dist);
            }
            if (maxHeap.size() < k) res[i] = -1;
            else res[i] = maxHeap.peek();
        }
        return res;
    }
}
