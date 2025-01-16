//solution1: binary search + bfs
class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return 0;
        int l = 0, r = (int) 1e6;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPath(mid, heights)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean isPath(int effort, int[][] heights) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> que = new LinkedList<>();

        int n = heights.length;
        int m = heights[0].length;

        que.offer(new int[2]);
        visited.add(0);
        while (!que.isEmpty()) {
            int[] d = que.poll();
            if (d[0] == n - 1 && d[1] == m - 1) return true;
            for (int[] dir : dirs) {
                int x = d[0] + dir[0];
                int y = d[1] + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                // do not mark the location as seen when effort does not meet the requirement
                if (Math.abs(heights[x][y] - heights[d[0]][d[1]]) <= effort && visited.add(x * m + y)) que.offer(new int[]{x, y});
            }
        }
        return false;
    }
}
