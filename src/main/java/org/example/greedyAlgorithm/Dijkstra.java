package org.example.greedyAlgorithm;

import java.util.Arrays;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class Dijkstra {
  private static final int INF = 100000;

  //현재 위치 (i)에서 가장 비용이 적은 노드를 찾는다. (그리디)
  private int getCheapCostIndex(int[] distance, boolean[] visited) {
    int min = INF;
    int index = -1;

    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && distance[i] < min) {
        min = distance[i];
        index = i;
      }
    }

    return index;
  }

  private int[] dijkstraAlgorithm(int[][] graph, int startNode) {
    int nodeCount = graph.length;
    int[] distance = new int[nodeCount];
    boolean[] visited = new boolean[nodeCount];

    Arrays.fill(distance, INF);

    // 현재 노드 -> 현재 노드 비용은 무조건 0임
    distance[startNode] = 0;

    // i는 실제로 알고리즘 내에서 직접적으로 사용되지는 않지만, 모든 노드를 한 번씩 방문하기 위해 필요한 반복 횟수를 제어하는 역할을 합니다.
    for (int i = 0; i < nodeCount - 1; i++) {
      int cheapNode = getCheapCostIndex(distance, visited);
      // 그리디 알고리즘이므로 가장 저렴한 곳만 방문한다. (비싼데는 가보지도 않음)
      visited[cheapNode] = true;

      for (int j = 0; j < nodeCount; j++) {
        // startNode에서 안가본 곳(j) + i=>j까지 비용이 0이 아니고(못 가는 곳) + 가장 가까운 곳이 INF가 아님
        if (!visited[j] && graph[cheapNode][j] != 0 && distance[cheapNode] != INF) {
          // 가장 가까운 곳을 거쳐서 신규 방문지까지 가는 비용(i=>cheapNode=>j)이 i=>j 직항보다 저렴한 경우
          if (distance[cheapNode] + graph[cheapNode][j] < distance[j]) {
            // i=>j 비용은 i=>cheapNode=>j 로 업데이트한다.
            // 이 비용이 가장 저렴한지 알 수 없으므로 visited 처리 안한다. (방문안하고 계산만한다.)
            distance[j] = distance[cheapNode] + graph[cheapNode][j];
          }
        }
      }
    }

    return distance;
  }

  public void run(int[][] graph, int startNode, int endNode) {
    int[] distances = dijkstraAlgorithm(graph, startNode);
    System.out.println(startNode + " ===> " + endNode + " 최소비용: " + distances[endNode]);
    System.out.println("모든 노드로의 최소 비용:");
    for (int i = 0; i < distances.length; i++) {
      System.out.println("노드 " + startNode + "에서 노드 " + i + "까지의 최소 비용: " + distances[i]);
    }
  }

}
