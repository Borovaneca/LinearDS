package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private static final int INITIAL_SIZE = 14;
    private Object[] elements;
    private int size;

    public SinglyLinkedList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        if (collectionIsFull()) {
            resize();
        }
        moveAllToRight();
        this.size++;
        this.elements[0] = element;
    }

    @Override
    public void addLast(E element) {
        if (collectionIsFull()) {
            resize();
        }

        elements[size++] = element;
    }

    @Override
    public E removeFirst() {
        E value = (E) elements[0];
        moveAllToLeft();
        this.size--;
        return value;
    }

    @Override
    public E removeLast() {
        E value = (E) elements[size - 1];
        this.size--;
        return value;
    }

    @Override
    public E getFirst() {
        return (E) this.elements[0];
    }

    @Override
    public E getLast() {
        return (E) this.elements[size - 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }

    private void resize() {
        Object[] newArray = new Object[elements.length + INITIAL_SIZE];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    private void moveAllToRight() {
        for (int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
    }

    private boolean collectionIsFull() {
        return this.size == this.elements.length;
    }

    private void moveAllToLeft() {
        for (int i = 0; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

    }
}
