package org.example.searchAlgorithm.dfs;

import java.util.Arrays;

/**
 * Created by robin on 6/23/24.
 *
 * @author robin
 * @version 6/23/24.
 * @implNote First created
 */
// 오름차순으로 검색
public class DfsRecursion {

  Integer answer;
  boolean[] visited;
  boolean findAnswer;

  // 배열의 인덱스가 노드번호이고, 각 노드에 연결된 숫자를 써둔 것임.
  static Integer[][] sample = {{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

  private void recursion (Integer nodeIndex, Integer[][] graph) {
    if (visited[nodeIndex - 1]) {
      System.out.println("이미 방문한 노드임: " + nodeIndex);
      return;
    }

    visited[nodeIndex - 1] = true;
    System.out.println("**** 처음 방문함: " + nodeIndex);
    if (nodeIndex.equals(answer)) {
      System.out.println("!!! 목표 노드를 발견 !!!: " + nodeIndex);
      findAnswer = true;
      return;
    }

    for (Integer node : graph[nodeIndex - 1]) {
      recursion(node, graph);
      if (findAnswer) {
        System.out.println("목표 노드를 찾았으므로 탐색 중지");
        break;
      }
    }
  }

  public void dfsRecursion(Integer[][] graph, Integer answer) {
    visited = new boolean[graph.length]; //Boolean 대신 boolean 기본형 배열을 사용하여 메모리 사용을 최적화 가능.
    Arrays.fill(visited, false);
    this.findAnswer = false;
    this.answer = answer;

    recursion(1, graph);
  }

}
