package all.tech.practice.ds.linkedlist;

public class MyCustomLinkedList<T> {
    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyCustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLinkToHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;     //  new node points to current head
        head = newNode;          // head becomes new node

        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLinkToTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void addNodeAtParticularPosition(int position, T data) {
        if (size < position || position <= 0)
            throw new IllegalArgumentException("Incorrect position given : " + position);
        if (data == null) throw new IllegalArgumentException("Incorrect data given : " + null);

        Node<T> temp = head;
        int start = 1;
        while (temp != null && start < position) {
            temp = temp.next;
            start++;
        }
        if (temp != null) {
            Node<T> remaining = temp.next != null ? temp.next : null;
            Node<T> newNode = new Node<>(data);
            temp.next = newNode;
            temp = newNode;
            temp.next = remaining;
        }
        size++;
    }


    public void displayLinkedList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.print(" null");
        System.out.println();
    }

    public void reverseLinkedListWithOriginalChange() {
        Node<T> pre = null;
        Node<T> current = head;
        tail = head; // In case of tail will become head after reversal.
        while (current != null) {
            Node<T> next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
    }

    public void printReverseWithoutChangingOriginal() {
        if (head == null) throw new IllegalArgumentException("Your linked-list is empty.");
        Node<T> temp = head;
        printReverse(temp);
        System.out.println();
    }

    private void printReverse(Node<T> tempNode) {
        if (tempNode == null) return;
        printReverse(tempNode.next);
        System.out.print(" " + tempNode.data);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyCustomLinkedList<Integer> linkedList = new MyCustomLinkedList<>();
        linkedList.addLinkToHead(12);
        linkedList.addLinkToHead(11);
        linkedList.addLinkToHead(10);
        linkedList.addLinkToHead(9);
        linkedList.addLinkToTail(14);

        System.out.println("Before");
        linkedList.displayLinkedList();
        linkedList.addNodeAtParticularPosition(1, 20);
        System.out.println("After");
        linkedList.displayLinkedList();
        System.out.println("Total size is :" + linkedList.size());

        linkedList.printReverseWithoutChangingOriginal();
        linkedList.reverseLinkedListWithOriginalChange();
        System.out.println("\nReversed a linked list");
        linkedList.displayLinkedList();
    }
}