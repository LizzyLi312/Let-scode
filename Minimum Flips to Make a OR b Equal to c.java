class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            int x = a >> i & 1;
            int y = b >> i & 1;
            int z = c >> i & 1;

            if (z == 1) {
                if (x != 1 && y != 1) res++;
            } else if (z == 0) {
                if (x != 0 && y != 0) res += 2;
                else if (x != 0 || y != 0) res++;
            }
        }
        return res;
    }
}
