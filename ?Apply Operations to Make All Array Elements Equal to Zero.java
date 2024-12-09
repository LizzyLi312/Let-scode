class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0, s = 0; i < n; i++) {
            s += b[i]; 
            
            if (i + k - 1 >= n && nums[i] != s) return false;
            if (nums[i] < s) return false;

            int t = nums[i] - s;

            s += t;
            if (i + k < n) b[i + k] -= t;
        }
        return true;
    }
}
