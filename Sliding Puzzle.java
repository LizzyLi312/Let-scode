class Solution {
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return -1;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int n = board.length, m = board[0].length;
        String end = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]);
            }
        }

        String s = sb.toString();

        Queue<String> que = new LinkedList<>();
        que.offer(s);
        int step = 0;
        HashSet<String> set = new HashSet<>();
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String temp = que.poll();
                if (temp.equals(end)) return step;
                int pos = temp.indexOf('0');
                int x = pos / m, y = pos % m;
                for (int[] dir : dirs) {
                    int a = x + dir[0];
                    int b = y + dir[1];
                    if (a < 0 || a >= n || b < 0 || b >= m) continue;
                    String t = swap(temp, pos, a * m + b);
                    if (!set.add(t)) continue;
                    que.offer(t);
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String s, int pos, int temp) {
        char c = s.charAt(pos);
        char[] arr = s.toCharArray();
        arr[pos] = arr[temp];
        arr[temp] = c;
        return String.valueOf(arr);
    }
}
