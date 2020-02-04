package tests;

import org.junit.Test;

import list.LinkedList;

public class LinkedListTest {

	@Test
	public void testLinkedList() {
		final int nums = 10;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums; i++) {
			list.addNode(Integer.valueOf(i));
		}
		
		for (int i = 0; i < nums; i++) {
			System.out.printf("i: %d, value: %d\n", i, list.get(i));
		}
	}
}
