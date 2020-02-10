package list;

import common.Node;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList<E> addLast(E data) {
        if (this.head == null) {
            this.head = new Node<E>(data);
        } else {
            if (this.tail == null) {
                this.tail = new Node<E>(data);
                this.head.setNext(this.tail);
            } else {
                this.tail.setNext(new Node<E>(data));
                this.tail = this.tail.getNext();
            }
        }
        this.size++;
        return this;
    }

    public LinkedList<E> addFirst(E data) {
        if (this.head == null) {
            this.head = new Node<E>(data);
        } else {
            Node<E> tempHead = new Node<>(this.head);
            this.head = new Node<E>(data);
            this.head.setNext(tempHead);
        }
        this.size++;
        return this;
    }

    public E removeFirst() {
        if (this.head == null) {
            return null;
        } else {
            E data = this.head.getData();
            this.head = this.head.getNext();
            this.size--;
            return data;
        }
    }

    public E removeLast() {
        if (this.head == null) {
            return null;
        } else {
            if (this.tail == null) {
                return removeFirst();
            } else {
                return this.remove(this.size - 1);
            }
        }
    }

    public LinkedList<E> add(E data) {
        return addLast(data);
    }

    public E get(long index) {
        Node<E> copyHead = this.head;
        long i = 0;
        while (i < index && copyHead.getNext() != null) {
            copyHead = copyHead.getNext();
            i++;
        }
        return i == index ? copyHead.getData() : null;
    }

    public E remove(long index) {
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> copyHead = this.head;
            Node<E> previous = copyHead;
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
        Node<E> copyHead = this.head;
        while (copyHead != null) {
            result.append(copyHead.getNext() == null ? copyHead.getData() : copyHead.getData() + ", ");
            copyHead = copyHead.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
