package org.example.greedyAlgorithm.kruskal;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class Edge implements Comparable<Edge> {
  // 노드 A와 노드 B를 연결하는 간선
  // 최소 간선들로 MST를 만드는 것이 목적이므로 사실상 노드의 정보는 중요하지 않음.
    int source; // 간선의 시작지점 (노드 A)
    int destination; // 간선의 종료지점 (노드 B)
    int weight; // 간선의 비용

    private Edge() {}

    public static Edge empty() {
      return new Edge(0, 0, 0);
    }

    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
    }
}
