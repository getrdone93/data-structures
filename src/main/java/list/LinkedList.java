package list;

import common.Node;

public class LinkedList<E> {

    private Node<E> head;
    private int length;

    public Node<E> add(E data) {
        if (this.head == null) {
            this.head = new Node<E>(data);
        } else {
            Node<E> currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<E>(data));
        }
        this.length++;
        return this.head;
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
            E copy = this.head.getData();
            this.head = this.head.getNext();
            this.length--;
            return copy;
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
                this.length--;
                return copyHead.getData();
            }
        }

        return null;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> copyHead = this.head;
        while (copyHead.getNext() != null) {
            result.append(copyHead.getData());
        }

        return result.toString();
    }
}
