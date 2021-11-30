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
import java.io.*;
import java.util.*;
public class OperationToProduct {
    Scanner sc = new Scanner(System.in);
    //print header
    public void header() {
        System.out.println(String.format("%-6s|%-15s|%-8s|%-10s", "ID", "Title", "Quantity", "Price"));
        System.out.println("-----------------------------");
    }
    //read data from file and return Product object
    public Product addProductDetail(String string) {
        String[] array = string.split("\\|");
        
        Product p = new Product();
        
        p.setId(array[0].trim());
        p.setTitle(array[1].trim());
        p.setQuantity(Integer.parseInt(array[2].trim()));
        p.setPrice(Double.parseDouble(array[3].trim()));
        
        return p;
    }
    //read data from file and display into list at tail
    public void getAllItemsFromFile(String filename, MyList<Product> list) {
        list.clear();
        header();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/data.txt"));
            String line;
            
            while ((line = bf.readLine()) != null) {
                list.insertAtEnd(addProductDetail(line));
            }
            bf.close();
            list.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //read data from file and display into stack
    public void getAllItemsFromFile(String filename, MyStack<Product> stack) {
        header();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/data.txt"));
            String line;
            
            while ((line = bf.readLine()) != null) {
                stack.push(addProductDetail(line));
            }
            bf.close();
            stack.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //read data from file and display into queue
    public void getAllItemsFromFile(String filename, MyQueue<Product> queue) {
        header();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/data.txt"));
            String line;
            
            while ((line = bf.readLine()) != null) {
                queue.enqueue(addProductDetail(line));
            }
            bf.close();
            queue.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //create product and add to the tail of linked list
    //create product
    public Product createProduct() {
        
        Product p = new Product();
        
        System.out.print("Input new ID: ");
        p.setId(sc.nextLine());
        System.out.print("Input product's name: ");
        p.setTitle(sc.nextLine());
        System.out.print("Input product's quantity: ");
        p.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.print("Input product's price: ");
        p.setPrice(Double.parseDouble(sc.nextLine()));
        
        return p;
    }
    //add to the list at tail
    public void addProduct(MyList<Product> list) {
        
        Product added = createProduct();
        if (!list.isEmpty()) {
            Node<Product> current = list.getHead();
            
            while (current != null) {
                //check if id is duplicated
                while (current.getData().getId().equalsIgnoreCase(added.getId())) {
                    System.out.println("ID with this product existed. Try again!");
                    added = createProduct();
                }
                current = current.getNext();
            }
            //add to the tail
            list.insertAtEnd(added);
        }
    }
    
    //display list with added product
    public void displayAll(MyList<Product> list) {
        header();
        list.display();
    }
    
    //save product list to a file
    public void writeAllItemsToFile(String filename, MyList<Product> list) {
        if (!list.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
                Node<Product> current = list.getHead();
                
                while (current != null) {
                    bw.write(current.getData().toString() + "\n");
                    current = current.getNext();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    //search product by id
    public void searchById(MyList<Product> list) {
        System.out.print("Input the ID to search: ");
        String id = sc.nextLine();
        
        //initialize count
        int count = 0;
        Node<Product> current = list.getHead();
        //iterate linked list and increment count if found product required
        while (current != null) {
            if (current.getData().getId().equalsIgnoreCase(id)) {
                System.out.print("Result: " + current.getData().toString() + "\n");
                count++;
            }
            current = current.getNext();
        }
        //if not found, return -1
        if (count == 0) {
            System.out.println("-1");
        }
    }
    
    //delete product by id
    public void deleteById(MyList<Product> list) {
        System.out.print("Input the ID to delete: ");
        String id = sc.nextLine();
        
        //initialize count
        int count = 0;
        Node<Product> current = list.getHead();
        //iterate linked list
        while (current != null) {
            if (current.getData().getId().equalsIgnoreCase(id)) {
                //delete this node
                list.deleteNode(current.getData());
                count++;
            }
            current = current.getNext();
        }
        //if not found, display error
        if (count == 0) {
            System.out.println("Not found product to delete!");
        }
    }
    
    //sort product by id (using quick sort)
    public void sortById(MyList<Product> list) {
        Node<Product> current = list.getHead();
        //iterate list
        while (current.getNext() != null) {
            current = current.getNext();
        }
        list.quickSort(list.getHead(), current);
    }
    
    //convert product's quantity at head of the linked list using recursion
    public void headConvertToBinary(MyList<Product> list) {
        System.out.print("Quantity: " + list.getHead().getData().getQuantity()
        
                        + " => " + list.convertToBinary(list.getHead().getData().getQuantity()) + "\n");
    }
}
