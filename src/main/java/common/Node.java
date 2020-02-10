package common;

public class Node<E> {

    private E data;
    private Node<E> next;

    public Node(final E data) {
        this(data, null);
    }

    public Node(final E data, final Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(Node<E> copy) {
        this.data = copy.getData();
        this.next = copy.getNext();
    }

    public E getData() {
        return this.data;
    }

    public void setData(final E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(final Node<E> node) {
        this.next = node;
    }
}
