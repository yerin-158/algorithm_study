package org.example.sortAlgorithm.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeapSortTest {

  @Test
  @DisplayName("오름차순 정렬 (최대힙)")
  public void test1() {
    int[] arr = {89,3,73,13,236,87,8,123,45,5,4,1,546,234,2,6,65};

    HeapSort heapSort = new HeapSort();
    heapSort.sortAsc(arr);
  }

  @Test
  @DisplayName("내림차순 정렬 (최소힙)")
  public void test2() {
    int[] arr = {89,3,73,13,236,87,8,123,45,5,4,1,546,234,2,6,65};

    HeapSort heapSort = new HeapSort();
    heapSort.sortDesc(arr);
  }

}
