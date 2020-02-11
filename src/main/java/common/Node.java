package common;

public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(final T data) {
        this(data, null);
    }

    public Node(final T data, final Node<T> next) {
        this(data, next, null);
    }

    public Node(final T data, final Node<T> next, final Node<T> prev) {
        this.data = data;
        this.next = next;
        this.setPrev(prev);
    }

    public Node(Node<T> copy) {
        this.data = copy.getData();
        this.next = copy.getNext();
        this.prev = copy.getPrev();
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(final Node<T> node) {
        this.next = node;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setPrev(final Node<T> prev) {
        this.prev = prev;
    }
}
