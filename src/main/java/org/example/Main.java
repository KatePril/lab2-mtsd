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

        System.out.println();
        MyList<String> secondList = list.clone();
        System.out.println(secondList);
        secondList.clear();
        System.out.println(secondList);
        System.out.println(list);
        list.reverse();
        System.out.println(list);

        System.out.println();
        System.out.println(list.get(0));
        list.append("d");
        System.out.println(list.findFirst("d"));
        System.out.println(list.findLast("d"));

        list.extend(new MyList<>("a", "b", "c"));
        System.out.println(list);
    }
}