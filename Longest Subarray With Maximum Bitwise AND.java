// solution: look for the max value, track consecutive subarrays of this maximum value, and return the length of the longest such subarray.

class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int cnt = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                cnt++;
                res = Math.max(res, cnt);
            } else cnt = 0;
        }
        return res;
    }
}
