import java.util.HashMap;

public class LRU {
    private HashMap<Integer, Node> map;
    private int CAPACITY = 3;
    private Node head, tail;

    LRU(int cap) {
        this.CAPACITY = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        else
            return -1;
    }

    public void set(int k, int v) {
        if(map.get(k) != null) {
            Node node = map.get(k);
            node.value = v;
            deleteNode(node);
            addToHead(node);
        }
    }
}
