package org.example.sortAlgorithm.quick;

import org.junit.jupiter.api.Test;

class RecursionQuickSortTest {

  @Test
  public void test1() {
    int[] arr = {11,7,34,8,56,30,70,890,28,84,2,13,68,4,93,47,43,88,54,31};

    RecursionQuickSort recursionQuickSort = new RecursionQuickSort();
    recursionQuickSort.sort(arr);
  }

}