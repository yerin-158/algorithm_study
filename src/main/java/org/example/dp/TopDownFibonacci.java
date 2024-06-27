package org.example.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class TopDownFibonacci {

  private Map<Integer, Integer> memo = new HashMap<>();

  /**
   * index가 target과 동일한 값부터 재귀가 돈다.
   * BottomUp에서 target - 1 까지 index가 증가되는 것과 차이가 있음.
   * @param index
   * @return
   */
  private int calculator(int index) {
    // index = 0 일 때는 0 반환
    // index = 2 일 때, 0 + 1 = 1해서 처음 셋팅
    if (index <= 1) {
      return index;
    }

    if (memo.containsKey(index)) {
      return memo.get(index);
    }

    int now = calculator(index - 1) + calculator(index - 2);
    memo.put(index, now);

    return now;
  }

  public void run(int target) {
    int answer = calculator(target);
    System.out.println("target: " + answer);

    memo.forEach((key, value) -> System.out.print(value + ", "));
  }

}
