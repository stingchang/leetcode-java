public class LRUCache {
    
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = tail = null;
        this.capacity = capacity;
    }
    
    public void addHead(int key, int value){
        Node node = new Node(key, value);
        if(map.size()==0){
            head = tail = node;
        } else {
            node.post  = head;
            head.pre = node;
            head = head.pre;
        }
        map.put(key, node);
    }
    
    public void remove(int key){
        Node node = map.get(key);
        if(head == tail){
            head = tail = null;
        } else if(node == head){
            head = head.post;
            head.pre = null;
        } else if(node == tail){
            tail = tail.pre;
            tail.post = null;
        } else {
            node.pre.post = node.post;
            node.post.pre = node.pre;
        }
        
        map.remove(node);
    }
    public void removeTail(){
        Node node = tail;
        tail = tail.pre;
        tail.post = null;
        map.remove(node);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            
            remove(key);
            addHead(key, n.value);
            
            return n.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        
        if(map.containsKey(key)){
            remove(key);
        }
        
        addHead(key, value);
        
        if(map.size()>capacity){
            removeTail();
        }
    }
    
    class Node{
        int value;
        int key;
        Node pre;
        Node post;
        
        public Node( int key, int value){
            this.key =key;
            this.value = value;
            pre = post = null;
        }
    }
    
}