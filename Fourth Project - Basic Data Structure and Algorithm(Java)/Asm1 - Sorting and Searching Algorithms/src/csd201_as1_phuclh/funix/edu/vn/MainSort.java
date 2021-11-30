/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as1_phuclh.funix.edu.vn;

import java.util.*;

/**
 *
 * @author Le Hoang Phuc
 */
public class MainSort {
    //create 3 random arrays corresponding with best case, worst case, and average
    static Random r = new Random();
    static int[] arrAvgCase = r.ints(0, 1000).limit(1000).toArray();
    static int[] arrBestCase = r.ints(0, 1000).limit(1000).sorted().toArray();
    static int[] arrWorstCase = r.ints(0, 1000).limit(1000).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declare an Algorithm object
        Algorithm t = new Algorithm();
        //main program with menu
        while (true) {
            System.out.println("+-------------------Menu------------------+");
            System.out.println("|      1.Input                            |");
            System.out.println("|      2.Output                           |");
            System.out.println("|      3.Bubble sort                      |");
            System.out.println("|      4.Selection sort                   |");
            System.out.println("|      5.Insertion sort                   |");
            System.out.println("|      6.Search > value                   |");
            System.out.println("|      7.Search = value                   |");
            System.out.println("|      8.Execution time (advanced)        |");
            System.out.println("|      0.Exit                             |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Your choice (0 -> 7): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    t.writeFile("INPUT.txt", t.input());
                    break;
                case 2:
                    System.out.println("Read from file:");
                    System.out.print("Array: " + Arrays.toString(t.readFile("INPUT.txt"))
                            .replace(",", " ")
                            .replace("[", "")
                            .replace("]", ""));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Bubble sort: ");
                    //writing result into text file
                    t.writeFile("OUTPUT1.txt", t.bubbleSort(t.readFile("INPUT.txt")));
                    break;
                case 4:
                    System.out.println("Selection sort: ");
                    //writing result into text file
                    t.writeFile("OUTPUT2.txt", t.selectionSort(t.readFile("INPUT.txt")));
                    break;
                case 5:
                    System.out.println("Insertion sort: ");
                    //writing result into text file
                    t.writeFile("OUTPUT3.txt", t.insertionSort(t.readFile("INPUT.txt")));
                    break;
                case 6:
                    System.out.println("Linear search: ");
                    System.out.print("Input value: ");
                    float ans = sc.nextFloat();
                    System.out.print("Indexes are: ");
                    t.linearSearch(ans);
                    break;
                case 7:
                    //make a copy and sort first to do binary search
                    float[] a = Arrays.copyOf(t.readFile("INPUT.txt"), t.readFile("INPUT.txt").length);
                    Arrays.sort(a);
                    System.out.println("Binary search:");
                    System.out.print("Input value: ");
                    float val = sc.nextFloat();
                    System.out.print("The index of first element: ");
                    t.binarySearch(a, 0, a.length - 1, val);
                    break;
                case 8:
                    sortingAnalysis(); //analyze execution time of these sorting algorithm (advanced requirement)
                    break;
                case 0:
                    System.out.println("Good bye, have a nice day!");
                    return;
                default:
                    System.out.println("INVALID CHOICE. Try again!");
            }
        }
    }
    
    //measuring execution time with random arrays in cases: best, worst and average
    public static void sortingAnalysis() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Sorting algorithm execution time analysis");
            System.out.println("| 1.Worst case                          |");
            System.out.println("| 2.Best case                           |");
            System.out.println("| 3.Average case                        |");
            System.out.println("| 0.Exit                                |");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bubbleSort(arrWorstCase);
                    selectionSort(arrWorstCase);
                    insertionSort(arrWorstCase);
                    break;
                case 2:
                    bubbleSort(arrBestCase);
                    selectionSort(arrBestCase);
                    insertionSort(arrBestCase);
                    break;
                case 3:
                    bubbleSort(arrAvgCase);
                    selectionSort(arrAvgCase);
                    insertionSort(arrAvgCase);
                    break;
                case 0:
                    return;    
            }
        }
    }
    public static void bubbleSort(int[] arr) {
        int[] b = new int[arr.length];
        System.arraycopy(arr,0,b,0,arr.length);
        
        long start = System.nanoTime();
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1 - i; j++) {
                if (b[j] > b[j+1]) {
                    int temp = b[j+1];
                    b[j+1] = b[j];
                    b[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Bubble sort exec.time: " + (end - start) / (double) 1e6 + " ms.");
    }
    public static void selectionSort(int[] arr) {
        int[] b = new int[arr.length];
        System.arraycopy(arr,0,b,0,arr.length);
        
        long start = System.nanoTime();
        for (int i = 0; i < b.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < b.length; j++) {
                if (b[min] > b[j]) {
                    min = j;
                }
            }
            int temp = b[min];
            b[min] = b[i];
            b[i] = temp;
        }
        long end = System.nanoTime();
        System.out.println("Selection sort exec.time: " + (end - start) / (double) 1e6 + " ms.");
    }
    public static void insertionSort(int[] arr) {
        int[] b = new int[arr.length];
        System.arraycopy(arr,0,b,0,arr.length);
        
        long start = System.nanoTime();
        for (int i = 1; i < b.length; i++) {
            int current = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] > current) {
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = current;
        }
        long end = System.nanoTime();
        System.out.println("Insertion sort exec.time: " + (end - start) / (double) 1e6 + " ms.");
    }
}
