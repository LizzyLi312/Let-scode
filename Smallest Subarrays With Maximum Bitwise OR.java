/*
how do we get 30?  
log 2(10)≈3.32 bits => 2^(3.32) ~= 10
*/

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int[] pos = new int[30]; // the nearest idx which can make bit j position 1 from i 
        int n = nums.length;
        int[] res = new int[n]; 
        Arrays.fill(pos, -1);
        for (int i = n - 1; i >= 0; i--) { //backward checking since we need the last time occurrence of 1
            int t = i;
            for (int j = 0; j < 30; j++) {
                if ((nums[i] >> j & 1) == 1) pos[j] = i; //updating the nearest 1 position 
                else if (pos[j] != -1) t = Math.max(t, pos[j]); // if it is not 1 and a elements that is on the right side of i can make this element to 1; update t to that idx
            }
            res[i] = t - i + 1;
        }
        return res;
    }
}
