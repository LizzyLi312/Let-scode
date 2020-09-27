class Solution {
    public int islandPerimeter(int[][] grid) {
        //cc
        int count = 0;
        for(int i = 0; i < grid.length; i++){ //O(m * n * (m + n))
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int neis = findNeis(grid, i, j);
                    count += 4 - neis;
                }
                else continue;
            }
        }
        return count;
    }
    private int findNeis(int[][] grid, int row, int col){
        int count = 0;
        for(int i = 0; i < grid.length; i++){ //O(m)
            if(grid[i][col] == 1 && Math.abs(row - i) == 1) count++;
        }
        for(int i = 0; i < grid[0].length; i++){ //O(n)
            if(grid[row][i] == 1 && Math.abs(col - i) == 1) count++;
        }
        return count;
    }
}

//count how many water is adjacent 
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) num++; // UP
                    if (j == 0 || grid[i][j - 1] == 0) num++; // LEFT
                    if (i == rows -1 || grid[i + 1][j] == 0) num++; // DOWN
                    if (j == cols -1 || grid[i][j + 1] == 0) num++; // RIGHT
                }
            }
        }
        return num;
    }
    
}
