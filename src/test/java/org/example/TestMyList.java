package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyList {

    @Test
    public void testLength() {
        MyList<Character> list = new MyList<>();
        assertEquals(0, list.length());

        list.append('a');
        list.append('b');
        assertEquals(2, list.length());
    }

    @Test
    public void testGet() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');

        assertEquals('a', list.get(0).charValue());
        assertEquals('b', list.get(1).charValue());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    public void testAppend() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');

        assertEquals('b', list.get(1).charValue());
        assertEquals(2, list.length());
    }

    @Test
    public void testInsert() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.insert('c', 1);

        assertEquals('c', list.get(1).charValue());
        assertEquals('b', list.get(2).charValue());
        assertEquals(3, list.length());

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('d', -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('d', 4));
    }

    @Test
    public void testDelete() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');

        Character removed = list.delete(1);
        assertEquals('b', removed.charValue());
        assertEquals(2, list.length());
        assertEquals('c', list.get(1).charValue());

        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(4));

        removed = list.delete(0);
        assertEquals('a', removed.charValue());
        assertEquals(1, list.length());
    }

    @Test
    public void testDeleteAll() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');
        list.append('b');
        list.append('d');
        list.append('e');

        Object[] removed = list.deleteAll('x');
        assertEquals(6, list.length());
        assertEquals(0, removed.length);

        removed = list.deleteAll('b');
        assertEquals(4, list.length());
        assertEquals(2, removed.length);
        assertArrayEquals(new Object[] {'b', 'b'}, removed);
        assertEquals('c', list.get(1).charValue());
        assertEquals('d', list.get(2).charValue());
    }

    @Test
    public void testClear() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');

        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    public void testClone() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');

        MyList<Character> clone = list.clone();
        assertEquals('a', clone.get(0).charValue());
        assertEquals('b', clone.get(1).charValue());

        list.clear();
        assertEquals(0, list.length());
        assertEquals(2, clone.length());
    }


    @Test
    public void testReverse() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');
        list.reverse();

        assertEquals('c', list.get(0).charValue());
        assertEquals('b', list.get(1).charValue());
        assertEquals('a', list.get(2).charValue());
    }

    @Test
    public void testFindFirst() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');
        list.append('b');
        list.append('d');

        assertEquals(-1, list.findFirst('x'));
        assertEquals(1, list.findFirst('b'));
    }

    @Test
    public void testFindLast() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');
        list.append('c');
        list.append('b');
        list.append('d');

        assertEquals(-1, list.findLast('x'));
        assertEquals(3, list.findLast('b'));
    }

    @Test
    public void testExtend() {
        MyList<Character> list = new MyList<>();
        list.append('a');
        list.append('b');

        MyList<Character> secondList = new MyList<>();
        secondList.append('c');
        secondList.append('d');

        assertEquals(2, list.length());
        list.extend(secondList);
        assertEquals(4, list.length());
        assertEquals('a', list.get(0).charValue());
        assertEquals('b', list.get(1).charValue());
        assertEquals('c', list.get(2).charValue());
        assertEquals('d', list.get(3).charValue());
    }

}
