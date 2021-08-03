package stack;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Serj C.
 */
public class MyStack {
    int[] stackArray;
    int top;

    private MyStack() {
        stackArray = new int[5];
        top = -1;
    }

    private void push(int data) {
        if (top == stackArray.length - 1) {
            System.out.println("STACK OVERFLOW!!!");
        } else {
            stackArray[++top] = data;
        }
    }

    private int pop() {
        if (top == -1) {
            System.out.println("STACK UNDERFLOW!!!");
            return -1;
        } else {
            int poppedElement = stackArray[top];
            stackArray[top--] = 0;

            return poppedElement;
        }
    }

    private void display() {
        IntStream.of(stackArray).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        if (top == -1) {
            return -1;
        }
        return stackArray[top];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n******* STACK *******");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEK");
            System.out.println("4. IS EMPTY");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            switch (in.nextInt()) {
                case 1 -> {
                    System.out.print("Enter the value: ");
                    stack.push(in.nextInt());
                    stack.display();
                }
                case 2 -> {
                    System.out.println("Popped element: " + stack.pop());
                    stack.display();
                }
                case 3 -> System.out.println("Peek element: " + stack.peek());
                case 4 -> System.out.println("Is stack empty?: " + stack.isEmpty());
                case 5 -> System.exit(0);
                default -> System.out.println("Wrong choice!");
            }
            System.out.print("Do you want to continue? (1=YES, Any digit=NO): ");
        } while (in.nextInt() == 1);
    }
}
