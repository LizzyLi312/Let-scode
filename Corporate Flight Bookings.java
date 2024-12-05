class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (bookings == null || bookings.length == 0) return new int[]{};

        // difference array: diff[0] = a[0], diff[1] = a[1] - a[0] .. diff[a.length - 1] - 
        // prefix sum of d array: s[0] = 0, s[1] = diff[0] = a[0], s[1] = diff[0] + diff[1] = a[1] ... s[n + 1] = diff[]
        // add value to [i, j] [2,3], [1,5]
        // diff'[2] = a[2] - a[1] = a[2] + 3 - a[1] = diff[2] + 3;
        // diff'[4] = a[4] - a[3] - 3 = diff[4] - 3

        int m = bookings.length;
        int[] diff = new int[n];

        int[] res = new int[n];

        for (int i = 0; i < m; i++) {
            int[] booking = bookings[i];
            int a = booking[0] - 1; // since n starts from 1 but the array is 0 indexed 
            int b = booking[1] - 1;
            int seat = booking[2];

            diff[a] += seat;
            if (b < n - 1) diff[b + 1] -= seat;
        }

        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] += diff[i] + res[i - 1];
        }
        return res;
    }
}
