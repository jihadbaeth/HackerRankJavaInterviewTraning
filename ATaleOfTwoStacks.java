import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ATaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();


        public Stack<T> reverse(Stack source) {
            Stack destination = new Stack<T>();
            while (!source.isEmpty()) {
                destination.push(source.pop());

            }
            return destination;
        }


        public void enqueue(T value) { // Push onto newest stack

            stackNewestOnTop.push(value);

        }

        public T peek() {
            stackOldestOnTop = reverse(stackNewestOnTop);
            T temp = stackOldestOnTop.peek();
            stackNewestOnTop = reverse(stackOldestOnTop);
            return temp;

        }

        public T dequeue() {
            stackOldestOnTop = reverse(stackNewestOnTop);
            T temp = stackOldestOnTop.pop();
            stackNewestOnTop = reverse(stackOldestOnTop);
            return temp;
        }
    }
}

//Correct Optimized Solution
//
//    public void enqueue(T item) {
//        stackNewestOnTop.push(item);
//    }
//
//    public T dequeue() {
//        if (stackOldestOnTop.isEmpty()) {
//            while (!stackNewestOnTop.empty()) {
//                stackOldestOnTop.push(stackNewestOnTop.pop());
//            }
//        }
//
//        return stackOldestOnTop.pop();
//    }
//
//    public T peek() {
//        if (stackOldestOnTop.isEmpty()) {
//            while (!stackNewestOnTop.empty()) {
//                stackOldestOnTop.push(stackNewestOnTop.pop());
//            }
//        }
//
//        return stackOldestOnTop.peek();
//    }