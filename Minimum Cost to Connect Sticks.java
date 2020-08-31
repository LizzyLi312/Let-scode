class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks == null ||sticks.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks){
            pq.offer(stick);
        }
        int count = 0;
        while(pq.size() > 1){
            int newStick = pq.poll() + pq.poll();
            count += newStick;
            pq.offer(newStick);
        }
        return count;
    }
}
//greedy. 
