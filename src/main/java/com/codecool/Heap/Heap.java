package com.codecool.Heap;

import java.util.Arrays;

public class Heap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int itemIndex) {
        return getLeftChildIndex(itemIndex) < size;
    }

    private boolean hasRightChild(int itemIndex) {
        return getRightChildIndex(itemIndex) < size;
    }

    private boolean hasParent(int itemIndex) {
        return getParentIndex(itemIndex) >= 0;
    }

    private int getLeftChild(int itemIndex) {
        return items[getLeftChildIndex(itemIndex)];
    }

    private int getRightChild(int itemIndex) {
        return items[getRightChildIndex(itemIndex)];
    }

    private int getParent(int itemIndex) {
        return items[getParentIndex(itemIndex)];
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty!");
        return items[0];
    }

    public int pop() {
        if (size == 0) throw new IllegalStateException("Heap is empty!");
        int removedItem = items[0];
        items[0] = items[size - 1];
        makeOrderDownTheHeap();
        size--;
        return removedItem;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        makeOrderUpTheHeap();
    }

    private void makeOrderUpTheHeap() {
        int currentIndex = size - 1;
        while (hasParent(currentIndex) && getParent(currentIndex) > items[currentIndex]) {
            swap(getParentIndex(currentIndex), currentIndex);
            currentIndex = getParentIndex(currentIndex);
        }
    }

    private void makeOrderDownTheHeap() {
        int currentIndex = 0;

        while (hasLeftChild(currentIndex)) {
            int smallerChildIndex = getLeftChildIndex(currentIndex);
            if (hasRightChild(0) && getRightChild(currentIndex) < getLeftChild(currentIndex)) {
                smallerChildIndex = getRightChildIndex(currentIndex);
            }

            if (items[currentIndex] < items[smallerChildIndex]) {
                break;
            } else {
                swap(currentIndex, smallerChildIndex);
            }
            currentIndex = smallerChildIndex;
        }
    }

    @Override
    public String toString() {
        String heapToString = "";
        for (int i = 0; i < size; i++) {
            heapToString += " " + items[i];
        }
        return heapToString;
    }
}
