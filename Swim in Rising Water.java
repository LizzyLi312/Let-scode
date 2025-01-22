class Solution {
    int n;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] st;
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        n = grid.length;
        int l = 0, r = n * n - 1; 
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, grid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private boolean check(int mid, int[][] grid) {
        st = new boolean[grid.length][grid[0].length];
        if (grid[0][0] > mid) return false; // if t is smaller than grid[0][0], then it will not flow out of origin point

        return dfs(mid, grid, 0, 0);
    }

    private boolean dfs(int mid, int[][] grid, int x, int y) {
        if (x == n - 1 && y == n - 1) return true;
        st[x][y] = true;

        for (int[] dir : dirs) {
            int a = dir[0] + x, b = dir[1] + y;
            if (a < 0 || a >= n || b < 0 || b >= n) continue;
            if (st[a][b]) continue;
            if (grid[a][b] > mid) continue;
            if (dfs(mid, grid, a, b)) return true;
        }
        //st[x][y] = false; we do not need to back trace this since the visted point x,y has no way to reach to right bottom corner 
        return false;
    }
}
