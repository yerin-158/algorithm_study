package org.example.sortAlgorithm.insertion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

  @Test
  public void test1() {
    List<Integer> list = List.of(7,23,11,4,33,8,30,2,5,1,0,36,70,31);
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.sort(list);
  }

  @Test
  public void test2() {
    List<Integer> list = Arrays.asList(7,23,11,4,33,8,30,2,5,1,0,36,70,31);
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.sortList(list);
  }

}
