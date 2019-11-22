package com.robosh;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

    private static class Node<T> {
        Node(T element) {
            this.element = element;
        }

        T element;
        Node<T> next;
    }

    private int size = 0;
    private Node<T> head;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == null) {
                currentNode.next = newNode;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        T element;
        Node<T> currentNode = head;
        if (head == null){
            return null;
        }
        size--;
        element = currentNode.element;
        head = head.next;
        return element;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
