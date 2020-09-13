class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n != 0){ //count the amout of number which has 5 as the factor. such as number like 5, 10
        //Thus, count = n/5 + n/25 + n/125 + ... + 0
            int temp = n / 5;
            count += temp;
            n = temp;
        }
        return count;
    }
}
