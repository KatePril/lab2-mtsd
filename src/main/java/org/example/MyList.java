package org.example;

import java.util.Arrays;

import static java.lang.Math.round;

public class MyList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyList() {
        size = 0;
    }

    @SafeVarargs
    public MyList(E... els) {
        for (E el : els) {
            append(el);
        }
    }

    public int length() {
        return size;
    }

    public void append(E element) {
        if (size == 0) {
            first = new Node<>(element);
            last = first;
            first.setNext(last);
            last.setPrev(first);
        } else {
            Node<E> newNode = new Node<>(element);

            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
        size++;
    }

    public void insert(E element, int index) {
        checkIndex(index);
        Node<E> currentNode = getCurrentNode(index);

        Node<E> newNode = new Node<>(element);
        newNode.setNext(currentNode);
        newNode.setPrev(currentNode.getPrev());
        currentNode.getPrev().setNext(newNode);
        currentNode.setPrev(newNode);
        size++;
    }

    public E delete(int index) {
        checkIndex(index);
        E value = first.getValue();
        if (index == 0) {
            first = first.getNext();
        } else {
            Node<E> currentNode = getCurrentNode(index);
            value = currentNode.getValue();

            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
        }
        size--;

        return value;
    }

    public E[] deleteAll(E element) {
        E[] deletedElements = (E[]) new Object[0];
        Node<E> currentNode = first;

        while (currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                deletedElements = Arrays.copyOf(deletedElements, deletedElements.length + 1);
                deletedElements[deletedElements.length - 1] = currentNode.getValue();

                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                size--;
            }
            currentNode = currentNode.getNext();
        }
        return deletedElements;
    }

    public E get(int index) {
        checkIndex(index);
        return getCurrentNode(index).getValue();
    }


    public MyList<E> clone() {
        E[] newElements = (E[]) new Object[length()];
        for (int i = 0; i < length(); i++) {
            newElements[i] = get(i);
        }
        return new MyList<>(newElements);
    }

    public void reverse() {
        int half = round(length() / 2);
        Node<E> currentBeginning = first;
        Node<E> currentEnd = last;
        for (int i = 0; i < half; i++) {
            E tmp = currentBeginning.getValue();
            currentBeginning.setValue(currentEnd.getValue());
            currentEnd.setValue(tmp);

            currentBeginning = currentBeginning.getNext();
            currentEnd = currentEnd.getPrev();
        }
    }

    public int findFirst(E element) {
        int currentIndex = 0;
        Node<E> currentNode = first;

        while (currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    public int findLast(E element) {
        int currentIndex = length() - 1;
        Node<E> currentNode = last;

        while (currentIndex >= 0) {
            if (currentNode.getValue().equals(element)) {
                return currentIndex;
            }
            currentIndex--;
            currentNode = currentNode.getPrev();
        }

        return currentIndex;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public void extend(MyList<E> list) {
        for (int i = 0; i < list.length(); i++) {
            append(list.get(i));
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getCurrentNode(int index) {
        int currentIndex = 0;
        Node<E> currentNode = first;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    public String toString() {
        E[] list = (E[]) new Object[length()];
        Node<E> currentNode = first;
        int i = 0;
        while (currentNode != null) {
            list[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
            i++;
        }
        return Arrays.toString(list);
    }

}
