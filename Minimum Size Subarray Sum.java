class Solution { //sliding window 
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length, res = n + 1;

        int l = 0, r = 0, curSum = 0;
        while (r < n) {
            curSum += nums[r];
            while (curSum >= target) {
                res = Math.min(res, r - l + 1);
                curSum -= nums[l++];
            }
            r++;
        }
        return res == n + 1 ? 0 : res;
    }
}
