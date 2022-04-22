package com.codecool.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyStackTest {

    private final MyStack<Integer> stack = new MyStack<>();
    private final MyStack<String> stringStack = new MyStack<>();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testEmptyHasZeroSize() {
        assertThat(stack.size()).isZero();
    }

    @Test
    void testEmpty() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void testNotEmpty() {
        assertThat(stack.isEmpty()).isTrue();
        stack.push(44);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void testNotEmptyCanBecomeEmpty() {
        assertThat(stack.isEmpty()).isTrue();
        stack.push(44);
        assertThat(stack.isEmpty()).isFalse();
        stack.pop();
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void testAddingOneElementIncreasesSize() {
        stack.push(4);
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void testAddingElementsIncreasesSize() {
        stack.push(4);
        assertThat(stack.size()).isEqualTo(1);
        stack.push(6);
        assertThat(stack.size()).isEqualTo(2);
        stack.push(33);
        assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    void testRemoveElementsDecresesSize() {
        stack.push(44);
        stack.push(42);
        stack.push(155);
        stack.pop();
        assertThat(stack.size()).isEqualTo(2);
        stack.pop();
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    void testRemoveFromEmptyThrowsException() {
        assertThatThrownBy(stack::pop).isExactlyInstanceOf(EmptyStackException.class);
    }

    @Test
    void popReturnesLastItem() {
        stack.push(5);
        assertThat(stack.pop()).isEqualTo(5);
    }

    @Test
    void popReturnesLastItemAndRemovesIt() {
        stack.push(5);
        stack.push(7);
        stack.push(2);
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(7);
        assertThat(stack.pop()).isEqualTo(5);
    }

    @Test
    void testPushAndPopMultipleTimes() {
        stack.push(5);
        stack.push(7);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(7);
        assertThat(stack.pop()).isEqualTo(5);

        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    void testStringStackPushAndPopMultipleTimes() {
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        assertThat(stringStack.pop()).isEqualTo("c");
        assertThat(stringStack.pop()).isEqualTo("b");
        assertThat(stringStack.pop()).isEqualTo("a");

        stringStack.push("x");
        assertThat(stringStack.pop()).isEqualTo("x");
    }

    @Test
    void testStackDataToListForEmptyStack() {
        assertThat(stack.toList()).isEqualTo(Collections.emptyList());
    }

    @Test
    void testStackDataToList() {
        stack.push(4);
        stack.push(6);
        stack.push(12);
        stack.push(-3);
        stack.pop();
        assertThat(stack.toList()).containsExactly(4, 6, 12);
    }
}