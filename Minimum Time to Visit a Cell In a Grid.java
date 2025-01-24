// Dijkstra's algorithm is a shortest path algorithm that finds the minimum distance from a starting node (source) to all other nodes in a graph.
class Solution {
    public int minimumTime(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1; // if the grid surround the origin point are bigger than 1 then we cannot move 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // use wait time to be the compasion factor 
        pq.offer(new int[]{grid[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int time = t[0], x = t[1], y = t[2];

            if (x == n - 1 && y == m - 1) return time;

            for (int[] dir : dirs) {
                int a = x + dir[0];
                int b = y + dir[1];
                if (a < 0 || a >= n || b < 0 || b >= m || visited[a][b]) continue;
                visited[a][b] = true;
                int wait = ((grid[a][b] - time) % 2 == 0) ? 1 : 0;
                /* If time for a neighbor (target) cell is > 1 + time for current cell. We can not directly move to target cell. We will have to "ping pong" between previous cell and current cell. When playing ping pong between previous and current cell there can be two cases.
Let's say time for target cell is 4 and current time is 2, difference = 2 (even).
Move to prev cell, time = 3
Move to curr cell, time = 4
Move to target cell, time = 5.
Hence we reach target cell with time: target cell time + 1 when difference between target cell time and curr cell time is even.
Let's say time for target cell is 5 and current time is 2, difference = 3 (odd).
Move to prev cell, time = 3
Move to curr cell, time = 4
Move to target cell, time = 5.
Hence we reach target cell with time: target cell time when difference between target cell time and curr cell time is odd.
This "ping pong" is captured in the wait variable in the code
                */
                pq.offer(new int[]{Math.max(time + 1, grid[a][b] + wait), a, b}); // if grid[a][b] is smaller than current time then we need to put time + 1 to reach it 
            }
        }
        return -1;
    }
}
