package org.example.searchAlgorithm.binarySearch;

import java.util.Comparator;
import java.util.List;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class BinaryRecursion {
  private void recursion(List<Integer> numbers, Integer target, Integer left, Integer right) {
    if (left > right) {
      System.out.println("값을 찾을 수 없습니다.");
      return;
    }

    Integer centerIndex = (left + right) / 2;
    System.out.println("현재 값 : " + numbers.get(centerIndex));

    if (target.equals(numbers.get(centerIndex))) {
      System.out.println("찾음! >> " + numbers.get(centerIndex));
      return;
    }

    // centerIndex는 이미 비교한 값이므로 필요없음
    if (target < numbers.get(centerIndex)) {
      recursion(numbers, target, left, centerIndex - 1);
    }

    if (target > numbers.get(centerIndex)) {
      recursion(numbers, target, centerIndex + 1, right);
    }
  }

  public void binaryRecursion(List<Integer> numbers, Integer target) {
    // 오름차순 정렬
    numbers.sort(null);
    recursion(numbers, target, 0, numbers.size() - 1);
  }

}
