package linked_list;

import java.util.Scanner;

/**
 * @author Serj C.
 */
public class MyLinkedList {
    private LLNode head;

    private LLNode insertFront(int data, LLNode head) {
        LLNode newLLNode = new LLNode(data);

        if (head != null) {
            newLLNode.next = head;
        }
        head = newLLNode;

        return head;
    }

    private LLNode insertEnd(int data, LLNode head) {
        LLNode newLLNode = new LLNode(data);

        if (head == null) {
            head = newLLNode;
        } else {
            LLNode listPointer = head;
            while (listPointer.next != null) {
                listPointer = listPointer.next;
            }
            listPointer.next = newLLNode;
        }

        return head;
    }

    private LLNode insertAtPos(int data, int pos, LLNode head) {
        LLNode newLLNode = new LLNode(data);

        if (pos == 1) {
            newLLNode.next = head;
            head = newLLNode;
        } else {
            LLNode listPointer = head;
            for (int i = 1; listPointer != null && i < pos-1; i++) {
                listPointer = listPointer.next;
            }
            newLLNode.next = listPointer.next;
            listPointer.next = newLLNode;
        }

        return head;
    }

    private LLNode delete(int pos, LLNode head) {
        if (head != null) {
            LLNode listPointer = head;

            if (pos == 1) {
                head = listPointer.next;
            } else {
                for (int i = 1; listPointer != null && i < pos-1; i++) {
                    listPointer = listPointer.next;
                }
                listPointer.next = listPointer.next.next;
            }
        } else {
            System.out.println("Linked list is empty.");
        }

        return head;
    }

    int length(LLNode head) {
        LLNode listPointer = head;

        if (listPointer == null) {
            return 0;
        } else {
            int length = 0;
            while (listPointer != null) {
                listPointer = listPointer.next;
                length++;
            }
            return length;
        }
    }

    LLNode reverse(LLNode head) {
        LLNode listPointer = head;
        LLNode prevLLNode = null;
        LLNode nextLLNode = null;

        if (listPointer != null) {
            while (listPointer != null) {
                nextLLNode = listPointer.next;
                listPointer.next = prevLLNode;

                prevLLNode = listPointer;
                listPointer = nextLLNode;
            }
            head = prevLLNode;
        } else {
            System.out.println("Linked List is empty.");
        }

        return head;
    }

    void display(LLNode head) {
        LLNode listPointer = head;

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
