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
    public void testGet() {
        final int nums = 5;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
            expected.add(i);
        }

        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(expected.size() - 1), actual.get(actual.size() - 1));
        Assert.assertEquals(expected.get(expected.size() / 2), actual.get(actual.size() / 2));
    }

    @Test
    public void testSize() {
        final int nums = 5;
        list.LinkedList<Integer> actual = new list.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
        }

        Assert.assertEquals(5L, actual.size());
    }

    @Test
    public void testAdd() {
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
    public void testRemove() {
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

    @Test
    public void testAddFirst() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.addFirst(i);
            expected.addFirst(i);
        }

        listsEqual(expected, actual);
    }

    @Test
    public void testAddLast() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.addLast(i);
            expected.addLast(i);
        }

        listsEqual(expected, actual);
    }

    @Test
    public void testRemoveFirst() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.addLast(i);
            expected.addLast(i);
        }

        actual.removeFirst();
        expected.removeFirst();

        listsEqual(expected, actual);
    }

    @Test
    public void testRemoveLast() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.addLast(i);
            expected.addLast(i);
        }

        actual.removeLast();
        expected.removeLast();

        listsEqual(expected, actual);
    }

    @Test
    public void testComposition() {
        final int nums = 8;
        list.LinkedList<Integer> actual = new list.LinkedList<>();
        java.util.LinkedList<Integer> expected = new java.util.LinkedList<>();

        for (int i = 0; i < nums; i++) {
            actual.add(i);
            expected.add(i);
        }

        listsEqual(expected, actual);

        actual.removeFirst();
        expected.removeFirst();

        listsEqual(expected, actual);

        actual.removeLast();
        expected.removeLast();

        listsEqual(expected, actual);

        actual.remove(actual.size() / 2);
        expected.remove(expected.size() / 2);

        listsEqual(expected, actual);

        actual.addFirst(3);
        expected.addFirst(3);

        listsEqual(expected, actual);

        actual.addLast(10);
        expected.addLast(10);

        actual.addLast(11);
        expected.addLast(11);

        System.out.println(actual);
        System.out.println(expected);
        listsEqual(expected, actual);
    }
}
