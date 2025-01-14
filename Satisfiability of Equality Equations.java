class Solution {
    int[] p;
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) return true;

        int n = equations.length;
        p = new int[26];
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }

        for (String eq : equations) {
            char first = eq.charAt(0);
            char second = eq.charAt(3);
            char equal = eq.charAt(1);

            int a = first - 'a';
            int b = second - 'a';

            if (equal == '=') {
                p[find(a)] = find(b);  // find the acestor of b and connect it with a's acestor 
            } 
        }

        for (String eq : equations) {
            char first = eq.charAt(0);
            char second = eq.charAt(3);
            char equal = eq.charAt(1);

            int a = first - 'a';
            int b = second - 'a';

            if (equal == '!' && find(a) == find(b)) return false;
        }

        return true;
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
