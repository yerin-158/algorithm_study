package org.example.searchAlgorithm.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.example.etc.RandomUtils.getRandomElement;
import static org.example.etc.RandomUtils.getRandomNumbers;

class BinaryWhileTest {

  @Test
  public void test1() {
      Set<Integer> list = getRandomNumbers(0, 1000, 100);
      Integer randomPick = getRandomElement(new ArrayList<>(list));

      System.out.println("target >>> "+randomPick);

      BinaryWhile binaryWhile = new BinaryWhile();
      binaryWhile.find(new ArrayList<>(list), randomPick);
  }

}
