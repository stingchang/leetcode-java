public class LRUCache {
	private int maxSize;
	private HashMap<Integer, Node> map;
	private Node head, tail;

	public Q146_LRUCache(int capacity) {
		maxSize = capacity;
		head = tail = null;
	}

	// return -1 if no such key
	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		int v = map.get(key).value;
		remove(key);
		set(key, v);
		return v;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			remove(key);
		}
		Node n = new Node(key, value);
		n.post = head;
		head.pre = n;
		head = n;

		if (map.size() > maxSize)
			removeTail();

	}

	public void remove(int key) {
		if (!map.containsKey(key)) {
			return;
		}

		Node n = map.get(key);

		if (n == head) {
			removeHead();
		}
		if (n == tail) {
			removeTail();
		} else {
			Node pre = n.pre;
			Node post = n.post;
			pre.post = post;
			post.pre = pre;
		}

		map.remove(key);

	}

	public void removeHead() {
		if (head == null)
			return;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.post;
			head.pre = null;
		}
	}

	public void removeTail() {
		if (tail == null)
			return;
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.pre;
			tail.post = null;
		}
	}   
}