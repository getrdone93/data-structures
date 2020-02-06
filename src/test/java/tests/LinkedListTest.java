package tests;

import org.junit.Test;
import org.junit.Assert;

public class LinkedListTest {

    private <E> void listsEqual(java.util.LinkedList<E> expected, list.LinkedList<E> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testLinkedListSize() {
        final int nums = 5;
        list.LinkedList<Integer> actual = new list.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
        }

        Assert.assertEquals(5L, actual.size());
    }

    @Test
    public void testLinkedListAdd() {
        final int nums = 5;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
            expected.add(i);
        }

        listsEqual(expected, actual);
    }

    @Test
    public void testLinkedListDelete() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
            expected.add(i);
        }

        actual.remove(0);
        expected.remove(0);

        actual.remove(actual.size() - 1);
        expected.remove(expected.size() - 1);

        actual.remove(actual.size() / 2);
        expected.remove(expected.size() / 2);

        listsEqual(expected, actual);
    }
}
