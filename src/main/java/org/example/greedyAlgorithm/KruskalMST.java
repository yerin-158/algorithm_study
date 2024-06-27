package org.example.greedyAlgorithm;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class KruskalMST {

  // 노드 A와 노드 B를 연결하는 간선
  // 최소 간선들로 MST를 만드는 것이 목적이므로 사실상 노드의 정보는 중요하지 않음.
  class Edge implements Comparable<Edge> {
    int source; // 간선의 시작지점 (노드 A)
    int destination; // 간선의 종료지점 (노드 B)
    int weight; // 간선의 비용

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

  int V = 0; // V: 정점의 수
  int E = 0; // E: 간선의 수
  Edge[] edges; // 간선 배열

//  find 메서드: 유니온-파인드 구조에서 특정 정점의 부모를 찾습니다.
//  union 메서드: 두 정점을 합칩니다.
//  kruskalMST 메서드: 크루스칼 알고리즘을 통해 최소 신장 트리를 찾습니다.

}
