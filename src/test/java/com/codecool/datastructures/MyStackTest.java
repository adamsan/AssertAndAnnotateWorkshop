package com.codecool.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private final MyStack<Integer> stack = new MyStack<>();
    private final MyStack<String> stringStack = new MyStack<>();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testEmptyHasZeroSize(){
        assertEquals(0, stack.size());
    }

    @Test
    void testEmpty(){
        assertTrue(stack.isEmpty());
    }
    @Test
    void testNotEmpty(){
        assertTrue(stack.isEmpty());
        stack.push(44);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testNotEmptyCanBecomeEmpty(){
        assertTrue(stack.isEmpty());
        stack.push(44);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testAddingOneElementIncreasesSize() {
        stack.push(4);
        assertEquals(1, stack.size());
    }

    @Test
    void testAddingElementsIncreasesSize() {
        stack.push(4);
        assertEquals(1, stack.size());
        stack.push(6);
        assertEquals(2, stack.size());
        stack.push(33);
        assertEquals(3, stack.size());
    }

    @Test
    void testRemoveElementsDecresesSize() {
        stack.push(44);
        stack.push(42);
        stack.push(155);
        stack.pop();
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void testRemoveFromEmptyThrowsException() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void popReturnesLastItem() {
        stack.push(5);
        assertEquals(5, stack.pop());
    }

    @Test
    void popReturnsLastItemAndRemovesIt() {
        stack.push(5);
        stack.push(7);
        stack.push(2);
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void testPushAndPopMultipleTimes() {
        stack.push(5);
        stack.push(7);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());

        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void testStringStackPushAndPopMultipleTimes() {
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        assertEquals("c", stringStack.pop());
        assertEquals("b", stringStack.pop());
        assertEquals("a", stringStack.pop());

        stringStack.push("x");
        assertEquals("x", stringStack.pop());
    }
    @Test
    void testStackDataToListForEmptyStack() {
        assertEquals(Collections.emptyList(), stack.toList());
    }

    @Test
    void testStackDataToList() {
        stack.push(4);
        stack.push(6);
        stack.push(12);
        stack.push(-3);
        stack.pop();
        assertEquals(List.of(4, 6, 12), stack.toList());
    }
}