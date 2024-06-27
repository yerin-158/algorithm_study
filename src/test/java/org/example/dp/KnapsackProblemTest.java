package org.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackProblemTest {

  @Test
  public void test1() {
    int[] val = {100, 60, 120}; // 가치
    int[] wt = {20, 10, 30}; // 무게
    int W = 50; // 최대 무게

    KnapsackProblem knapsackProblem = new KnapsackProblem();
    knapsackProblem.run(val, wt, W);
  }


}
