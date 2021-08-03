package linked_list;

import java.util.Scanner;

/**
 * @author Serj C.
 */
public class MyLinkedList {
    private Node head;

    private Node insertFront(int data, Node head) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
        }
        head = newNode;

        return head;
    }

    private Node insertEnd(int data, Node head) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node nodePointer = head;
            while (nodePointer.next != null) {
                nodePointer = nodePointer.next;
            }
            nodePointer.next = newNode;
        }

        return head;
    }

    private Node insertAtPos(int data, int pos, Node head) {
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node nodePointer = head;
            for (int i = 1; nodePointer != null && i < pos-1; i++) {
                nodePointer = nodePointer.next;
            }
            newNode.next = nodePointer.next;
            nodePointer.next = newNode;
        }

        return head;
    }

    private Node delete(int pos, Node head) {
        if (head != null) {
            Node nodePointer = head;

            if (pos == 1) {
                head = nodePointer.next;
            } else {
                for (int i = 1; nodePointer != null && i < pos-1; i++) {
                    nodePointer = nodePointer.next;
                }
                nodePointer.next = nodePointer.next.next;
            }
        } else {
            System.out.println("Linked list is empty.");
        }

        return head;
    }

    int length(Node head) {
        Node nodePointer = head;

        if (nodePointer == null) {
            return 0;
        } else {
            int length = 0;
            while (nodePointer != null) {
                nodePointer = nodePointer.next;
                length++;
            }
            return length;
        }
    }

    Node reverse(Node head) {
        Node nodePointer = head;
        Node prevNode = null;
        Node nextNode = null;

        if (nodePointer != null) {
            while (nodePointer != null) {
                nextNode = nodePointer.next;
                nodePointer.next = prevNode;

                prevNode = nodePointer;
                nodePointer = nextNode;
            }
            head = prevNode;
        } else {
            System.out.println("Linked List is empty.");
        }

        return head;
    }

    void display(Node head) {
        Node listPointer = head;

        System.out.print("Linked List: ");
        while (listPointer.next != null) {
            System.out.print(listPointer.data + "->");
            listPointer = listPointer.next;
        }
        System.out.println(listPointer.data);
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.head = null;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n********* LINKED LIST *********");
            System.out.println("1. Insert in Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at a particular position");
            System.out.println("4. Delete at position");
            System.out.println("5. Length");
            System.out.println("6. Reverse");
            System.out.println("7. Display");
            System.out.println("8. EXIT");
            System.out.println("Enter your choice: ");

            int n = scanner.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.println("Enter the value");
                    linkedList.head = linkedList.insertFront(scanner.nextInt(), linkedList.head);
                    linkedList.display(linkedList.head);
                }
                case 2 -> {
                    System.out.println("Enter the value");
                    linkedList.head = linkedList.insertEnd(scanner.nextInt(), linkedList.head);
                    linkedList.display(linkedList.head);
                }
                case 3 -> {
                    System.out.println("Enter the value");
                    linkedList.head = linkedList.insertAtPos(scanner.nextInt(), scanner.nextInt(), linkedList.head);
                    linkedList.display(linkedList.head);
                }
                case 4 -> {
                    System.out.println("Enter the value");
                    linkedList.head = linkedList.delete(scanner.nextInt(), linkedList.head);
                    linkedList.display(linkedList.head);
                }
                case 5 -> System.out.println(linkedList.length(linkedList.head));
                case 6 -> {
                    linkedList.head = linkedList.reverse(linkedList.head);
                    linkedList.display(linkedList.head);
                }
                case 7 -> linkedList.display(linkedList.head);
                case 8 -> System.exit(0);
                default -> System.out.println("Wrong choice!");
            }
            System.out.print("\nDo you want to continue? (1-YES, Any Digit-NO): ");
        } while (scanner.nextInt() == 1);
    }
}
