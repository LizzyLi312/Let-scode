class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == k) return k;
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                if (sum[i][j] == k) return k;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int row1 = 0; row1 < m; row1++) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int row2 = row1; row2 < m; row2++) { // needs to make sure point2 is always bigger than points 1
                    for (int col2 = col1; col2 < n; col2++) {
                        int a = sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1 + 1 - 1] - sum[row1 + 1 - 1][col2 + 1] + sum[row1][col1];
                        if (a == k) return k;
                        if (a < k && a > res) res = a;
                    }
                }
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
