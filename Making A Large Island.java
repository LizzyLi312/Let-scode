class Solution {
    int[] sz, p;
    int n;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int res = 0;
        n = grid.length;
        sz = new int[n * n];
        p = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            sz[i] = 1;
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int u = get(i, j);
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        if (grid[x][y] == 0) continue;
                        int v = get(x, y);
                        if (find(u) != find(v)) {
                            sz[find(u)] += sz[find(v)]; // need to add size first 
                            p[find(v)] = find(u);
                        }
                    }
                    res = Math.max(res, sz[find(u)]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int temp = 1;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || y < 0 || x >= n || y >= n) continue;
                        if (grid[x][y] == 0) continue;
                        int v = get(x, y);
                        if (set.add(find(v))) temp += sz[find(v)];
                    }
                    res = Math.max(res, temp);
                }
            }
        }

        return res;
    }

    private int get(int i, int j) {
        return i * n + j;
    }

    private int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
}
