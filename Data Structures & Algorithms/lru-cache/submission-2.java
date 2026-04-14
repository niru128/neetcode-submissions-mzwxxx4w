class LRUCache {

    class Node {
        int key, value;
        Node prev , next;

        Node(int k , int v){
            this.key = k;
            this.value = v;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
        
    }

    public void insert(Node node){

        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;

    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }

        if(map.size() == capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        
    }
}
