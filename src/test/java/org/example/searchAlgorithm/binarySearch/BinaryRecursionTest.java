package org.example.searchAlgorithm.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.example.etc.RandomUtils.getRandomElement;
import static org.example.etc.RandomUtils.getRandomNumbers;

class BinaryRecursionTest {

  @Test
  public void test1() {
    Set<Integer> list = getRandomNumbers(0, 1000, 300);
    Integer randomPick = getRandomElement(new ArrayList<>(list));

    System.out.println("target >>> "+randomPick);

    BinaryRecursion binaryRecursion = new BinaryRecursion();
    binaryRecursion.binaryRecursion(new ArrayList<>(list), randomPick);
  }

}
