package org.example.greedyAlgorithm.kruskal;

/**
 * Created by robin on 6/27/24.
 * 크루스칼로 만든 최소 신장트리
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class Graph {

  int nodeCount = 0; // 정점의 수
  int edgeCount = 0; // 간선의 수
  Edge[] edges; // 간선 배열

  public Graph(int nodeCount, int edgeCount) {
    this.nodeCount = nodeCount;
    this.edgeCount = edgeCount;
    // 간선 수 만큼 Edge 생성
    edges = new Edge[edgeCount];
    for (int i = 0; i < edgeCount; ++i) {
      // 0으로 초기화
      edges[i] = Edge.empty();
    }
  }

  /**
   * 유니온-파인드 구조에서 특정 정점의 부모를 찾는다.
   * 즉, 이 메서드는 주어진 인덱스 i가 속한 집합의 루트를 찾는다.
   * @param nodes
   * @param i 정점의 인덱스
   * @return
   */
  public int find(DisjointSetNode[] nodes, int i) {
    if (nodes[i].parent != i) { // i가 루트노드가 아니면
      // (경로압축) 최상위 노드를 찾기위해 재귀로 루트까지 올라간다. 처음 index에서 최상위 노드까지 모두 최상위 노드로의 직접 경로가 생긴다.
      // 즉, 경로 내의 모든 노드의 부모 노드가 루트 노드로 통일된다.
      nodes[i].parent = find(nodes, nodes[i].parent);
    }

    return nodes[i].parent;
  }

  /**
   * 두 정점을 합친다.
   * @param nodes
   * @param x 특정 정점 X의 인덱스
   * @param y 특정 정점 Y의 인덱스
   */
  public void union(DisjointSetNode[] nodes, int x, int y) {
    int rootX = find(nodes, x); // 정점 X의 루트 노드를 가져온다.
    int rootY = find(nodes, y); // 정점 Y의 루트 노드를 가져온다.

    if (nodes[rootX].rank < nodes[rootY].rank) {
      nodes[rootX].parent = rootY; // 랭크가 낮은 루트노드를 높은 루트노드의 자식으로 연결해준다.
    } else if (nodes[rootX].rank > nodes[rootY].rank) {
      nodes[rootY].parent = rootX;
    } else { // 루트의 랭크가 같은 경우
      nodes[rootY].parent = rootX; //임의로 한 트리를 다른 트리 아래에 붙인다.
      nodes[rootX].rank++; // X트리에 Y를 붙였으므로 X의 랭크를 증가시켜준다.
    }
  }

}
