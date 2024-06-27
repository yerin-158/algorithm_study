package org.example.sortAlgorithm.selection;

import java.util.*;

/**
 * Created by robin on 6/24/24.
 *
 * @author robin
 * @version 6/24/24.
 * @implNote First created
 */
public class SelectionSort {

  public void sort(List<Integer> list) {
    Integer[] arr = list.toArray(new Integer[0]);
    Integer position = 0;
    while (position < arr.length) {

      int minValue = arr[position];
      int minIndex = position;
      for (int index = position + 1; index < arr.length; index++) {
        if (arr[index] < minValue) {
          minIndex = index;
          minValue = arr[index];
        }
      }

      arr[minIndex] = arr[position];
      arr[position] = minValue;

      position++;
    }

    for (var value : arr) {
      System.out.print(value + "-> ");
    }

  }

}
