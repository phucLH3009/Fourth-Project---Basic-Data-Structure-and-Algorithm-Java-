/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuclh.funix.edu.vn;

/**
 *
 * @author Le Hoang Phuc
 * @param <T>
 */

//generic version of stack
public class MyStack<T extends Product> {
    
    private Node<T> head;
    private int length;

    //getter and setter
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    //default constructor
    public MyStack() {
        this.head = null;
    };
    
    //method
    //check if stack is empty
    public boolean isEmpty() {
        return this.head == null;
    }
    //push an item on top of stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        head = newNode;
        length++;
    }
    //return the top of the stack (head)
    public T peek() {
        return this.head.getData();
    }
    //remove an item from the top of stack
    public T pop() {
        T result = head.getData();
        head = head.getNext();
        length--;
        return result;
    }
    //display stack information
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        
        Node<T> current = this.head;
        
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
        System.out.println();
    }
}
