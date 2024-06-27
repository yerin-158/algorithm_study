package org.example.searchAlgorithm.bfs;

import org.example.searchAlgorithm.bfs.BfsQueue;
import org.junit.jupiter.api.Test;

class BfsQueueTest {

  @Test
  public void test1() {
    BfsQueue bfsQueue = new BfsQueue();
    Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    bfsQueue.findAnswer(sample, 7);
  }

  @Test
  public void test2() {
    BfsQueue bfsQueue = new BfsQueue();
    Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    bfsQueue.findAnswer(sample, 5);
  }

}
