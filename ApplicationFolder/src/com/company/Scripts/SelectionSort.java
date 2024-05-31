package com.company.Scripts;

import java.util.ArrayList;

/**
 * This class provides a method to perform Selection Sort on an ArrayList of Object arrays.
 */
public class SelectionSort {

    /**
     * Sorts the given ArrayList of Object arrays using the Selection Sort algorithm.
     *
     * @param dataValues the ArrayList of Object arrays to be sorted
     */
    public static void SelectionSort(ArrayList<Object[]> dataValues) {
        int dSize = dataValues.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < dSize - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            int QuestionNumber = Integer.parseInt(dataValues.get(i)[0].toString()); //test
            for (int j = i + 1; j < dSize; j++) {
                if (Integer.parseInt((String) dataValues.get(j)[0]) < Integer.parseInt(dataValues.get(min_idx)[0].toString())) {
                    min_idx = j;
                }
                Object[] temp = dataValues.get(min_idx);
                dataValues.set(min_idx, dataValues.get(i));
                dataValues.set(i, temp);
            }
            System.out.println(dataValues.get(i)[0] + " - " + dataValues.get(i)[0]);
        }
    }
}
