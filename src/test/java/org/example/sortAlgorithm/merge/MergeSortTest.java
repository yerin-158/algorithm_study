package org.example.sortAlgorithm.merge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

  @Test
  public void test1() {
    List<Integer> list = Arrays.asList(7,23,11,4,33,8,30,2,5,1,0,36,70,31);
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(list);
  }

}
