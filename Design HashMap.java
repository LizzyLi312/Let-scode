//use array to store the key. use hashcode to calculate the index in the array. When we have the hash collision, use List to append
class MyHashMap {
    // private int MAX_SIZE = 256; if the size is exceed. we need to do rehashing 
    final ListNode[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if(nodes[i] == null) nodes[i] = new ListNode(-1,-1);
        ListNode prev = find(nodes[i], key);
        if(prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if(nodes[i] == null) return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if(nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
    private int idx(int key){ //use hashcode to make Get method the time O(1)
        return Integer.hashCode(key) % nodes.length;
    }
    private ListNode find(ListNode bucket, int key){
        ListNode node = bucket, prev = null;
        while(node != null && node.key != key){ //find the node 
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    class ListNode{
        int key, val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
