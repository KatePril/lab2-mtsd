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
    public MyList(E... elements) {
        this.elements = elements;
    }

    public int length() {
        return size;
    }

    public void append(E element) {
        if (size == 0) {
            first = new Node<>(element);
            last = first;
            first.next = last;
            last.prev = first;
        } else {
            Node<E> newNode = new Node<>(element);
            newNode.next = last;
            newNode.prev = last.prev;
            last.prev.next = newNode;
            last.prev = newNode;
        }
        size++;

        // TODO delete the code below
        E[] newElements = (E[]) new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = element;
        elements = newElements;
    }

    public void insert(E element, int index) {
        checkIndex(index);
        Node<E> currentNode = getCurrentNode(index);

        Node<E> newNode = new Node<>(element);
        newNode.next = currentNode;
        newNode.prev = currentNode.prev;
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;

    }

    public E delete(int index) {
        checkIndex(index);
        E[] newElements = (E[]) new Object[elements.length - 1];
        E tmp = elements[index];

        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newElements[i] = elements[i];
            }
            if (i > index) {
                newElements[i-1] = elements[i];
            }
        }
        elements = newElements;
        return tmp;
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
        return getCurrentNode(index).value;
    }


    public MyList<E> clone() {
        E[] newElements = (E[]) new Object[elements.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
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
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int findLast(E element) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                index = i;
            }
        }
        return index;
    }

    public void clear() {
        elements = (E[]) new Object[0];
    }

    public void extend(MyList<E> list) {
        E[] newElements = (E[]) new Object[elements.length + list.length()];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        if (list.length() >= 0) System.arraycopy(list.elements, 0, newElements, 0 + elements.length, list.length());
        elements = newElements;
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
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }

    public String toString() {
        return Arrays.toString(elements);
    }

}
