package org.example.sortAlgorithm.bubble;

import java.util.List;

/**
 * Created by robin on 6/24/24.
 *
 * @author robin
 * @version 6/24/24.
 * @implNote First created
 */
public class BubbleRecursion {

  private void recursion(Integer[] arr, Integer sortedCount) {
    if (sortedCount == arr.length) {
      return;
    }

    for (int index = 0; index < arr.length - sortedCount - 1; index++) {
      if (arr[index] > arr[index + 1]) {
        int temp = arr[index];
        arr[index] = arr[index + 1];
        arr[index + 1] = temp;
      }
    }

    recursion(arr, sortedCount + 1);
  }

  public void recursion(List<Integer> list) {
    Integer[] arr = list.toArray(new Integer[0]);

    recursion(arr, 0);

    for (var value : arr) {
      System.out.print(value + " -> ");
    }
  }
}
