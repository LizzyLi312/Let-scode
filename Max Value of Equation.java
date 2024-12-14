class Solution {
    // yi + yj + xj - xi -> yi-xi + yi + yj
    public int findMaxValueOfEquation(int[][] points, int k) {
        if (points == null || points.length == 0) return 0;

        Deque<Integer> dq = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            while (!dq.isEmpty() && points[i][0] - points[dq.peekFirst()][0] > k) { // check if it satisfy k range 
                dq.pollFirst();
            }

            if (!dq.isEmpty()) {
                res = Math.max(res, points[dq.peekFirst()][1] - points[dq.peekFirst()][0] + points[i][0] + points[i][1]);
            }

            while (!dq.isEmpty() && points[i][1] - points[i][0] >= points[dq.peekLast()][1] - points[dq.peekLast()][0]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return res;
    }
}
