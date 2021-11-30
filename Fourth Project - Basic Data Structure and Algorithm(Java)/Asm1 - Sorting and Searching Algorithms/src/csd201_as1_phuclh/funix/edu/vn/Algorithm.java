/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as1_phuclh.funix.edu.vn;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Le Hoang Phuc
 */
public class Algorithm {
    int n;
    float[] a;
    Algorithm() {};
    
    //input elements and write into text file
    public float[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of elements: ");
        n = sc.nextInt();
        System.out.println("Input elements: ");
        a = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("#" + (i+1) + ": ");
            a[i] = sc.nextFloat();
        }
        return a;
    }
    //write into text file
    public void writeFile(String name, float[] a) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(name));
            for (int i = 0; i < n; i++) {
                bw.write(a[i] + " ");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    //reading data from text file
    public float[] readFile(String name) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(name));
            String line;
            while ((line = bf.readLine()) != null) {
                //storing data read from txt file into array
                String[] array = line.split("\\s+");
                n = array.length;
                a = new float[n];
                for (int i = 0; i < n; i++) {
                    //convert data type into float, then store in array a
                    a[i] = Float.parseFloat(array[i]);
                }
            }
            bf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return a;
    }
    
    //display the data in array
    public void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    //sorting by bubble sort algorithm
    public float[] bubbleSort(float[] arr) {
        //make an array copy
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, n);
        //sorting algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (b[j] > b[j+1]) {
                    //swapping items
                    float temp = b[j+1];
                    b[j+1] = b[j];
                    b[j] = temp;
                }
            }
            //display the steps of algorithm
            display(b);
        }
        return b;
    }
    
    //sorting by selection sort algorithm
    public float[] selectionSort(float[] arr) {
        //make an array copy
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, n);
        //sorting algorithm
        for (int i = 0; i < n - 1; i++) {
        int min = i;
            for (int j = i + 1; j < n; j++) {
                if (b[min] > b[j]) {
                    min = j;
                }
            }
            //swap elements
            float temp = b[min];
            b[min] = b[i];
            b[i] = temp;
            //display the steps of algorithm
            display(b);
        }
        return b;
    }
    
    //sorting by insertion sort algorithm
    public float[] insertionSort(float[] arr) {
        //make an array copy
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, n);
        //sorting algorithm
        for (int i = 1; i < n; i++) {
            float current = b[i];
            int j = i - 1;
            while (j >= 0 && b[j] > current) {
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = current;
            //display the steps of algorithm
            display(b);
        }
        return b;
    }
    
    //search value by linear search
    public void linearSearch(float value) {
        //write result into text file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT4.txt"));
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > value) {
                    System.out.print(i + " ");
                    bw.write(i + " ");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No index found at your search!");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println();
    }
    
    //search value by binary search
    public void binarySearch(float[] arr, int l, int r, float value) {
        //write result into text file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT5.txt"));
            int count = 0;
            int mid = (l + r) / 2;
            while (l <= r) {
                if (arr[mid] < value) {
                    l = mid + 1;
                } else if (arr[mid] == value) {
                    System.out.print(mid);
                    bw.write(mid + "");
                    count++;
                    break;
                } else {
                    r = mid - 1;
                }
                mid = (l + r) / 2;
            }
            if (count == 0) {
                System.out.println("No index found at your search!");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println();
    }
}
