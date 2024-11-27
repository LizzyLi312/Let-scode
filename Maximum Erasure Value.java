class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] sum = new int[n + 1];
        int min = nums[0];
        for (int i = 1; i < n + 1; i++) {
            if (i != n) min = Math.min(min, nums[i]);
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        HashSet<Integer> set = new HashSet<>();
        int res = 0;

        for (int r = 0, l = 0; r < nums.length; r++) {
            if (set.contains(nums[r])) {
                res = Math.max(res, sum[r - 1 + 1] - sum[l + 1 - 1]); //r = 2, l = 0
                while (set.contains(nums[r])) {
                    set.remove(nums[l++]);
                }
            }
            set.add(nums[r]);
            if (r == n - 1) res = Math.max(res, sum[r + 1] - sum[l + 1 - 1]); // need to post processing when r hits the end 
        }
        return res == 0 ? sum[n + 1] - min : res;
    }
}

//solution2 using hashmap to store the indx and move l to the last occurence idx + 1
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0, n = nums.length, sum = 0;
        HashMap<Integer, Integer> idx = new HashMap<>();

        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            if (idx.containsKey(nums[r])) {
                while (l < n && idx.containsKey(nums[r])) {
                    sum -= nums[l];
                    idx.remove(nums[l++]);
                }
            }
            idx.put(nums[r], r);
            res = Math.max(sum, res);
        }
        return res;
    }
}
