/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minh.saortinglgorithms;

import java.util.Arrays;

/**
 *
 * @author minh
 */
public class SortingAlgoritm {

    /**
     * @param args the command line arguments
     */
    private static final int [] Numbers ={3,4,5,6,1,2,0,6};

   

    

    // algotitm bubble sort
    private void BubbleSort(int [] Number){
        int temp = 0;
        for (int i = 0; i < Number.length - 1; i++) {
            for (int j = 0; j < Number.length -  1 - i; j++) {
                if(Number[j] > Number[j+1]){
                    temp = Number[j];
                    Number[j] = Number[j + 1];
                    Number[j +1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(Number) + "bubblesorting");
    }
    // algoritm Quick sort
    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low -1);
        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
                
        return i +1;
    }
    
    void Quicksort(int arr[], int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            
            Quicksort(arr, low, pi -1);
            Quicksort(arr, pi +1, high);
        }
    }
    
    static void printArray(int arr[]){
        int n = arr.length;
        for (int i =0 ; i < n ; ++i){
            //System.out.println(arr[i] + "");
            
        }
        System.out.println(Arrays.toString(arr) + "selectSort");
        
    }
    // algoritm simple sellection sort
    public static void selectSort(int [] Number){
        int position = 0;
        for (int i = 0; i < Number.length; i++) {
            int j = i + 1;
            position = i;
            int temp = Number[i];
            for (; j < Number.length ; j++) {
                if(Number[j] < temp){
                    temp = Number[j];
                    position = j;
                }
            }
            Number [position] = Number[i];
            Number[i] = temp;
        }
        System.out.println(Arrays.toString(Number) + "selectSort");
    }
    //algoritm heap sort
    public static void heapSort(int[] Number){
        int len = Number.length - 1;
        int benginIndex = (len - 1) >> 1;
        for (int i = benginIndex; i >= 0; i--) {
            maxHeapify(i, len, Number);
        }
        for (int i = len; i > 0; i--) {
            swap(0, i -1, Number);
            maxHeapify(0, i -1, Number);
        }
        System.out.println(Arrays.toString(Number) + "heapsort");
        
    }
    private static void swap(int i, int j, int[] Number) {
        int temp = Number[i];
        Number[i] = Number[j];
        Number[j] = temp;
    }
    
//    private static void maxHeapify(int i, int len, int[] Number) {
//        int 
//    }
    
    public static void main(String[] args) {
        SortingAlgoritm SA = new SortingAlgoritm();
            System.out.println("bubblesort");
            SA.BubbleSort(Numbers);
            System.out.println("Quicksort");
            int n = Numbers.length;
            SA.Quicksort(Numbers, 0, n-1);
            printArray(Numbers);
            System.out.println("selection");
            SA.selectSort(Numbers);
    }
    
}
