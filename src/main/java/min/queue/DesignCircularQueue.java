package min.queue;

public class DesignCircularQueue {

    static class MyCircularQueue {
        private int[] elements;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            elements = new int[k + 1];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            rear = (rear + 1) % elements.length;
            elements[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            front = (front + 1) % elements.length;
            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return elements[(front + 1) % elements.length];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            return elements[rear];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        //
        public boolean isFull() {
            return (rear + 1) % elements.length == front;
        }
    }
}