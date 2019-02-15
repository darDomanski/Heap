package com.codecool.Heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeapTest {

    @Test
    public void testAddOneNumberToEmptyHeap() {
        Heap heap = new Heap();
        heap.add(1);
        String heapToString = heap.toString();

        String expected = " 1";

        assertEquals(expected, heapToString);
    }

    @Test
    public void testAddFewNumbersToEmptyHeap() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(99);
        heap.add(10);
        heap.add(20);
        String heapToString = heap.toString();

        String expected = " 1 20 10 99";

        assertEquals(expected, heapToString);
    }

    @Test
    public void testPeekNumberFromHeapContainingNumbers() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(10);
        heap.add(20);
        int root = heap.peek();

        int expected = 1;

        assertEquals(expected, root);
    }

    @Test
    public void testPeekFromEmptyHeap() {
        Heap heap = new Heap();

        assertThrows(IllegalStateException.class, () -> heap.peek());
    }

    @Test
    public void testPopFromEmptyHeap() {
        Heap heap = new Heap();

        assertThrows(IllegalStateException.class, () -> heap.pop());
    }

    @Test
    public void testPopFromHeapContainingNumbers() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(10);
        heap.add(20);

        int removedItem = heap.pop();
        int expected = 1;

        assertEquals(expected, removedItem);
    }

    @Test
    public void testIfPopRemovesItemFromHeap() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(10);
        heap.add(20);
        heap.pop();
        String heapToString = heap.toString();

        String expected = " 10 20";

        assertEquals(expected, heapToString);
    }


}