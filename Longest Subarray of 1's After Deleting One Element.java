class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int res = 0;
        int cnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] == 0) cnt++;
            while (cnt > 1) {
                if (nums[j] == 0) cnt--;
                j++;
            }
            res = Math.max(res, i - j + 1 - 1);
        }
        return res;
    }
}
