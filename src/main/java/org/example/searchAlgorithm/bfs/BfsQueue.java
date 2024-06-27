package org.example.searchAlgorithm.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
public class BfsQueue {

  boolean[] visited;
  public void findAnswer(Integer[][] nodes, Integer answer) {
    Queue<Integer> queue = new LinkedList<>();
    visited = new boolean[nodes.length];

    var startIndex = 1;
    queue.add(startIndex);

    while (!queue.isEmpty()){
      Integer currentNode = queue.poll();
      if (!visited[currentNode - 1]) {
        visited[currentNode - 1] = true;
        System.out.println(" 첫 방문 : " + currentNode);
        if (currentNode == answer) {
          System.out.println(" 정답 발견! ");
          break;
        }
      }

      for (var node : nodes[currentNode - 1]) {
        if (!visited[node - 1]) {
          queue.add(node);
        }
      }
    }
  }

}
