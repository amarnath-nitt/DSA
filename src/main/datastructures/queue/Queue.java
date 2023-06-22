package main.datastructures.queue;

/**
 * @author amarnath-nitt 12/05/23
 */
public class Queue {
    /**
     * Implementation of queue using array;
     * */
    private int [] arr;
    private int left;
    private int right;

    public Queue(){
        arr = new int[1000];
        this.left = -1;
        this.right = -1;
    }
    public void push(int value){
        if(isEmpty()){
            ++left;
        }
        arr[++right] = value;
    }
    public int pop(){
        return isEmpty() ? -1 : arr[left++];
    }
    public boolean isEmpty(){
        return left == -1 || left > right;
    }
    public int size(){
        return right - left;
    }
}
