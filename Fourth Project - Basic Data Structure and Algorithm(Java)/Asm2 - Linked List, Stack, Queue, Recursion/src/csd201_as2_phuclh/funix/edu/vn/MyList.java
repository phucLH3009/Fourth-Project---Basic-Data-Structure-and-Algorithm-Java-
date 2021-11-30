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

//generic version of the linked list
public class MyList<T extends Product> {
    //inheritance from product class
    
    private Node<T> head;
    private Node<T> tail;
    
    //getter and setter
    public Node<T> getHead() {    
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {    
        this.tail = tail;
    }

    //default constructor
    public MyList() {
        this.head = null;
        this.tail = null;
    }
    
    //method
    //check if the list is empty
    public boolean isEmpty() {
        return this.head == null;
    }
    
    //add node at the end of the list
    public void insertAtEnd(T data) {
        //create new node with given value
        Node<T> newNode = new Node<>(data);
        //check if list is empty and assigning new value to head
        if (isEmpty()) {
            head = newNode;
        }
        //if list already exist
        else {
            tail.setNext(newNode);
        }
        //assign new node to tail
        tail = newNode;
    }
    
    //display all the list
    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
        }
        
        Node<T> current = this.head;
        
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
        System.out.println();
    }
    
    //clear all the list
    public void clear() {
        this.head = null;
        this.tail = null;
    }
    
    //delete a node with given value
    public void deleteNode(T data) {
        //check if head node value is equal, point the next node to head
        if (head.getData().equals(data)) {
            head = head.getNext();
            return;
        }
        //create new node and assign to head;
        Node<T> newNode = head;
        //iterate till the end of the list
        while (newNode.getNext() != null) {
            if (newNode.getNext().getData().equals(data)) {
                newNode.setNext(newNode.getNext().getNext());
                return;
            }
            newNode = newNode.getNext();
        }
    }
    
    //quick sort algorithm
    //set pivot
    public Node<T> partitionLast(Node<T> head, Node<T> tail) {
        if (head == tail || head == null || tail == null) {
            return head;
        }
        Node<T> pivotPrev = head;
        Node<T> current = head;
        T pivot = tail.getData();
        //iterate till one before the end because pivot is the end node
        while (head != tail) {
            //compare to node with ID attribute from Product class
            if (head.getData().getId().compareToIgnoreCase(pivot.getId()) < 0) {
                pivotPrev = current;
                //swap node data
                T temp = current.getData();
                current.setData(head.getData());
                head.setData(temp);
                current = current.getNext();
            }
            head = head.getNext();
        }
        //swap the position of current i.e next suitable index and pivot
        T temp = current.getData();
        current.setData(pivot);
        tail.setData(temp);
        //return one previous to current because current is now pointing to pivot
        return pivotPrev;
    }
    //quick sort with recursion
    public void quickSort(Node<T> head, Node<T> tail) {
        if (head == null || head == tail || head == tail.getNext()) {
            return;
        }
        //split list and partition recurse
        Node<T> pivotPrev = partitionLast(head, tail);
        quickSort(head, pivotPrev);
        //if pivot is picked and moved to the start, it means head and pivot is the same
        //so pick from next
        if (pivotPrev != null && pivotPrev == head) {
            quickSort(pivotPrev.getNext(), tail);
        }
        //if pivot is in between of the list, start from next
        //move two nodes
        else if (pivotPrev != null && pivotPrev.getNext() != null) {
            quickSort(pivotPrev.getNext().getNext(), tail);
        }
    }
    
    //convert node value from decimal to binary
    public int convertToBinary(int value) {
        if(value == 0) {
            return 0;
        }
        else {
            //recursion by (value / 2) till breakpoint
            return (value % 2 + 10 * convertToBinary(value / 2));
        }
    }
}
