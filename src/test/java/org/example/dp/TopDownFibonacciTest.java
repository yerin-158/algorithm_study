package org.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopDownFibonacciTest {

  @Test
  public void test1() {
    TopDownFibonacci topDownFibonacci = new TopDownFibonacci();
    topDownFibonacci.run(10);
  }

}
