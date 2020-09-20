//bfs
class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return -1;
        Queue<Integer> que = new LinkedList<>();
        int row = board.length, col = board[0].length;
        que.offer(1);
        int min = 0;
        boolean[] visited = new boolean[row * col + 1];
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int temp = que.poll();
                if(visited[temp]) continue;
                visited[temp] = true;
                if(temp == row * col) return min;
                for(int i = 1; i <= 6 && temp + i <= row * col; i++){
                    int next = temp + i;
                    int val = getBoardVal(board, next);
                    if(val > 0) next = val;
                    if(!visited[next]) que.offer(next);
                }
            }
            min++;
        }
        return -1;
    }
    private int getBoardVal(int[][] board, int num){
        int n = board.length;
        int r = (num - 1) / n; //new row number from the bottom
        int x = n - 1 - r; 
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num; //even number col is different from odd number col
        return board[x][y];
    }
}

//time: O(col * row)
