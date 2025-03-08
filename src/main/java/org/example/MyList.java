package org.example;

import java.util.Arrays;

public class MyList<E> {
    private E[] elements;

    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyList() {
        elements = (E[]) new Object[0];
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

    }

    public E delete(int index) {
        checkIndex(index);
        Node<E> currentNode = getCurrentNode(index);
        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());

        return currentNode.getValue();

    }

    public E[] deleteAll(E element) {
        int occurrencesNum = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                occurrencesNum++;
            }
        }
        if (occurrencesNum == 0) {
            return (E[]) new Object[0];
        }

        E[] newElements = (E[]) new Object[elements.length - occurrencesNum];
        E[] deletedElements = (E[]) new Object[occurrencesNum];
        occurrencesNum = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                deletedElements[occurrencesNum] = elements[i];
                occurrencesNum++;
            } else {
                newElements[i - occurrencesNum] = elements[i];
            }
        }
        elements = newElements;
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
        E[] newElements = (E[]) new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[elements.length - 1 - i];
        }
        elements = newElements;
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
        return Arrays.toString(elements);
    }

}
