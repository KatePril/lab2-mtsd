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
    }
}
