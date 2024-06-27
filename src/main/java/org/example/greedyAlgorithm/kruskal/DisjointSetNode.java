package org.example.greedyAlgorithm.kruskal;

/**
 * Created by robin on 6/27/24.
 * 유니온-파인드 자료 구조를 구현하기 위해 사용
 * 유니온-파인드의 각 원소(서로소 집합)로써 모든 DisjointSetNode끼리는 서로소이다.
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class DisjointSetNode {

  int parent; // 트리에서 해당 노드의 부모를 가리킨다. *루트 노드의 부모는 자기 자신임.
  int rank; // 트리의 높이를 나타내며, 트리의 균형을 유지하기 위해 사용된다. 유니온 연산 시, 랭크가 낮은 트리를 랭크가 높은 트리 밑에 붙인다.

  private DisjointSetNode() {}

  public static DisjointSetNode empty() {
    return new DisjointSetNode();
  }

  public static DisjointSetNode createSingleNode(int nodeIndex) {
    // 하나의 노드로만 이루어진 유니온파인드 그래프에서는 부모는 나자신, 나자신으로의 비용은 0이다.
    DisjointSetNode disjointSetNode = new DisjointSetNode();
    disjointSetNode.parent = nodeIndex;
    disjointSetNode.rank = 0;
    return disjointSetNode;
  }

}
