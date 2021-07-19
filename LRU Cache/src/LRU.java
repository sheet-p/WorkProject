import java.util.HashMap;

//LRU Cache is implemented with hashmap and doubly linked list
//O(1) for get , put and delete operations
public class LRU {
    HashMap<Integer, Node> cache;
    int CAPACITY;
    private Node head, tail;

    LRU(int capacity) {
        this.CAPACITY = capacity;

        head = new Node(0,0);
        tail = new Node(0, 0);

        head.pre = null;
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;

        head.next = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    public int get(int key) {
        Node node = cache.get(key);

        //key exists
        if(node != null) {
            //remove node from the LRU cache
            removeNode(node);
            //then add it right after the head
            addToHead(node);

            return node.value;
        }
        else
            return -1;
    }
    
    private Node popTail() {
        Node end = tail.pre;
        removeNode(end);
        return end;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if(node != null) {
            node.value = value;
        }
        else {
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            
            if(cache.size() > CAPACITY) {
                Node end = popTail();
                cache.remove(end);
            }
        }
    }
}
