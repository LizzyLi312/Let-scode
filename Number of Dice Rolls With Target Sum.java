class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if(d == 0 && target == 0) return 1;
        if(d == 0 || target == 0) return 0;
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1; //dice = 0, target = 0
        for(int i = 1; i <= d; i++){ //d dices
            for(int j = 1; j <= target; j++){
                if(j > i * f) continue; //if j is larger than the possible largest sum of i dices. then we should stop trying
                else{
                    for(int k = 1; k <= f && k <= j; k++){ //k faces should be smaller or equals to f faces and j target
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                        //means if we need to summate the solution that if ignore a dice with k value. 
                    }
                }
            }
        }
        return dp[d][target];
    }
}
