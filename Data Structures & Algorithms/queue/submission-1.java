class Deque {
    class Node {
        int val;
        Node prev, next;
    }

    Node head, tail;
    public Deque() {

    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void append(int value) {
        Node node = new Node();
        node.val = value;
        if(isEmpty()) {
            head = node; tail = node;

        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    public void appendleft(int value) {
        Node node = new Node();
        node.val = value;
        if(isEmpty()) {
            head = node; tail = node;
        } else {
            head.prev = node;
            head.prev.next = head;
            head = head.prev;
        }
    }

    public int pop() {
        if(isEmpty()) return -1;
        int res = tail.val;
        tail = tail.prev;
        if(tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return res;
    }

    public int popleft() {
        if(isEmpty()) return -1;
        int res = head.val;
        head = head.next;
        if(head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return res;
    }
}
