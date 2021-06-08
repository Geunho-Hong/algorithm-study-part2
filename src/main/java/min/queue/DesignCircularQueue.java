package min.queue;

public class DesignCircularQueue {

    // https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1396/
    static class MyCircularQueue {
        private int[] elements;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            elements = new int[k];
            front = -1;
            rear = -1;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            if (front == -1)
                front++;

            rear = (rear + 1) % elements.length;
            elements[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % elements.length;
            }

            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : elements[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : elements[rear];
        }

        public boolean isEmpty() {
            return front == -1 && front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % elements.length == front;
        }
    }
}