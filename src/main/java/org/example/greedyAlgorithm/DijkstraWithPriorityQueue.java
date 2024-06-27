package org.example.greedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class DijkstraWithPriorityQueue {

  private static final int INF = 100000;

  private static class Node implements Comparable<Node> {
    int index;
    int distance;

    Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
      return Integer.compare(this.distance, other.distance);
    }
  }

  private int[] dijkstraAlgorithm(int[][] graph, int startNode) {
    int nodeCount = graph.length;
    int[] distance = new int[nodeCount];
    boolean[] visited = new boolean[nodeCount];

    Arrays.fill(distance, INF);
    distance[startNode] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(startNode, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int u = node.index;

      if (visited[u]) continue;
      visited[u] = true;

      for (int v = 0; v < nodeCount; v++) {
        if (graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
          distance[v] = distance[u] + graph[u][v];
          pq.add(new Node(v, distance[v]));
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
