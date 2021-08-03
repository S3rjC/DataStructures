package queue;

import java.util.stream.IntStream;

/**
 * @author Serj C.
 */
public class MyQueue {
    int[] queueArray;
    int front;
    int rear;

    public MyQueue() {
        queueArray = new int[5];
        front = rear = -1;
    }

    private void enqueue(int data) {
        if (rear == queueArray.length - 1) {
            System.out.println("Enqueue: QUEUE OVERFLOW!!!");
        } else {
            queueArray[++rear] = data;
        }
        if (front == -1) {
            front++;
        }
    }

    private int dequeue() {
        if (front == -1) {
            System.out.println("Dequeue: QUEUE UNDERFLOW!!!");

            return -1;
        } else {
            int dequeuedElement = queueArray[front];
            queueArray[front++] = 0;
            if (front == 5) {
                front = -1;
                rear = -1;
            }

            return dequeuedElement;
        }
    }

    private int peek() {
        if (front == -1) {
            return -1;
        }
        return queueArray[front];
    }

    private void display() {
        System.out.print("\nQueue: ");
        if (rear == -1) {
            System.out.println("EMPTY");
            System.out.println("Front Pointer: " + front);
            System.out.println("Rear Pointer: " + rear);
            System.out.println();
            return;
        }
        IntStream.iterate(front, i -> i < rear, i -> i + 1).forEach(i -> System.out.print(queueArray[i] + " "));
        System.out.println(queueArray[rear]);
        System.out.println("Front Pointer: " + front);
        System.out.println("Rear Pointer: " + rear);
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        System.out.println("\n******* QUEUE *******");
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        System.out.println("Queue Peek: " + myQueue.peek());
        myQueue.display();

        myQueue.enqueue(6); // Queue Overflow
        myQueue.display();

        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        myQueue.display();
        System.out.println("Queue Peek: " + myQueue.peek());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        myQueue.display();

        myQueue.dequeue(); // Queue Underflow
        myQueue.display();
    }
}
