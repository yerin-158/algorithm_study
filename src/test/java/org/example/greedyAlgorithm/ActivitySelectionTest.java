package org.example.greedyAlgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivitySelectionTest {

  @Test
  public void test1() {
    ActivitySelection activitySelection = new ActivitySelection();
    int[][] activities = {
        {1, 4},
        {3, 5},
        {0, 6},
        {5, 7},
        {3, 8},
        {5, 9},
        {6, 10},
        {8, 11},
        {8, 12},
        {2, 13}
    };

    activitySelection.run(activities);
  }

}
