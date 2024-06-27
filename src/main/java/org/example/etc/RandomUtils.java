package org.example.etc;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class RandomUtils {

  public static Set<Integer> getRandomNumbers(int start, int end, int count) {
    if (count > (end - start + 1)) {
      throw new IllegalArgumentException("Count is larger than the range of numbers.");
    }

    Random random = new Random();
    Set<Integer> randomNumbers = new HashSet<>();

    while (randomNumbers.size() < count) {
      int randomNumber = random.nextInt(end - start + 1) + start;
      randomNumbers.add(randomNumber);
    }

    return randomNumbers;
  }

  public static int getRandomElement(List<Integer> list) {
    Random random = new Random();
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }

}
