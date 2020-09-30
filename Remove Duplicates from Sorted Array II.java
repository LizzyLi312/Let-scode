class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 2, fast = 2;
        while(fast < nums.length){
            if(nums[fast] == nums[slow - 2]) fast++;
            else{
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}
