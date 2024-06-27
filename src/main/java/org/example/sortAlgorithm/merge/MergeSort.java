package org.example.sortAlgorithm.merge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by robin on 6/24/24.
 *
 * @author robin
 * @version 6/24/24.
 * @implNote First created
 */
public class MergeSort {

  //재귀함수
  //합치면서 정렬
  private List<Integer> mergeSort(List<Integer> list) {
    if (list.size() <= 1) {
      return list;
    }

    int pivot = list.size() / 2;

    List<Integer> leftGroup = mergeSort(list.subList(0, pivot));
    List<Integer> rightGroup = mergeSort(list.subList(pivot, list.size()));

    return merge(leftGroup, rightGroup);
  }

  // 분해된 요소를 다시 합치기
  private List<Integer> merge(List<Integer> leftGroup, List<Integer> rightGroup) {
    List<Integer> temp = new ArrayList<>();

    Queue<Integer> leftQueue = new LinkedList<>(leftGroup);
    Queue<Integer> rightQueue = new LinkedList<>(rightGroup);


    while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
      if (leftQueue.isEmpty()) {
        while (!rightQueue.isEmpty()) {
          temp.add(rightQueue.poll());
        }
        break;
      }

      if (rightQueue.isEmpty()) {
        while (!leftQueue.isEmpty()) {
          temp.add(leftQueue.poll());
        }
        break;
      }


      if (leftQueue.peek() <= rightQueue.peek()) {
        temp.add(leftQueue.poll());
      } else {
        temp.add(rightQueue.poll());
      }

    }

    return temp;
  }

  public void sort(List<Integer> list) {
    List<Integer> sorted = mergeSort(list);

    for (int value : sorted) {
      System.out.print(value + " -> ");
    }
  }

}
