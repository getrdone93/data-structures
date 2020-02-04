package list;

import common.Node;

public class LinkedList<E> {

	private Node<E> head;
	private long length;
	
	public Node<E> addNode(E data) {
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
		while (copyHead.getNext() != null && i < index) {
			copyHead = copyHead.getNext();
			i++;
		}
		return i == index ? copyHead.getData() : null;
	}
		
	public long getLength() {
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
