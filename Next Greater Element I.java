class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //cc
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = find(nums1[i], nums2);
        }
        return res;
    }
    private int find(int target, int[] arr){
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            if(flag == true && arr[i] > target){
                return arr[i];
            }
            if(arr[i] == target) flag = true;
        }
        return -1;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); //use a hashmap to store the numer and the next numer who is larger than this 
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num); 
            //if we find the current number is larger than the one in the stack. then the current one is the next larger number for the one in the stack's top
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
