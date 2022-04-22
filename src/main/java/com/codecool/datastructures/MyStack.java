package com.codecool.datastructures;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {

    private int size = 0;
    private Node last;

    public int size() {
        return size;
    }

    public void push(T item) {
        if (last == null) last = new Node(item);
        else {
            last = new Node(item, last);
        }
        size++;
    }

    public T pop() {
        if (size == 0) throw new EmptyStackException();
        size--;
        T value = last.value;
        last = last.next;
        return value;
    }

    public List<T> toList() {
        Node current = last;
        List<T> result = new LinkedList<>();
        while(current != null ) {
            result.add(current.value);
            current = current.next;
        }
        Collections.reverse(result);
        return result;
    }

    public boolean isEmpty() {
        return last == null;
    }

    class Node {
        T value;
        Node next;

        Node(T v) {
            value = v;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

