package org.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSTest {

  @Test
  public void test1() {
    LCS lcs = new LCS();
    String first = "BDCAB";
    String second = "ABCBDAB";
    lcs.run(first, second);
  }

}
