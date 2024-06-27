package org.example.sortAlgorithm.selection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class selectionSortTest {

  @Test
  public void test1() {
    List<Integer> list = List.of(10, 4, 32, 6, 1, 330, 54, 324, 53, 134, 30, 10, 45, 45, 39);
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.sort(list);
  }

}
