package com.satheesh.sorting;

import java.util.Arrays;

public class MergeSortExample {

    public static void main(String[] args) {
        int[] arr = {90, 10, 16, 8, 60, 12, 15, 6, 3};

        System.out.println("Before Sort => "+Arrays.toString(arr));
        new QuickSort().sort(arr);
        System.out.println("After Sort => "+Arrays.toString(arr));
    }
}

class QuickSort{
    private int[]  numbers;

    public void sort(int[] values){
        this.numbers = values;
        this.quickSort(0, values.length-1);
    }
    private void quickSort(int low, int high){
        if(low < high){
            int pivot = partitionBy(low, high);
            quickSort(low, pivot-1);
            quickSort(pivot+1, high);
        }
    }

    private int partitionBy(int low, int high) {
        int pivot = numbers[(low+high)/2];
        int i=low, j=high;

        while(i < j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i < j)
                swap(i, j);
        }
        return j;
    }
    private void swap(int x, int y){
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }
}
class MergeSort{

    private int[] numbers;
    private int[] helper;

    public void sort(int[] values){
        this.numbers = values;
        this.helper = new int[values.length];
        this.mergeSort(0, values.length-1);
    }
    private void mergeSort(int low, int high)
    {
        if(low <  high){
            int mid = (low+high)/2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }
    private void merge(int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j])
                numbers[k++] = helper[i++];
            else
                numbers[k++] = helper[j++];
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k++] = helper[i++];
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.
    }
}


