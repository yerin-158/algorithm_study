package org.example.greedyAlgorithm.kruskal;

import java.util.Arrays;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class KruskalAlgorithm {

  /**
   * 크루스칼 알고리즘을 통해 최소 신장 트리를 찾는 메소드
   */
  public void findMST(int nodeCount, int edgeCount, int[][] arr) {

    // 1. 주어진 그래프 생성
    Graph graph = new Graph(nodeCount, edgeCount);
    for (int i = 0; i < arr.length; i++) {
      graph.edges[i] = new Edge(arr[i][0], arr[i][1], arr[i][2]);
    }

    // 크루스칼 알고리즘에서 최소 신장 트리(MST)는 항상 (정점의 수−1)개의 간선으로 구성됨
    Edge[] result = new Edge[nodeCount - 1];

    for (int i = 0; i < result.length; i++) {
      result[i] = Edge.empty();
    }

    // 3. 비용 오름차순으로 정렬
    Arrays.sort(graph.edges);

    // 4. 유니온 파인드 그래프 초기화
    DisjointSetNode[] nodes = new DisjointSetNode[nodeCount];
    for (int i = 0; i < nodeCount; i++) {
      nodes[i] = DisjointSetNode.createSingleNode(i);
    }

    // 정렬된 graph.edges에서 그리디하게 최소 비용을 찾아낸다.
    int resultEdgeIndex = 0; // 결과값(최소 비용 엣지) 저장용 인덱스
    int graphEdgeIndex = 0; // 그래프 순환용 인덱스
    while (resultEdgeIndex < nodeCount - 1) {
      // 최소 비용 엣지
      // 노드는 신경쓰지 않고 엣지를 선택만 하면 됨.
      Edge nextEdge = graph.edges[graphEdgeIndex++];

      // 저렴한 엣지의 시작 노드의 최상위 노드를 찾는다.
      int x = graph.find(nodes, nextEdge.source);
      // 저렴한 엣지의 도착 노드의 최상위 노드를 찾는다.
      int y = graph.find(nodes, nextEdge.destination);

      // 사이클이 아니면
      if (x != y) {
        // 저렴한 셋지를 결과값에 추가한다.
        result[resultEdgeIndex++] = nextEdge;
        graph.union(nodes, x, y);
      }
    }

    System.out.println("Following are the edges in the constructed MST");
    for (Edge edge : result) {
      System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
    }
  }
}
