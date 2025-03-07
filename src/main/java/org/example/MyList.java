package org.example;

import java.util.Arrays;

public class MyList<E> {
    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[0];
    }

    @SafeVarargs
    public MyList(E... elements) {
        this.elements = elements;
    }

    public int length() {
        return elements.length;
    }

    public boolean append(E element) {
        E[] newElements = (E[]) new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = element;
        elements = newElements;
        return true;
    }

    public boolean insert(E element, int index) {
        checkIndex(index);
        E[] newElements = (E[]) new Object[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newElements[i] = elements[i];
            }
            if (i == index) {
                newElements[i] = element;
                newElements[i+1] = elements[i];
            }
            if (i > index) {
                newElements[i+1] = elements[i];
            }
        }
        elements = newElements;
        return true;
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
        return elements[index];
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

    public String toString() {
        return Arrays.toString(elements);
    }

}
