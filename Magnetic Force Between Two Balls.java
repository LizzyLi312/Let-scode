class Solution {
    public int maxDistance(int[] position, int m) {
        if (position == null || position.length == 0) return -1;

        Arrays.sort(position);

        int l = 0, r = (int) 1e9;
        while (l < r) { 
            int mid = l + (r - l + 1) / 2;
            if (check(position, mid, m)) l = mid; //looking for the maximum number so push to the right 
            else r = mid - 1;
        } 
        return r;
    }

    private boolean check(int[] positions, int mid, int m) {
        int count = 1, idx = 0;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - positions[idx] >= mid) {
                count++;
                idx = i;
            }
        }
        if (count >= m) return true;
        else return false;
    }
}
