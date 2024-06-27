package org.example.sortAlgorithm.insertion;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robin on 6/24/24.
 *
 * @author robin
 * @version 6/24/24.
 * @implNote First created
 */
public class InsertionSort {

  public void sort(List<Integer> list) {
    Integer[] arr = list.toArray(new Integer[0]);

    for (int index = 1; index < list.size(); index++) {
      int nowValue = arr[index];
      int prev = index - 1;

      // prev index가 nowIndex위치에서 왼쪽으로 이동함.
      while (prev >= 0 && arr[prev] > nowValue) {
        arr[prev + 1] = arr[prev];
        arr[prev] = nowValue;
        prev--;
      }
    }

    for (Integer val : arr) {
      System.out.print(val + " -> ");
    }
  }

  public void sortList(List<Integer> list) {
    for (int index = 1; index < list.size(); index++) {
      int nowValue = list.get(index);
      int prevIndex = index - 1;

      while (prevIndex >= 0 && list.get(prevIndex) > nowValue) {
        list.set(prevIndex + 1, list.get(prevIndex));
        prevIndex--;
      }
      list.set(prevIndex + 1, nowValue);
    }

    for (Integer val : list) {
      System.out.print(val + " -> ");
    }
    System.out.println();
  }


}
