package list;

import common.Node;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList<T> addLast(final T data) {
        if (this.head == null) {
            return addFirst(data);
        } else {
            if (this.tail == null) {
                this.tail = new Node<T>(data);
                this.head.setNext(this.tail);
                this.tail.setPrev(this.head);
            } else {
                this.tail.setNext(new Node<T>(data));
                Node<T> tempTail = this.tail;
                this.tail.getNext().setPrev(tempTail);
                this.tail = this.tail.getNext();
            }
        }
        this.size++;
        return this;
    }

    public LinkedList<T> addFirst(final T data) {
        if (this.head == null) {
            this.head = new Node<T>(data, this.tail);
        } else if (this.head.getNext() == null) {
            this.tail = new Node<T>(this.head.getData());
            this.head = new Node<T>(data, this.tail);
            this.tail.setPrev(this.head);
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
            if (this.head.getNext() == null) {
                this.head = null;
            } else {
                if (this.head.getNext().getNext() == null) {
                    this.head = this.tail;
                    this.head.setPrev(null);
                    this.tail = null;
                } else {
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                }
            }
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
                if (this.tail.getPrev().getPrev() == null) {
                    this.tail = null;
                    this.head.setNext(null);
                } else {
                    this.tail = this.tail.getPrev();
                    this.tail.setNext(null);
                }

                this.size--;
                return data;
            }
        }
    }

    public LinkedList<T> add(final T data) {
        return addLast(data);
    }

    private Node<T> getNode(final int index) {
        if (validIndex(index)) {
            boolean startHead = index < this.size / 2;
            if (startHead) {
                int i = 0;
                Node<T> startNode = this.head;
                while (i < index && startNode.getNext() != null) {
                    startNode = startNode.getNext();
                    i++;
                }
                return i == index ? startNode : null;
            } else {
                int i = this.size - 1;
                Node<T> startNode = this.tail;
                while (i > index && startNode.getPrev() != null) {
                    startNode = startNode.getPrev();
                    i--;
                }
                return i == index ? startNode : null;
            }
        }
        return null;
    }

    public boolean validIndex(final int index) {
        return index > -1 && index < this.size;
    }

    public T get(final int index) {
        final Node<T> node = getNode(index);
        return node == null ? null : node.getData();
    }

    public T remove(final int index) {
        if (validIndex(index)) {
            if (index == 0) {
                return removeFirst();
            } else if (index == 1) {
                if (this.head == null || this.tail == null) {
                    return null;
                } else if (this.head.getNext().getNext() == null) {
                    return removeLast();
                } else if (this.head.getNext().getNext().getNext() == null) {
                    T data = this.head.getNext().getData();
                    this.head.setNext(this.tail);
                    this.tail.setPrev(this.head);
                    this.size--;
                    return data;
                }
                Node<T> removeNode = this.head.getNext();
                this.head.setNext(removeNode.getNext());
                this.head.getNext().setPrev(this.head);
                this.size--;
                return removeNode.getData();
            } else if (index == this.size - 2) {
                if (this.head == null || this.tail == null) {
                    return null;
                } else if (this.head.getNext().getNext() == null || this.head.getNext().getNext().getNext() == null) {
                    return removeLast();
                }
                Node<T> removeNode = this.tail.getPrev();
                this.tail.setPrev(removeNode.getPrev());
                this.tail.getPrev().setNext(this.tail);
                this.size--;
                return removeNode.getData();
            } else if (index == this.size - 1) {
                return removeLast();
            }
            Node<T> removeNode = getNode(index);
            if (removeNode == null) {
                return null;
            }
            Node<T> beforeNode = removeNode.getPrev();
            Node<T> afterNode = removeNode.getNext();
            beforeNode.setNext(afterNode);
            afterNode.setPrev(beforeNode);
            this.size--;
            return removeNode.getData();
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
