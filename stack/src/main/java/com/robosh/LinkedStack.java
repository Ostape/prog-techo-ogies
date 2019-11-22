package com.robosh;


import com.robosh.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	private static class Node<T> {
		Node(T element){
			this.element = element;
		}

		T element;
		Node<T> next;
	}

    private int size = 0;
	private Node<T> head;

    @Override
    public void push(T element) {
    	Node<T> newNode = new Node<>(element);
    	size++;
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
    }

    @Override
	public T pop() {
    	if (head == null){
    		throw new EmptyStackException();
		}
		size--;
		T element = head.element;
		this.head = head.next;
		return element;
	}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
