package org.example.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class ActivitySelection {

  static class Activity {
    int code;

    int start;
    int finish;

    Activity(int code, int start, int finish) {
      this.code = code + 1;
      this.start = start;
      this.finish = finish;
    }
  }

  public void run(int[][] arr) {
    Activity[] activities = new Activity[arr.length];

    for (int i = 0; i < arr.length; i ++) {
      activities[i] = new Activity(i, arr[i][0], arr[i][1]);
    }

    // 종료시간이 빠른 순으로 정렬
    Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

    // 현 시점(그리디)에서 종료시간
    int lastFinishTime = activities[0].finish;
    System.out.println("활동 code:" + activities[0].code + " (" + activities[0].start + " to " + activities[0].finish + ")");

    for (int i = 1; i < activities.length; i++) {
      if (activities[i].start >= lastFinishTime) {
        lastFinishTime = activities[i].finish;
        System.out.println("활동 code:" + activities[i].code + " (" + activities[i].start + " to " + activities[i].finish + ")");
      }
    }

  }
}
