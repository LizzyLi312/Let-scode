class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        int min = 0, max = 0; //record the range of the hashmap's key
        while(!q.isEmpty()){ //bfs traversal of tree. put value into the map 
            Pair p = q.poll();
            min = Math.min(min, p.x);
            max = Math.max(max, p.x);
            if(!map.containsKey(p.x)) map.put(p.x, new ArrayList<>());
            map.get(p.x).add(p);
            if(p.node.left != null) q.add(new Pair(p.node.left, p.x - 1, p.y + 1));
            if(p.node.right != null) q.add(new Pair(p.node.right, p.x + 1, p.y + 1));
        }
        for(int i = min; i <= max; i++){
            Collections.sort(map.get(i), new Comparator<Pair>(){ //sort list in decreasing order 
               public int compare(Pair a, Pair b){
                   if(a.y == b.y) return a.node.val - b.node.val;
                   return 0; //remain the same order
               } 
            });
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < map.get(i).size(); j++){ //sort every list in the map and then put it into the result list 
                list.add(map.get(i).get(j).node.val);
            }
            lists.add(list);
        }
        return lists;
    }
    class Pair{
        TreeNode node;
        int x;
        int y; 
        public Pair(TreeNode n, int x, int y){
            node = n;
            this.x = x;
            this.y = y;
        }
    }
   
}
