package org.example.dp;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class BottomUpSimpleFibonacci {

  public void run(int target) {
    int first = 1;
    int second = 1;
    int now = 0;

    for (int i = 2; i < target; i++) {
      now = first + second;
      first = second;
      second = now;
    }

    System.out.println("target: " + now);
  }

}
