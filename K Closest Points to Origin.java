class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) return new int[][]{};

        int n = points.length;
        long[][] dist = new long[n][2];

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            long d = (long) (x * x + y * y); // do not use sqrt since it will fail at comparsion
            dist[i] = new long[]{d, i};
        }

        long t = quickSelect(dist, 0, points.length - 1, K);

        int[][] res = new int[K][2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i][0] <= t) res[idx++] = points[(int) dist[i][1]];
        }
        return res;
    }

    private long quickSelect(long[][] dist, int l, int r, int k) {
        if (l >= r) return dist[r][0];
        long pivot = dist[l + (r - l) / 2][0];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (dist[++i][0] < pivot);
            while (dist[--j][0] > pivot);
            if (i < j) swap(dist, i, j);
        }

        if (j - l + 1 >= k) return quickSelect(dist, l, j, k);
        return quickSelect(dist, j + 1, r, k - (j - l + 1));
    }

    private void swap(long[][] dist, int i, int j) {
        long[] t = dist[i];
        dist[i] = dist[j];
        dist[j] = t;
    }
}
