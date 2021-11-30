/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuclh.funix.edu.vn;

/**
 *
 * @author Le Hoang Phuc
 */

//generic version of the Node class
public class Node<T extends Product> {
    //node inheritance to product
    
    private T data;
    private Node<T> next;
    
    //getter and setter

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    //constructor
    public Node() {}
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    //overriding to convert node to string to display
    @Override
    public String toString() {
        return data.toString(); //inheritance from product class
    }
}
