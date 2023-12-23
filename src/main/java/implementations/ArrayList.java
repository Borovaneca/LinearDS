package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int INITIAL_SIZE = 14;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if (size == elements.length) {
            resize();
        }
        this.size++;
        this.elements[size - 1] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (validIndex(index)) {
            if (size == elements.length) {
                resize();
            }
            moveRight(index, element);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (validIndex(index)) return (E) elements[index];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if (validIndex(index)) {
            elements[index] = element;
            return element;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E remove(int index) {
        if (validIndex(index)) {
            E toReturn = (E) elements[index];
            moveLeft(index);
            size--;
            return toReturn;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void resize() {
        Object[] newArray = new Object[elements.length + INITIAL_SIZE];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < size;
    }

    private void moveRight(int index,Object object) {
        for (int i = size; i >= index; i--) {
            elements[i] = (i == index) ? object : elements[i - 1];
        }
    }

    private void moveLeft(int index) {
        elements[index] = null;
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

    }
}
