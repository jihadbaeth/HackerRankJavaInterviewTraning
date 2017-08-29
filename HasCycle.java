import java.util.HashSet;
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/


public class HasCycle {

    boolean hasCycle(Node head) {
        HashSet<Node> temp = new HashSet<Node>();
        int size = 0;
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                temp.add(current);
                current = current.next;
                if (temp.size() == size + 1) {
                    size++;
                } else {
                    return true;
                }
            }

        } else {
            return false;
        }
        return false;

    }

    class Node {
        int data;
        Node next;
    }


}



