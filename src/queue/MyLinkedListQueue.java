package queue;

import linked_list.Node;

/**
 * @author Serj C.
 */
public class MyLinkedListQueue {
    private Node enqueue(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node listPointer = head;
            while (listPointer.next != null) {
                listPointer = listPointer.next;
            }
            listPointer.next = newNode;
        }

        return head;
    }

    private Node dequeue(Node head) {
        if (head == null) {
            System.out.println("QUEUE UNDERFLOW!!!");
        } else {
            System.out.println("Dequeued element: " + head.data);
            head = head.next;
        }

        return head;
    }

    private int peek(Node head) {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    private void display(Node head) {
        System.out.print("\nQueue: ");
        if (head == null) {
            System.out.println("EMPTY");
        } else {
            Node listPointer = head;
            while (listPointer.next != null) {
                System.out.print(listPointer.data + " ");
                listPointer = listPointer.next;
            }
            System.out.println(listPointer.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedListQueue myLinkedListQueue = new MyLinkedListQueue();
        Node head = null;

        System.out.println("\n******* QUEUE (LINKED LIST BASED) *******");
        head = myLinkedListQueue.enqueue(head, 1);
        head = myLinkedListQueue.enqueue(head, 2);
        head = myLinkedListQueue.enqueue(head, 3);
        head = myLinkedListQueue.enqueue(head, 4);
        head = myLinkedListQueue.enqueue(head, 5);
        System.out.println("Queue Peek: " + myLinkedListQueue.peek(head));
        myLinkedListQueue.display(head);

        head = myLinkedListQueue.dequeue(head);
        head = myLinkedListQueue.dequeue(head);
        head = myLinkedListQueue.dequeue(head);
        head = myLinkedListQueue.dequeue(head);
        head = myLinkedListQueue.dequeue(head);
        System.out.println("Queue Peek: " + myLinkedListQueue.peek(head));
        myLinkedListQueue.display(head);

        head = myLinkedListQueue.dequeue(head); // Queue Underflow
        myLinkedListQueue.display(head);
    }
}
