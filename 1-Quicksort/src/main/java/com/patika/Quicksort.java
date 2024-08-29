package com.patika;

public class Quicksort {

    // Main method to test the Quick Sort algorithm
    public static void main(String[] args) {
        int[] array = {39, 2, 10, 14, 203};
        System.out.println("Unsorted array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    // Method to perform Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
        // Pivot (Element to be placed at the correct position)
        int pivot = array[high];

        // Index of smaller element
        int i = (low - 1);

        // Traverse through all elements
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] <= pivot) {
                i++;

                // Swap if element is smaller than pivot
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
