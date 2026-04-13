package all.tech.practice.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

//Floyd’s Cycle Detection Algorithm (Tortoise & Hare) — O(n) time, O(1) space
public class FloydCycleDetectionInLinkedList {
    public static void main(String[] args) {
        MyCustomLinkedList.Node<Integer> node1 = new MyCustomLinkedList.Node<>(10);
        MyCustomLinkedList.Node<Integer> node2 = new MyCustomLinkedList.Node<>(11);
        MyCustomLinkedList.Node<Integer> node3 = new MyCustomLinkedList.Node<>(12);
        MyCustomLinkedList.Node<Integer> node4 = new MyCustomLinkedList.Node<>(14);
        MyCustomLinkedList.Node<Integer> node5 = new MyCustomLinkedList.Node<>(15);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // Consider node1 is a head.

        // print nodes before cycle...
        MyCustomLinkedList.Node<Integer> temp = node1;
        while (temp != null) {
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println();

         /*
        temp = node1;
        while (temp != null) { // This loop will will infinte .. not to run this function.....
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }*/

        node5.setNext(node3); // intentionally made this linking to node3 so that cycle found..
        System.out.println(" Check Cycle Found Using Floyd Algo:" + isCycleFoundUsingFloydCycleDetection(node1));
        System.out.println(" Check Cycle Found using HashSet :" + isCycleFoundUsingHashSet(node1));

        node5.setNext(null); // now Cycle should not found because link node removed & set null.
        System.out.println(" Check Cycle Found Using Floyd Algo:" + isCycleFoundUsingFloydCycleDetection(node1));
        System.out.println(" Check Cycle Found using HashSet :" + isCycleFoundUsingHashSet(node1));

        node5.setNext(node3); // intentionally made this linking to node3 so that cycle found..
        System.out.println(" Check Cycle length is :" + checkLengthOfACycleUsingFloydCycleDetection(node1));

    }

    public static boolean isCycleFoundUsingFloydCycleDetection(MyCustomLinkedList.Node<Integer> head) {
        MyCustomLinkedList.Node<Integer> slowPointer = head;
        MyCustomLinkedList.Node<Integer> fastPointer = head;

        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleFoundUsingHashSet(MyCustomLinkedList.Node<Integer> head) {
        Set<MyCustomLinkedList.Node<Integer>> set = new HashSet<>();
        MyCustomLinkedList.Node<Integer> temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.getNext();
        }
        return false;
    }


    // Find the node where the cycle begins also return length.
    public static int checkLengthOfACycleUsingFloydCycleDetection(MyCustomLinkedList.Node<Integer> head) {
        MyCustomLinkedList.Node<Integer> slowPointer = head;
        MyCustomLinkedList.Node<Integer> fastPointer = head;
        int length = 1;
        MyCustomLinkedList.Node<Integer> pointer = null;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if (slowPointer == fastPointer) {
                pointer = slowPointer.getNext();
                while (slowPointer != pointer) {
                    length++;
                    // slowPointer = slowPointer.getNext();
                    pointer = pointer.getNext();
                }
                break;
            }

        }
        System.out.println(" Detection length :" + length + " & Cycle Start from :" + pointer.getData());
        return length;
    }

    public static void removeCycleUsingFloydCycleDetection(MyCustomLinkedList.Node<Integer> head) {
        System.out.println("Before removing Cycle..");
        MyCustomLinkedList.Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(" " + temp.getData());
            temp = temp.getNext();
        }


    }
}