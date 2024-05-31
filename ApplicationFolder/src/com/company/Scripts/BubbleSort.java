package com.company.Scripts;

import java.util.ArrayList;

/**
 * This class provides a method to perform Bubble Sort on an ArrayList of Object arrays.
 */
public class BubbleSort {

    /**
     * Sorts the given ArrayList of Object arrays using the Bubble Sort algorithm.
     *
     * @param arr the ArrayList of Object arrays to be sorted
     */
    public static void bubbleSort(ArrayList<Object[]> arr) {
        for (int j = 0; j < arr.size(); j++) {
            for (int i = j + 1; i < arr.size(); i++) {
                if ((arr.get(i)[1]).toString().compareToIgnoreCase(arr.get(j)[1].toString()) < 0) {
                    Object[] words = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, words);
                }
            }
        }
    }
}
