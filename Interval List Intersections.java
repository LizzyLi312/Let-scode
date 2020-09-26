class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //cc
        List<int[]> res = new ArrayList<>();
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        int startMax, endMin;
        while(i < m && j < n){
            startMax = Math.max(A[i][0], B[j][0]);
            endMin = Math.min(A[i][1], B[j][1]);
            if(endMin >= startMax){
                res.add(new int[] {startMax, endMin});
            }
            if(A[i][1] == endMin) i++;
            if(B[j][1] == endMin) j++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
