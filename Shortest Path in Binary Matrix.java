class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        grid[0][0] = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        int count = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return count + 1;
                for(int[] dir : dirs){
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0){
                        que.offer(new int[]{i,j});
                        grid[i][j] = 1;
                    }
                }
            }
            count++;
        }
        return -1; //do not need to check count == 1. since if we can reach it then it must be returned in the while loop
    }
}
