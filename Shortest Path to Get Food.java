class Solution {
    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int n = grid.length, m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') start = new int[]{i, j};
            }
        }
        que.offer(start);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start[0] * m + start[1]);
        int step = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] temp = que.poll();
                if (grid[temp[0]][temp[1]] == '#') return step;
                for (int[] dir : dirs) {
                    int x = temp[0] + dir[0], y = temp[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited.contains(x * m + y) || grid[x][y] == 'X') continue;
                    visited.add(x * m + y);
                    que.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}
