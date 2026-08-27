class LinkedList {
    class Node {
        int val;
        Node next;

        Node(int v, Node n) {
            val = v;
            next = n;
        }
    }

    Node head, tail;
    int len;
    public LinkedList() {}

    public int get(int index) {
        if(index >= len) return -1;
        Node node = head;
        while(index > 0 && node != null) {
            node = node.next;
            index--;
        }
        return node != null ? node.val : -1;
    }

    public void insertHead(int val) {
        if(head == null) {
            head = new Node(val, null);
            tail = head;
        } else {
            Node newHead = new Node(val, head);
            head = newHead;
        }
        len++;
    }

    public void insertTail(int val) {
        if(head == null && tail == null) {
            head = new Node(val, null);
            tail = head;
        } else {
            tail.next = new Node(val, null);
            tail = tail.next;
        } 
        len++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= len) return false;
        if(index == 0) {
            head = head.next;
            if(head == null) tail = null;
        } else {
            Node node = head;
            for(int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            if(node.next == null) tail = node;
        }
        len--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node node = head;
        ArrayList<Integer> res = new ArrayList<>();
        while(node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res;
    }
}
