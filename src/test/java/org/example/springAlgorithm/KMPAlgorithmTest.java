package org.example.springAlgorithm;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

class KMPAlgorithmTest {

  @Test
  public void test1() {
    String text = "ABABDABACDABABCABAB";
    String pattern = "ABABCABAB";
    KMPAlgorithm kmp = new KMPAlgorithm();
    int count = kmp.run(pattern, text);
    System.out.println("Pattern found " + count + " times.");
  }

}
