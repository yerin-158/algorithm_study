package org.example.searchAlgorithm.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LISBinaryTest {

  @Test
  public void test1() {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    LISBinary lisBinary = new LISBinary();
    lisBinary.run(nums);
  }

}
