package org.example.searchAlgorithm.dfs;

import org.example.searchAlgorithm.dfs.DfsStack;
import org.junit.jupiter.api.Test;

class dfsStackTest {

  @Test
  public void test1() {
    Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    DfsStack dfsStack = new DfsStack();
    dfsStack.findAnswer(sample, 5);
  }

}
