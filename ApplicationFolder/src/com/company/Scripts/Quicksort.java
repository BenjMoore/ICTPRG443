package com.company.Scripts;

/**
 * This class implements the Quicksort algorithm for sorting an array of integers.
 */
public class Quicksort {
    private int[] numbers;
    private int number;

    /**
     * Sorts the given array using the Quicksort algorithm.
     *
     * @param values the array to be sorted
     */
    public void sort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    /**
     * Recursively sorts the array using the Quicksort algorithm.
     *
     * @param low  the starting index of the portion of the array to be sorted
     * @param high the ending index of the portion of the array to be sorted
     */
    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }

    /**
     * Exchanges the elements at the specified positions in the array.
     *
     * @param i the index of the first element to be exchanged
     * @param j the index of the second element to be exchanged
     */
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
