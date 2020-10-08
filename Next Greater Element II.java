//using stack to store a decresing array. when we find the number which is larger than the peek one. we find the next greater element 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len * 2; i++){ //loop 2 times to make sure we take care of every number
            while(!stack.empty() && nums[stack.peek()] < nums[i % len]){  //using mod to location the element 
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
