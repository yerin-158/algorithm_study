package org.example.greedyAlgorithm.kruskal;

import org.junit.jupiter.api.Test;

class KruskalAlgorithmTest {

  public static final int INF = 100_000;

  @Test
  public void test1() {
    int V = 4; // 간선의 수
    int E = 5; // 정점의 수

    // {시작노드, 도착노드, 비용}
    int[][] arr = {
      {0, 1, 10},
      {0, 2, 6},
      {0, 3, 5},
      {1, 3, 15},
      {2, 3, 4}
    };


    KruskalAlgorithm algorithm = new KruskalAlgorithm();
    algorithm.findMST(V, E, arr);
  }

}
