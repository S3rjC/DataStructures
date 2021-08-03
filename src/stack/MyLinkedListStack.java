package stack;

import linked_list.Node;

import java.util.Scanner;

/**
 * @author Serj C.
 */
public class MyLinkedListStack {
    private Node push(int data, Node head) {
        Node newElement = new Node(data);

        if (head != null) {
            newElement.next = head;
        }
        head = newElement;

        return head;
    }

    private Node pop(Node head) {
        if (head == null) {
            System.out.println("STACK UNDERFLOW!!!");
        } else {
            System.out.println("Popped element: " + head.data);
            head = head.next;
        }

        return head;
    }

    private void display(Node head) {
        System.out.print("Stack: ");
        if (head == null) {
            System.out.println("NO NODES");
        } else {
            Node listPointer = head;
            while (listPointer.next != null) {
                System.out.print(listPointer.data + " ");
                listPointer = listPointer.next;
            }
            System.out.print(listPointer.data);
            System.out.println();
        }
    }

    private boolean isEmpty(Node head) {
        return head == null;
    }

    private int peek(Node head) {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        MyLinkedListStack linkedListStack = new MyLinkedListStack();
        Node head = null;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n******* STACK (LINKED LIST BASED) *******");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEK");
            System.out.println("4. IS EMPTY");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            switch (in.nextInt()) {
                case 1 -> {
                    System.out.print("Enter the value: ");
                    head = linkedListStack.push(in.nextInt(), head);
                    linkedListStack.display(head);
                }
                case 2 -> {
                    head = linkedListStack.pop(head);
                    linkedListStack.display(head);
                }
                case 3 -> System.out.println("Peek element: " + linkedListStack.peek(head));
                case 4 -> System.out.println("Is stack empty?: " + linkedListStack.isEmpty(head));
                case 5 -> System.exit(0);
                default -> System.out.println("Wrong choice!");
            }
            System.out.print("Do you want to continue? 1=YES, Any digit=NO: ");
        } while (in.nextInt() == 1);
    }
}
