class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int n = grid.length, m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0});
        int step = 0;
        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] temp = que.poll();
                int x = temp[0], y = temp[1];
                if (x == n - 1 && y == m - 1 && k >= temp[2]) return step;
                if (temp[2] > k) continue;
                for (int[] dir : dirs) {
                    int a = x + dir[0], b = y + dir[1];
                    if (a < 0 || a >= n || b < 0 || b >= m) continue;
                    int ob = temp[2] + (grid[a][b] == 1 ? 1 : 0);
                    if (ob > k) continue;
                    if (visited[a][b][ob]) continue;
                    
                    que.offer(new int[]{a, b, ob});
                    visited[a][b][ob] = true;

                }
            }
            step++;
        }
        return -1;
    }
}
