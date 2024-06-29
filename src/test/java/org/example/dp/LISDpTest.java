package org.example.dp;

import org.junit.jupiter.api.Test;

class LISDpTest {

  @Test
  public void test1() {
    LISDp lis = new LISDp();
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

    lis.run(nums);
  }

}
