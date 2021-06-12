package sujung.queue;

public class DesignCircularQueue {

    private int[] values;
    private int front;  // previous index of first item
    private int rear;   // index of last item
    private int size;

    public DesignCircularQueue(int k) {
        this.values = new int[k];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % values.length;
        values[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % values.length;
        values[front] = -1;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return values[(front + 1) % values.length];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return values[rear % values.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == values.length;
    }
}
