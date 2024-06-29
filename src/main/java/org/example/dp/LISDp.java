package org.example.dp;

import java.util.Arrays;

/**
 * Created by robin on 6/29/24.
 *
 * @author robin
 * @version 6/29/24.
 * @implNote First created
 */
public class LISDp {

  public void run(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return;
    }

    int[] dp = new int[numbers.length];
    Arrays.fill(dp, 1); // 모든 위치에서 최소 부분 수열의 길이는 1임

    int lisLength = 0;
    for (int i = 1; i < numbers.length; i++) {
      // i : numbers 탐색할 인덱스
      for (int j = 0; j < i; j++) {
        // j : i 보다 앞선 numbers 탐색할 인덱스
        if (numbers[i] > numbers[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          lisLength = Math.max(lisLength, dp[i]);
        }
      }
    }

    System.out.println("max length: " + lisLength);
  }

}
