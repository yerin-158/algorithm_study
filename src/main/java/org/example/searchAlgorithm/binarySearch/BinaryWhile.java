package org.example.searchAlgorithm.binarySearch;

import java.util.List;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class BinaryWhile {

  public void find(List<Integer> list, Integer target) {
    list.sort(null);

    Integer left = 0;
    Integer right = list.size() - 1;
    while (true) {
      if (right < left) {
        System.out.println("결과를 찾지 못함");
        break;
      }

      Integer centerIndex = (left + right) / 2;
      System.out.println("현재 값 : "+ list.get(centerIndex));

      if (target.equals(list.get(centerIndex))) {
        System.out.println("찾음!! >> " + list.get(centerIndex));
        break;
      }

      if (target < list.get(centerIndex)) {
        right = centerIndex - 1;
      }

      if (target > list.get(centerIndex)) {
        left = centerIndex + 1;
      }
    }
  }
}
