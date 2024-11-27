class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (o1, o2) -> o1[0]- o2[0]);
        List<int[]> merged = new ArrayList<>();
        int mod = (int) 1e9 + 7;

        int ed = -1, res = 1;
        for (int[] range : ranges) {
            if (ed < range[0]) {
                res = res * 2 % mod; // update the result every time we have a new interval since the 
            }
            ed = Math.max(ed, range[1]);
        }

        return res;
    }
}
