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

    /**
     * Операцію видалення елементів зі списку за значенням.
     * Метод видаляє зі списку усі елементи, які за значенням відповідають шуканому.
     * У випадку передачі елемента, який у списку відсутній, жодні зміни до списку не застосовуються.
     * @param element
     * @return
     */
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

    /**
     * Операцію отримання елементу списку на довільній позиції
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Операцію копіювання списку. При виклику повинен створити копію поточного списку та повернути її.
     * @return
     */
    public MyList<E> clone() {
        return null;
    }

    /**
     * Операцію обернення списку. Метод повинен змінити порядок елементів у поточному списку задом наперед.
     * Елемент, що був останнім стане першим, передостаннім — другим, … а перший — останнім.
     */
    public void reverse() {}

    /**
     * Операцію пошуку елемента за значенням з голови списку.
     * Метод повинен знайти перший елемент у списку, що дорівнює шуканому та повернути його позицію.
     * Нумерація елементів списку починається з 0. У випадку відсутності шуканого елемента у списку, метод повертає -1
     * @param element
     * @return
     */
    public int findFirst(E element) {
        return -1;
    }

    /**
     * Операцію пошуку елемента за значенням з хвоста списку.
     * Метод повинен знайти останній елемент у списку, що дорівнює шуканому та повернути його позицію.
     * Нумерація елементів списку починається з 0. У випадку відсутності шуканого елемента у списку, метод повертає -1.
     * @param element
     * @return
     */
    public int findLast(E element) {
        return -1;
    }

    public void clear() {
        elements = (E[]) new Object[0];
    }

    /**
     * Операцію розширення списку. Метод приймає інший список та додає до поточного списку усі елементи останнього.
     * При цьому подальші зміни в другий список не повинні впливати на перший.
     */
    public void extend() {}

    private void checkIndex(int index) {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        return Arrays.toString(elements);
    }

}
