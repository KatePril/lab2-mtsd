package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("d");
        list.append("e");
        System.out.println(list);
        list.insert("c", 2);
        list.insert("b", 4);
        System.out.println(list);
        System.out.println(Arrays.toString(list.deleteAll("b")));
        System.out.println(list);
        System.out.println(list.delete(0));
        System.out.println(list);
        list.clear();
        System.out.println(list);

    }

    public static String getGreeting() {
        return "Hello World!";
    }
}