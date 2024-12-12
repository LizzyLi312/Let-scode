// since it is circular so there are 2 cases for max sum 
// 1. the subarray is inside of the whole array 
// 2. the subarray include the end and also the begin of the array (this case we can calculate using sum - minArray)
// so we need to keep the min array and also the max array. but if all the nums in the array are negtive then the max will always be 0; so we need to return the max itself 
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int sum = 0, max = nums[0], min = nums[0], curMax = 0, curMin = 0;

        for (int num : nums) {
            sum += num;
            curMax = Math.max(curMax + num, num);
            max = Math.max(curMax, max);
            curMin = Math.min(curMin + num, num);
            min = Math.min(curMin, min);
        }

        return max > 0 ? Math.max(max, sum - min) : max;
    }
}
