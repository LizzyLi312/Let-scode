class Solution {
    public int maxArea(int[] height) {
        //cc
        int i = 0, j = height.length - 1;
        int max = 0;
        while(i < j){
            int temp = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(temp, max);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
}
