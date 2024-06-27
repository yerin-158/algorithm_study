package org.example.searchAlgorithm.dfs;

import org.example.searchAlgorithm.dfs.DfsRecursion;
import org.junit.jupiter.api.Test;

class dfsRecursionTest {

  @Test
  public void test1() {
    DfsRecursion dfsRecursion = new DfsRecursion();

    Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    Integer answer = 7;
    dfsRecursion.dfsRecursion(sample, answer);
  }

  @Test
  public void test2() {
    DfsRecursion dfsRecursion = new DfsRecursion();

    Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    Integer answer = 6;
    dfsRecursion.dfsRecursion(sample, answer);
  }

}
