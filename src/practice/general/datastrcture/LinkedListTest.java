package practice.general.datastrcture;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.display();

        MyNode node1 = new MyNode(12);
        MyNode node2 = new MyNode(14);
        MyNode node3 = new MyNode(15);
        MyNode node4 = new MyNode(16);
        MyNode node5 = new MyNode(18);
        MyNode node6 = new MyNode(19);

        linkedList.insert(node1);
        linkedList.insert(node2);
        linkedList.insert(node3);
        linkedList.insert(node4);
        linkedList.insert(node5);
        linkedList.insert(node6);

        linkedList.display();
        linkedList.reverse();
        linkedList.reverse(); // form in the original shape
        linkedList.display();
    }
}

class MyLinkedList {
    private MyNode head;

    public void insert(MyNode newNode) {
        if (head == null)
            head = newNode;
        else {
            MyNode current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("linked list is empty.. \n");
            return;
        }
        MyNode current = head;
        while (current != null) {
            System.out.print(current.data + " > ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("linked list is empty..");
            return;
        }

        MyNode pre = null;
        MyNode next = null;
        MyNode current = head;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public MyNode getMiddleNode() {
        MyNode current = head;
        MyNode current2 = head;

        while (current.next != null && current2.next.next != null) {
            current = current.next;
        }
        return null;
    }
}


class MyNode {
    Integer data;
    MyNode next;

    public MyNode(Integer data) {
        this.data = data;
        this.next = null;
    }
}
