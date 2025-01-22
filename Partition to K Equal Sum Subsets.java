class Solution {
    int s, n;
    boolean[] st;
    int[] nums;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        this.nums = nums;
        n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        s = sum / k;
        Arrays.sort(this.nums);
        reverse(); // cut branch 
        st = new boolean[n];
        return dfs(k, 0, 0);
    }

    private boolean dfs(int k, int idx, int curSum) {
        if (k == 0) return true;
        if (curSum > s) return false;
        if (curSum == s) return dfs(k - 1, 0, 0); // we need to start from 0 since there might be element before idx has not used yet

        for (int i = idx; i < n; i++) {
            if (st[i]) continue;
            if (curSum + nums[i] <= s) {
                st[i] = true;
                if (dfs(k, i + 1, curSum + nums[i])) return true;
                st[i] = false;
            }
        }
        return false;
    }

    private void reverse() {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
