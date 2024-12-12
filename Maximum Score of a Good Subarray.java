// sliding window 
class Solution {
    public int maximumScore(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int res = 0;
        int min = nums[k];
        int l = k, r = k;
        while (l >= 0 && r < nums.length) {
            min = Math.min(min, Math.min(nums[l], nums[r]));
            res = Math.max(res, min * (r - l + 1));

            // move to the side that has taller height to maintain the max area
            if (l == 0 && r < nums.length) {
                r++;
            } else if (r == nums.length - 1 && l >= 0) {
                l--; 
            } else if (nums[l - 1] > nums[r + 1]) {
                l--;
            } else {
                r++;
            }
        }
        return res;
    }
}
