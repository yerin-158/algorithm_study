package org.example.greedyAlgorithm.prim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimAlgorithmTest {

  @Test
  public void test1() {
    int[][] edges = {
      {0, 1, 2},
      {0, 3, 6},
      {1, 2, 3},
      {1, 3, 8},
      {1, 4, 5},
      {2, 4, 7},
      {3, 4, 9}
    };

    PrimAlgorithm primAlgorithm = new PrimAlgorithm();
    primAlgorithm.run(5, edges);
  }

}
