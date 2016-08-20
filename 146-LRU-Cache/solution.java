public class LRUCache {
    
	
//	private int maxSize;
	LinkedHashMap<Integer, Integer> map;
	
    public LRUCache(int capacity) {
    	 map = new LinkedHashMap<>(capacity);
//        maxSize = capacity;
    }
    
    public int get(int key) {
        int val = map.get(key);
        return val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	map.remove(key);
        }
        map.put(key, value);
    }
}