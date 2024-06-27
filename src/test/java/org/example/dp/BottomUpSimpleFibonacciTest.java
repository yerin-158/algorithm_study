package org.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottomUpSimpleFibonacciTest {

  @Test
  public void test1() {
    BottomUpSimpleFibonacci bottomUpSimpleFibonacci = new BottomUpSimpleFibonacci();
    bottomUpSimpleFibonacci.run(10);
  }

}
