class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length, curSum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // value, indx

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int a = curSum - k;
            if (a == 0) {
                res = Math.max(res, i + 1);
            } else if (map.containsKey(a)) { // we need to check if there is a subarray's sum is equal to curSum - a if we subtract that part then we will have a subarray has k sum
                res = Math.max(res, i - (map.get(a) + 1) + 1); //i = 5, a = 1, idx = 2, curSum = 1(0, 1, 2)
            }
            if (!map.containsKey(curSum)) map.put(curSum, i);  // we do not need to update idx since the first encounter will make the result longer
            
        }
        return res;
    }
}
