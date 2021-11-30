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
//generic version of queue
public class MyQueue<T extends Product> {
    
    private Node<T> front;
    private Node<T> rear;
    int length;
   
    //getter and setter

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getRear() {
        return rear;
    }

    public void setRear(Node<T> rear) {
        this.rear = rear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    //default constructor
    public MyQueue() {}
    
    //method
    //check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    //add an item to the rear
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        length++;
    }
    //delete an item to the front
    public T dequeue() {
        T result = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return result;
    }
    //display queue information
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        }
        
        Node<T> current = this.front;
        
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
        System.out.println();
    }
}
