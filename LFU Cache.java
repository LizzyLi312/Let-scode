class LFUCache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capa;

    public LFUCache(int capacity) {
        this.capa = capacity;
        head = new Node(-1, -1, 0);
        tail = new Node(-1, -1, 0);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node p = map.get(key);
        p.cnt++;
        remove(p);
        insert(p);
        return p.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.cnt++;
            p.val = value;
            remove(p);
            insert(p);
        } else {
            if (map.size() == capa) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node p = new Node(key, value, 1);
            map.put(key, p);
            insert(p);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    private void insert(Node p) {
        Node cur = head.next;
        while (cur != null && cur.cnt > p.cnt && cur.val != -1) {
            cur = cur.next;
        }

        Node prev = cur.prev;

        prev.next = p;
        p.next = cur;
        if (cur != null) cur.prev = p;
        p.prev = prev;
    }

    class Node {
        int key, val, cnt;
        Node prev, next;
        public Node(int key, int val, int cnt) {
            this.key = key;
            this.val = val;
            this.cnt = cnt;
            this.prev = null;
            this.next = null;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
