class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 0, r = (int) 1e5;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(n, quantities, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private boolean check(int n, int[] q, int mid) {
        int count = 0;
        if (mid == 0) return false;
        for (int i = 0; i < q.length; i++) {
            int a = q[i] / mid; // 11 / 2 = 5
            int b = q[i] % mid; // 11 % 2 = 1
            if (b != q[i]) {
                count += b == 0 ? a : (a + 1);
            }
            else count += 1; 
        }
        return count <= n;
    }
}
