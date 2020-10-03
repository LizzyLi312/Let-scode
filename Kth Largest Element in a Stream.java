class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        for(int num : nums){
            pq.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        while(pq.size() > k) pq.poll(); //in case nums.length > k
        if(pq.size() < k) pq.offer(val);
        
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
