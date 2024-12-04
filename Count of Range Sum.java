class Solution {
    private int lower, upper, cnt;
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        this.lower = lower;
        this.upper = upper;
        cnt = 0;

        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) sum[i] = sum[i - 1] + (long) nums[i - 1];
        mergeSort(sum, 0, n);
        return cnt;
    }

    private void mergeSort(long[] sum, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(sum, l, mid);
        mergeSort(sum, mid + 1, r);

        int i = l, j = mid + 1;
        int lo = j, up = j;
        for (i = l; i <= mid; i++) {
            while (lo <= r && sum[lo] - sum[i] < lower) lo++; //[lo, i)
            while (up <= r && sum[up] - sum[i] <= upper) up++;
            cnt += up - lo;
        }

        long[] temp = new long[r - l + 1];
        i = l;
        j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= r) {
            if (sum[i] < sum[j]) temp[idx++] = sum[i++];
            else temp[idx++] = sum[j++];
        }
        while (i <= mid) temp[idx++] = sum[i++];
        while (j <= r) temp[idx++] = sum[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            sum[i] = temp[j];
        }
    }
}
