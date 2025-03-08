package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.append("a");
        list.append("b");
        list.append("d");
        list.append("e");
        System.out.println("append: " + list);
        list.insert("c", 2);
        list.insert("b", 4);
        System.out.println("insert: " + list);
        System.out.println("deleteAll: " + Arrays.toString(list.deleteAll("b")));
        System.out.println(list);
        System.out.println("delete: " + list.delete(1));
        System.out.println(list);
        System.out.println("get: " + list.get(0));

        System.out.println();
        MyList<String> secondList = list.clone();
        System.out.println("cloned list: " + secondList);
        list.clear();
        System.out.println("cleared: " + list);
        System.out.println(secondList);
        secondList.reverse();
        System.out.println("reversed: " + secondList);

        System.out.println();

        secondList.append("d");
        System.out.println("append: " + secondList);
        System.out.println(secondList.findFirst("d"));
        System.out.println(secondList.findLast("d"));

        secondList.extend(new MyList<>("a", "b", "c"));
        System.out.println(secondList);
    }
}