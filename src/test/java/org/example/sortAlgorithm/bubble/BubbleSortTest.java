package org.example.sortAlgorithm.bubble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

  @Test
  public void test1() {
    List<Integer> list = List.of(10, 4, 32, 6, 1, 330, 54, 324, 53, 134, 30, 10, 45, 45, 39);
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.sort(list);
  }

  @Test
  public void test2() {
    List<Integer> list = List.of(10, 4, 32, 6, 1, 330, 54, 324, 53, 134, 30, 10, 45, 45, 39);
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.sort2(list);
  }

}
