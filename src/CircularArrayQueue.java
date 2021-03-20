import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularArrayQueue<T> implements Queue<T> {
    private final int DEFAULT_CAPACITY = 5;
    private T[] queue;
    private int count = 0;
    private int front = 0;
    private int back = 0;

    public CircularArrayQueue() {
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = -1;
        back = -1;
        count = 0;
    }

    @Override
    public void enqueue(T item) {
        back = (back + 1) % queue.length;
        queue[back] = item;
        count++;

        if (front == -1) {
            front = back;
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        T requestedElement;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            requestedElement = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            count--;
        }
        return requestedElement;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return queue[front];
        }
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Queue.";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] != null) {
                    sb.append(queue[i]);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
    }
}