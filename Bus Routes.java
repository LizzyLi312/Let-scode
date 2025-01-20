// bfs
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> r = new HashMap<>(); // [stop number, (route number)]
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet temp = r.getOrDefault(routes[i][j], new HashSet<Integer>());
                temp.add(i);
                r.put(routes[i][j], temp);
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int step = 0;
        que.offer(source);

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> visited_r = new HashSet<>();
        visited.add(source);

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int temp = que.poll();
                if (temp == target) return step;
                if (r.get(temp) == null) return -1; // need to see if the stop exist 
                for (int i : r.get(temp)) { // get routes number that contains the stop number
                    if (!visited_r.add(i)) continue;
                    for (int j : routes[i]) { // add the new stop that haven't been visited 
                        if (visited.add(j)) {
                            que.offer(j);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
