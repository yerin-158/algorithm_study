package org.example.dp;

/**
 * Created by robin on 6/26/24.
 *
 * @author robin
 * @version 6/26/24.
 * @implNote First created
 */
public class LCS {
  public void run(String firstText, String secondText) {

    int firstTextLength = firstText.length();
    int secondTextLength = secondText.length();
    int[][] dp = new int[firstTextLength + 1][secondTextLength + 1];

    for (int firstTextIndex = 1; firstTextIndex <= firstTextLength; firstTextIndex++) {
      System.out.print(firstText.charAt(firstTextIndex - 1) + " : ");
      for (int secondTextIndex = 1; secondTextIndex <= secondTextLength; secondTextIndex++) {
        if (firstText.charAt(firstTextIndex - 1) == secondText.charAt(secondTextIndex - 1)) {
          dp[firstTextIndex][secondTextIndex] = dp[firstTextIndex - 1][secondTextIndex - 1] + 1;
        } else {
          int biggest = Math.max(dp[firstTextIndex - 1][secondTextIndex], dp[firstTextIndex][secondTextIndex - 1]);
          dp[firstTextIndex][secondTextIndex] = biggest;
        }
        System.out.print(dp[firstTextIndex][secondTextIndex] + "(" + secondText.charAt(secondTextIndex - 1) + ")  ");
      }
      System.out.println();
    }

    System.out.println("answer >> " + dp[firstTextLength][secondTextLength]);

  }

}
