package org.example.searchAlgorithm.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 6/29/24.
 *
 * @author robin
 * @version 6/29/24.
 * @implNote First created
 */
public class LISBinary {

  public void run(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return;
    }

    List<Integer> lis = new ArrayList<>();

    for (int number: numbers) {
      int newPosition = this.binarySearch(lis, number);
      if (newPosition < lis.size()) {
        lis.set(newPosition, number);
      } else {
        lis.add(number);
      }
    }

    System.out.println("max length: " + lis.size());
  }


  private static int binarySearch(List<Integer> lis, int target) {
    int left = 0, right = lis.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (lis.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

}
