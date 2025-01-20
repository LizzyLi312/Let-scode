class Solution {
    int start; //start = 0 without assignment
    long[] p, h;
    int P = 131; // a prime number to avoid collision 
    int N = 300010; // the maximum length of string s
    public String longestDupSubstring(String s) {
        if (s == null || s.length() == 0) return "";

        int n = s.length();

        int l = 0, r = n;
        p = new long[N];
        h = new long[N];

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(mid, s)) l = mid;
            else r = mid - 1;
        }
        check(r, s); //check substring with length r
        return s.substring(start, start + r); // [start, start + r - 1]
    }

    private boolean check(int mid, String s) {
        HashSet<Long> set = new HashSet<>();
        for (int i = 1; i <= s.length() - mid + 1; i++) {
            long hash = get(i, i + mid - 1);
            if (!set.add(hash)) {
                start = i - 1; // since p and h array is i + 1 index 
                return true;
            }
        }
        return false;
    }

    private Long get(int l, int r) {
        // abcde
        // a * P^4 + b * P^3 + c * P^2 + d * P^1 + e * P^0
        // substring cd (2,3) = c * P^2 + d * P^1 = h[3] - h[2 - 1] * p[3 - 2 + 1]
        // h[3] = a * P^4 + b * P^3 + c * P^2 + d * P^1, h[2 - 1] =  a * P^1 + b * P^0
        return h[r] - h[l - 1] * p[r - l + 1]; 
    }
}
