// bit masking
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        if (requests == null || requests.length == 0) return 0;

        int m = requests.length;
        int res = 0;
        for (int i = 0; i < 1 << m; i++) { // enumerate all posible solution of taking this request or not 
            if (check(n, requests, i)) res = Math.max(res, Integer.bitCount(i));
        }
        return res;
    }

    private boolean check(int n, int[][] requests, int state) {
        int m = requests.length;
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            if ((state >> i & 1) == 1) { //checking if we take this request of not 
                int a = requests[i][0]; //from
                int b = requests[i][1]; //to

                cnt[a]--;
                cnt[b]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}

//solution2 backtracking dfs
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        if (requests == null || requests.length == 0) return 0;

        int[] cnt = new int[n];
        return check(0, requests, cnt, 0);
    }

    private int check(int start, int[][] requests, int[] cnt, int res) {
        if (start == requests.length) {
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) return 0;
            }
            return res;
        }

        cnt[requests[start][0]]--;
        cnt[requests[start][1]]++;
        int take = check(start + 1, requests, cnt, res + 1);

        cnt[requests[start][0]]++;
        cnt[requests[start][1]]--;
        int notTake = check(start + 1, requests, cnt, res);

        return Math.max(take, notTake);

    }
}
