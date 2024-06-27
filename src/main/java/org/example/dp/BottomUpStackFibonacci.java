package org.example.dp;

import java.util.Stack;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class BottomUpStackFibonacci {

  private Stack<Integer> stack;

  // 수학에서 피보나치 수(영어: Fibonacci numbers)는 첫째 및 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열
  private int calculate(int max) {
    for (int i = 2; i < max; i++) {
      int prev = stack.pop(); // index의 전값
      int floor = stack.pop(); // index의 전전값

      int now = prev + floor;
      System.out.print(now + ", ");
      stack.push(prev);
      stack.push(now);
    }

    return stack.pop();
  }

  public void run(int target) {
    stack = new Stack<>();

    int first = 1;
    int second = 1;
    stack.push(first);
    stack.push(second);
    System.out.print("1, 1, ");

    int answer = calculate(target);
    System.out.println();
    System.out.println("answer: " + answer);
  }
}
