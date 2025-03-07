package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMain {

    @Test
    public void greeting() {
        assertEquals("Hello World!", Main.getGreeting());
    }
}
