package org.example.greedyAlgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraWithPriorityQueueTest {

  private static final int INF = 100000;

  @Test
  public void test1() {
    int[][] graph = {
        {0, 3, 5, 1, INF, INF},
        {2, 0, 3, 2, INF, INF},
        {5, 3, 0, 3, 1, 5},
        {1, 2, 3, 0, 1, INF},
        {INF, INF, 1, 1, 0, 2},
        {INF, INF, 5, INF, 2, 0}
    };

    int startNode = 0;
    int endNode = 5;

    DijkstraWithPriorityQueue dijkstra = new DijkstraWithPriorityQueue();
    dijkstra.run(graph, startNode, endNode);

  }

}
