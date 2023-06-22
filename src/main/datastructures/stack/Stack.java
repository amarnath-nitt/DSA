package main.datastructures.stack;

/**
 * @author amarnath-nitt 12/05/23
 */
public class Stack {
    /**
     * Implementation of stack using array;
     * */
    private final int [] arr;
    private int index;
    private final int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
        this.index = -1;
        this.arr = new int[capacity];
    }

    public void push(int value){
        arr[++index] = value;
    }
    public int pop(){
        return isEmpty() ? -1 : arr[index--];
    }
    public boolean isEmpty(){
        return index == -1;
    }
    public int size(){
        return index+1;
    }

    public  boolean isFull(){
        return index >= capacity-1;
    }
}
