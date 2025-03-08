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

}
