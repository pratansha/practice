package all.tech.practice.ds.linkedlist;

//Floyd’s Cycle Detection Algorithm (Tortoise & Hare) — O(n) time, O(1) space
public class ReverseLinkedListStyle2 {
    public static void main(String[] args) {
        MyCustomLinkedList.Node<Integer> node1 = new MyCustomLinkedList.Node<>(10);
        MyCustomLinkedList.Node<Integer> node2 = new MyCustomLinkedList.Node<>(11);
        MyCustomLinkedList.Node<Integer> node3 = new MyCustomLinkedList.Node<>(12);
        MyCustomLinkedList.Node<Integer> node4 = new MyCustomLinkedList.Node<>(13);
        MyCustomLinkedList.Node<Integer> node5 = new MyCustomLinkedList.Node<>(15);
        MyCustomLinkedList.Node<Integer> node6 = new MyCustomLinkedList.Node<>(16);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        // Consider node1 is a head.
        // print nodes before cycle...
        MyCustomLinkedList.Node<Integer> temp = node1;
        while (temp != null) {
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
        reverseLinkedListWithOriginalStyle2(node1);


        printLinkedList(node1);
        printLinkedList(node1);

        System.out.println("===========================");
        MyCustomLinkedList.Node<Integer> temp2 = new MyCustomLinkedList.Node<>(null);
        temp2.setNext(node1);
        reverseLinkedListWithRecursion(temp2);
        printLinkedList(temp2);
    }

    // Now expectation is 1->2->3->4->5->null ==> 2->1->4->3->5->null
    // &  1->2->3->4->5->6->null ==> 2->1->4->3->6->5->null...

    /* Explanation: Create a new object and set head next to it.so this new object will be null->head.
       Iterate through the newNode and check newNode.next & newNode.next.next should not be null.
       Use 2 Nodes first & sec, and set newNode.next & newNode.next.next to first & sec Node respectively.and swap with each other. Now second will be changed & up to date.
       Now set 2nd object next to the newNode.
       again newNode = firstNode to get next value
       This way it will update in the existing Node newNode only.
       Assign this to existing variable
     */
    public static void reverseLinkedListWithOriginalStyle2(MyCustomLinkedList.Node<Integer> head) {
        MyCustomLinkedList.Node<Integer> temp = new MyCustomLinkedList.Node<>(null);
        temp.setNext(head);   // null 10 11 12 13 15 16

        MyCustomLinkedList.Node<Integer> prev = temp; // null 10 11 12 13 15 16
        while (prev.getNext() != null && prev.getNext().getNext() != null) {
            MyCustomLinkedList.Node<Integer> firstNode = prev.getNext(); //  10 11 12 13 15 16 , 12 13 15 16 , 15 16
            MyCustomLinkedList.Node<Integer> secNode = prev.getNext().getNext(); //  11 12 13 15 16 , 13 15 16 , 16

            firstNode.setNext(secNode.getNext()); //  10 12 13 15 16 , 12 15 16 , 15 null
            secNode.setNext(firstNode);  // 11 10 12 13 15 16 , 13 12 15 16 , 16 15 null

            prev.setNext(secNode); //  null 11 10 12 13 15 16 , 10 13 12 15 16  , 12 16 15 null
            prev = firstNode; //  10 12 13 15 16 , 12 15 16 , 15 null
        }
        printLinkedList(temp.getNext());
    }



    private static MyCustomLinkedList.Node<Integer> reverseLinkedListWithRecursion(MyCustomLinkedList.Node<Integer> firstNode) {
        if (firstNode == null || firstNode.getNext() == null) return firstNode;

        MyCustomLinkedList.Node<Integer> secNode = firstNode.getNext();
        firstNode.setNext(reverseLinkedListWithRecursion(secNode.getNext()));
        secNode.setNext(firstNode);
        return secNode;
    }

    public static void printLinkedList(MyCustomLinkedList.Node<Integer> head) {
        MyCustomLinkedList.Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }
}