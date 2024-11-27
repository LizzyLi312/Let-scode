//[l, r] is the longest subarray with k unique numbers, and
// [m, r] is the shortest subarray with k unique numbers,

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0, sz = nums.length;
        int[] cnt = new int[sz + 1];
        for (int l = 0, m = 0, r = 0; r < sz; ++r) {
            cnt[nums[r]]++;
            if (cnt[nums[r]] == 1) { // there is a new unique integer in [m, r]
                k--;
                if (k < 0) { // we already have k + 1 unique integer in [m, r]
                    cnt[nums[m]] = 0; // need to do m++ to remove the leftest unique integer 
                    m++;
                    l = m; // and move left to m to find the new prefix 
                    k++; // 
                }
            }
            if (k <= 0) {
                while (cnt[nums[m]] > 1) { // m will always be the left boundary of the minimal subarray that contains k unique elements 
                    cnt[nums[m]]--;
                    m++;
                }
                    
                res += m - l + 1; // using m - l + 1 elements as prefix + [m, r]  
            }
        }    
        return res;
    }
}
