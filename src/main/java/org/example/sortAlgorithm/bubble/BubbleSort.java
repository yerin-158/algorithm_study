package org.example.sortAlgorithm.bubble;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class BubbleSort {
  public void sort(List<Integer> list) {
    Integer[] arr = list.toArray(new Integer[list.size()]);
    Integer sortedCount = 0;
    boolean swapped;

    while (sortedCount < arr.length) {
      swapped = false;

      for (int index = 0; index < arr.length - 1 - sortedCount; index++) {
        if (arr[index] > arr[index + 1])  {
          int temp = arr[index + 1];
          arr[index + 1] = arr[index];
          arr[index] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }

      sortedCount++;
    }

    for (var value : arr) {
      System.out.print(value + " -> ");
    }
  }

  public void sort2(List<Integer> list) {
    Integer[] arr = list.toArray(new Integer[0]); // 0으로 하면 list와 동일한 개수로 생성됨.
    int arrSize = arr.length;
    boolean swapped = false;

    // sortCount의 역할을 하는게 i
    for (int i = 0; i < arrSize - 1; i++) {
      swapped = false;

      // 사실상 값비교는 j에서 이뤄짐
      // j는 무조건 0부터 다시 시작하므로 정렬되는 것
      for (int j = 0; j < arrSize - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) break;
    }

    for (var value : arr) {
      System.out.print(value + " -> ");
    }
  }

}
