package com.robosh;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

    private static class Node<T> {
        T element;
        Node<T> nextNode;

        Node(T element) {
            this.element = element;
        }
    }

    private Node<T> node;
    private int size = 0;
    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        List<T> resultList = new LinkedList<>();
        for (T item : elements){
            resultList.add(item);
        }
        return resultList;
    }


    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        add(size, element);
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(element);
        Node<T> previousNode = node;
        size++;
        if (index == 0){
            node = newNode;
            newNode.nextNode = previousNode;
            return;
        }

        int currentPosition = 1;
        while (currentPosition != index){
            currentPosition++;
            previousNode = previousNode.nextNode;
        }
        Node<T> node = previousNode.nextNode;
        previousNode.nextNode = newNode;
        newNode.nextNode = node;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        getCurrentNode(index).element = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        return getCurrentNode(index).element;
    }

    private Node<T> getCurrentNode(int index) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = node;
        int currentIndex = 0;
        while (currentIndex != index){
            currentIndex++;
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        size--;
        if (index == 0){
            node = node.nextNode;
            return;
        }
        Node<T> previousNode = node;
        int currentIndex = 1;
        while (currentIndex != index){
            currentIndex++;
            previousNode = previousNode.nextNode;
        }
        previousNode.nextNode = previousNode.nextNode.nextNode;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> currentNode = node;
        while (currentNode!= null){
            if (currentNode.element == element){
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        node = null;
        size = 0;
    }
}
