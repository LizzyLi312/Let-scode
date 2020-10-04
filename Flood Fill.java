class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0] == null || image[0].length == 0) return image;
        Queue<int[]> que = new LinkedList<>();
        int original = image[sr][sc];
        que.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{1,0}, {-1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[image.length][image[0].length]; //need to add visited, otherwise it will casue dead loop when the new color is the original color
        visited[sr][sc] = true;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int[] dir: dirs){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == original && !visited[i][j]){
                    que.offer(new int[]{i, j});
                    image[i][j] = newColor;
                    visited[i][j] = true;
                }
            }
        }
        return image;
    }
}
