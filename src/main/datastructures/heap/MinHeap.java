package main.datastructures.heap;

/**
 * @author amarnath-nitt 07/05/23
 */
public class MinHeap {
    /**
     * A Min Heap is a binary tree-based data structure where the value of each node is less than or equal to the values of its children.
     * */
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[this.capacity + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private boolean isLeaf(int index) {
        return (index > size / 2) && (index <= size);
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void minHeapify(int index) {
        int current = index;
        while (!isLeaf(current)) {
            int minChild = leftChild(current);
            if (rightChild(current) <= size && heap[rightChild(current)] < heap[leftChild(current)]) {
                minChild = rightChild(current);
            }
            if (heap[current] > heap[minChild]) {
                swap(current, minChild);
                current = minChild;
            } else {
                break;
            }
        }
    }

    public void insert(int element) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full.");
        }
        heap[++size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        int min = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return min;
    }

    public void buildHeap(int[] array) {
        if (array.length > capacity) {
            throw new IllegalArgumentException("Input array size exceeds heap capacity.");
        }
        size = array.length;
        System.arraycopy(array, 0, heap, 1, size);
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void printHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("Parent: " + heap[i] + " Left Child: " + heap[2 * i] + " Right Child: " + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);

        heap.insert(4);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);

        System.out.println("Current heap:");
        heap.printHeap();

        int min = heap.removeMin();
        System.out.println("Removed min element: " + min);

        System.out.println("Current heap after removing min element:");
        heap.printHeap();

        int[] array = {3, 5, 7};
        heap.buildHeap(array);

        System.out.println("Heap after building with array {3, 5, 7}:");
        heap.printHeap();
    }
}

