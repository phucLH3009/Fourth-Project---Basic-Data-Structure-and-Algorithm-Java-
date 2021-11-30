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
import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class AS2_Main {

    //build a DualStream class extends PrintStream to save output console to text file
    public static class DualStream extends PrintStream {
        
        private final PrintStream out; //print to console
        private final PrintStream file; //save output to file
        
        //constructor
        public DualStream (File file, PrintStream out) throws FileNotFoundException {
            super(file);
            this.out = out;
            this.file = new PrintStream(file);
        }
        //system.out.print method to save and print altogether
        public void println(String string) {
            out.println(string);
            file.println(string);
        }
        
        public void print(String string) {
            out.print(string);
            file.println(string);
        }
    }
    
    //initialize some global variable
    static String url = "src/data.txt";
    static MyList<Product> myList = new MyList<Product>();
    static MyStack<Product> myStack = new MyStack<Product>();
    static MyQueue<Product> myQueue = new MyQueue<Product>();
    static OperationToProduct productOperation = new OperationToProduct();
    static Scanner scanner = new Scanner(System.in);
    
    //show menu of the main program
    public static void showMenu() {
        System.out.println("Choose one of these options: ");
        System.out.println("+-------Product list-------+");
        System.out.println("1.Load data from file and display");
        System.out.println("2.Input and add to the end");
        System.out.println("3.Display data");
        System.out.println("4.Save product list to file");
        System.out.println("5.Search by ID");
        System.out.println("6.Delete by ID");
        System.out.println("7.Sort by ID");
        System.out.println("8.Convert to Binary");
        System.out.println("9.Load to stack and display");
        System.out.println("10.Load to queue and display");
        System.out.println("0.Exit");
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        //initialize printstream object and save console into file console_output
        try {
            DualStream out = new DualStream(new File("src/console_output.txt"), System.out);
            System.setOut(out);
        } finally {
            out.flush();
            out.close();
        }
        //main program
        while (true) {
            
            //print show menu
            showMenu();
            //choose functions respectively
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    productOperation.getAllItemsFromFile(url, myList);
                    System.out.println("Successfully!");
                    break;
                case 2:
                    productOperation.addProduct(myList);
                    break;
                case 3:
                    productOperation.displayAll(myList);
                    break;
                case 4:
                    productOperation.writeAllItemsToFile(url, myList);
                    System.out.println("Successfully!");
                    break;
                case 5:
                    productOperation.searchById(myList);
                    break;
                case 6:
                    productOperation.deleteById(myList);
                    System.out.println("Deleted!");
                    break;
                case 7:
                    productOperation.sortById(myList);
                    System.out.println("Successfully!");
                    break;
                case 8:
                    productOperation.headConvertToBinary(myList);
                    break;
                case 9:
                    productOperation.getAllItemsFromFile(url, myStack);
                    System.out.println("Successfully!");
                    break;
                case 10:
                    productOperation.getAllItemsFromFile(url, myQueue);
                    System.out.println("Successfully!");
                    break;
                case 0:
                    return;
                default:
                    System.err.println("INVALID CHOICE! Try again.");
            }
        }
    }
}
