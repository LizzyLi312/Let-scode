class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;

        int[] heights = new int[n];
        int res = 0;
        for (int k = 0; k < m; k++) {
            for (int j = 0; j < n; j++) {
                if (matrix[k][j] == '1') heights[j]++; 
                else heights[j] = 0; //if there no 1 in current position we need to set it to 0 otherwise it cannot be a rectangle shape 
            }
            Stack<Integer> st = new Stack<>();
            
            for (int i = 0; i <= n; i++) {
                int x = i == n ? 0 : heights[i];
                while (!st.isEmpty() && heights[st.peek()] > x) {
                    int idx = st.pop();
                    int height = heights[idx];
                    int w;
                    if (st.isEmpty()) w = i - (-1) - 1;
                    else w = i - st.peek() - 1;
                    res = Math.max(res, height * w);
                }
                st.push(i);
            }
        }
        return res;
    }
}
