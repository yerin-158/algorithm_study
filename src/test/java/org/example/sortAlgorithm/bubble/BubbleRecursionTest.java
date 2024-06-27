package org.example.sortAlgorithm.bubble;

import org.junit.jupiter.api.Test;

import java.util.List;

class BubbleRecursionTest {


  @Test
  public void test3() {
    List<Integer> list = List.of(10, 4, 32, 6, 1, 330, 54, 324, 53, 134, 30, 10, 45, 45, 39);
    BubbleRecursion bubbleSort = new BubbleRecursion();
    bubbleSort.recursion(list);
  }
}
