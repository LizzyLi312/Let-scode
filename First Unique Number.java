class FirstUnique {
    private HashMap<Integer, Integer> map; //use map to keep the frequency 
    private Queue<Integer> que; //use queue to keep the order 
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        que = new LinkedList<>();
        for(int num : nums){
            que.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() { 
        while(!que.isEmpty() && map.get(que.peek()) > 1){
            que.poll();
        }
        return que.isEmpty() ? -1 : que.peek();
    }
    
    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        que.offer(value);
    }
}
