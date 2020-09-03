class Solution {
    public int maximumMinimumPath(int[][] A) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[0] - a[0];
            }
        });
        pq.offer(new int[] {A[0][0], 0, 0});
        int maxScore = A[0][0];
        A[0][0] = -1; //mark as visited
        while(!pq.isEmpty()){ 
            int[] top = pq.poll();
            int i = top[1], j = top[2], n = A.length, m = A[0].length;
            maxScore = Math.min(maxScore, top[0]);
            if(i == n - 1 && j == m - 1) break;
            for(int [] dir : dirs){
                int row = dir[0] + i, col = j + dir[1];
                if(row >= 0 && row < n && col >= 0 && col < m && A[row][col] >= 0){
                    pq.add(new int[]{A[row][col], row, col});
                    A[row][col] = -1;
                }
            }
        }
        return maxScore;
    }
}

//dijkstra.
//time: O(m*nlog(m + n))
