//max heap + min heap; res will be the first one in max heap

class SORTracker {
    PriorityQueue<Node> minHeap, maxHeap;
    public SORTracker() {
        minHeap = new PriorityQueue<>((o1, o2) -> o1.score != o2.score ? o1.score - o2.score : o2.s.compareTo(o1.s)); // increasing order 
        maxHeap = new PriorityQueue<>((o1, o2) -> o1.score != o2.score ? o2.score - o1.score : o1.s.compareTo(o2.s)); // descreasing order 
    }
    
    public void add(String name, int score) { // new node need go through the whole queue
        Node nn = new Node(name, score);
        minHeap.offer(nn);
        maxHeap.offer(minHeap.poll());
    }
    
    public String get() {
        Node res = maxHeap.peek();
        minHeap.offer(maxHeap.poll());
        return res.s;
    }

    class Node {
        String s;
        int score;
        public Node(String s, int score) {
            this.s = s;
            this.score = score;
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
