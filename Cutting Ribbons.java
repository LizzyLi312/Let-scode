class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 0, r = (int) 1e5;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(ribbons, k, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    private boolean check(int[] r, int k, int mid) {
        int count = 0;
        
        for (int i = 0; i < r.length; i++) {
            int a = r[i] / mid;
            count += a; 
        }
        return count >= k;
    }
}
