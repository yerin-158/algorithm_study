package org.example.springAlgorithm;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class KMPAlgorithm {

  /**
   * 부분 일치 테이블 (LPS, Longest Prefix Suffix) 생성
   * @param pattern
   * @return
   */
  private int[] computeLPSArray(String pattern) {
    int length = 0;
    int i = 1;
    int patternLength = pattern.length();

    int[] lps = new int[patternLength];
    lps[0] = 0;

    while (i < patternLength) {
      if (pattern.charAt(i) == pattern.charAt(length)) {
        length++;
        lps[i] = length;
        i++;
        continue;
      }

      if (length != 0) {
        length = lps[length - 1];
      } else {
        lps[i] = 0;
        i++;
      }
    }

    return lps;
  }

  /**
   * 패턴 검색
   * @param pattern
   * @param text
   */
  public int run(String pattern, String text) {
    int patternLength = pattern.length();
    int targetTextLength = text.length();
    int count = 0;

    int[] lps = computeLPSArray(pattern);

    int textIndex = 0;
    int patternIndex = 0;
    while (textIndex < targetTextLength) {
      if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
        patternIndex++;
        textIndex++;
      }

      if (patternIndex == patternLength) {
        System.out.println("Found pattern at index " + (textIndex - patternIndex));
        count++;
        patternIndex = lps[patternIndex - 1];
      } else if (textIndex < targetTextLength && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
        if (patternIndex != 0) {
          patternIndex = lps[patternIndex - 1];
        } else {
          textIndex++;
        }
      }
    }

    return count;
  }

}
