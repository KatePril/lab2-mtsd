package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyList {

    @Test
    public void testLength() {
        MyList<String> list = new MyList<>();
        assertEquals(0, list.length());

        list.append("a");
        list.append("b");
        assertEquals(2, list.length());
    }

    @Test
    public void testGet() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    public void testAppend() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");

        assertEquals("b", list.get(1));
        assertEquals(2, list.length());
    }

    @Test
    public void testInsert() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.insert("c", 1);

        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals(3, list.length());

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert("d", -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert("d", 4));
    }

    @Test
    public void testDelete() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");

        String removed = list.delete(1);
        assertEquals("b", removed);
        assertEquals(2, list.length());
        assertEquals("c", list.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(4));

        removed = list.delete(0);
        assertEquals("a", removed);
        assertEquals(1, list.length());
    }

    @Test
    public void testDeleteAll() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("b");
        list.append("d");
        list.append("e");

        Object[] removed = list.deleteAll("x");
        assertEquals(6, list.length());
        assertEquals(0, removed.length);

        removed = list.deleteAll("b");
        assertEquals(4, list.length());
        assertEquals(2, removed.length);
        assertArrayEquals(new Object[] {"b", "b"}, removed);
        assertEquals("c", list.get(1));
        assertEquals("d", list.get(2));
    }

    @Test
    public void testClear() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");

        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    public void testClone() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");

        MyList<String> clone = list.clone();
        assertEquals("a", clone.get(0));
        assertEquals("b", clone.get(1));

        list.clear();
        assertEquals(0, list.length());
        assertEquals(2, clone.length());
    }


    @Test
    public void testReverse() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.reverse();

        assertEquals("c", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("a", list.get(2));
    }

    @Test
    public void testFindFirst() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("b");
        list.append("d");

        assertEquals(-1, list.findFirst("x"));
        assertEquals(1, list.findFirst("b"));
    }

    @Test
    public void testFindLast() {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("b");
        list.append("d");

        assertEquals(-1, list.findLast("x"));
        assertEquals(3, list.findLast("b"));
    }

}
