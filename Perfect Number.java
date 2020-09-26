class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num < 2) return false;
        int sum = 1;
        for(int i = 2; i * i <= num; i++){
            if(i * i == num) sum += i;
            else if(num % i == 0){ 
                sum += i;
                sum += num / i;
            }
            else continue;
        }
        return sum == num;
    }
}
