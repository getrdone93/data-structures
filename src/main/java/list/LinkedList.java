package list;

import common.Node;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList<T> addLast(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
        } else {
            if (this.tail == null) {
                this.tail = new Node<T>(data);
                this.head.setNext(this.tail);
                this.tail.setPrev(this.head);
            } else {
                this.tail.setNext(new Node<T>(data));
                this.tail.getNext().setPrev(this.tail);
                this.tail = this.tail.getNext();
            }
        }
        this.size++;
        return this;
    }

    public LinkedList<T> addFirst(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
        } else {
            this.head = new Node<T>(data, new Node<>(this.head));
            this.head.getNext().setPrev(this.head);
        }
        this.size++;
        return this;
    }

    public T removeFirst() {
        if (this.head == null) {
            return null;
        } else {
            T data = this.head.getData();
            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
            return data;
        }
    }

    public T removeLast() {
        if (this.head == null) {
            return null;
        } else {
            if (this.tail == null) {
                return removeFirst();
            } else {
                T data = this.tail.getData();
                this.tail = this.tail.getPrev();
                this.tail.setNext(null);
                this.size--;
                return data;
            }
        }
    }

    public LinkedList<T> add(T data) {
        return addLast(data);
    }

    public T get(long index) {
        Node<T> copyHead = this.head;
        long i = 0;
        while (i < index && copyHead.getNext() != null) {
            copyHead = copyHead.getNext();
            i++;
        }
        return i == index ? copyHead.getData() : null;
    }

    public T remove(long index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node<T> copyHead = this.head;
            Node<T> previous = copyHead;
            long i = 0;
            while (i < index && copyHead.getNext() != null) {
                previous = copyHead;
                copyHead = copyHead.getNext();
                i++;
            }
            if (i == index && copyHead != null) {
                previous.setNext(copyHead.getNext());
                if (index == this.size - 1) {
                    this.tail = previous;
                }
                this.size--;
                return copyHead.getData();
            }
        }

        return null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> copyHead = this.head;
        while (copyHead != null) {
            result.append(copyHead.getNext() == null ? copyHead.getData() : copyHead.getData() + ", ");
            copyHead = copyHead.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
