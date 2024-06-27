package org.example.greedyAlgorithm.prim;

import java.util.LinkedList;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class PrimAlgorithm {

  boolean[] isIncludedHeap; //해당 노드가 힙에 들어가 있는지
  int[] key; //선택된 간선의 최소 가중치 (여러 노드를 거쳐도 최소면 됨)
  int[] parent; //각 노드의 부모 노드
  private void printMST(int[] parent) {
    System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
    for (int i = 1; i < parent.length; i++) {
      System.out.println("Edge: " + parent[i] + " - " + i);
    }
  }

  public void run(int nodeCount, int[][] edges) {
    // 1. 그래프 초기화
    Graph graph = Graph.create(nodeCount);
    for (int i = 0; i < edges.length; i++) {
      graph.addEdge(edges[i][0], edges[i][1], edges[i][2]);
    }

    // 2. 노드 관련 정보 초기화
    MinHeap.HeapNode[] heapNodes = new MinHeap.HeapNode[nodeCount];
    initNodes(nodeCount, heapNodes);


    // 3. 0번 노드에서 시작한다. 0->0은 비용이 0임
    heapNodes[0].weight = 0;

    MinHeap minHeap = new MinHeap(nodeCount);
    for (int i = 0; i < nodeCount; i++) {
      // 노드 추가되면서 우선순위 큐 weight 기준으로 정렬
      minHeap.add(heapNodes[i]);
    }

    // 4. 우선순위 큐가 빌 때까지 반복. 즉 모든 노드가 꺼내질 때까지 반복
    while (!minHeap.isEmpty()) {
      // weight가 가장 작은 노드를 꺼낸다.
      // 최초에는 3)에 의해 첫번째 노드(0)가 꺼내진다.
      MinHeap.HeapNode extractedNode = minHeap.extractMin();

      int extractedVertex = extractedNode.vertex;
      isIncludedHeap[extractedVertex] = false; //힙에서 꺼내졌음을 표시

      // 해당 노드에 인접한 간선을 모두 가져온다.
      LinkedList<Edge> list = graph.adjacencylist[extractedVertex];
      for (Edge edge : list) {
        // 인접한 간선으로 갈 수 있는 노드가 이미 힙에 포함되어 있다면
        if (isIncludedHeap[edge.destination]) {
          int destination = edge.destination;

          int newWeight = edge.weight;
          // 현재 최소 가중치보다 힙에 들어가 있는 값이 작다면
          if (newWeight < key[destination]) {
            // 힙에 들어가있는 노드의 무게를 변경한다.
            minHeap.decreaseKey(destination, newWeight);
            // 목적지에 연결된 것은 힙에서 꺼내진 노드이다.
            parent[destination] = extractedVertex;
            // 현재 최소 가중치도 업데이트한다.
            key[destination] = newWeight;
          }
        }
      }
    }

    // Print MST
    printMST(parent);
  }

  private void initNodes(int nodeCount, MinHeap.HeapNode[] heapNodes) {
    isIncludedHeap = new boolean[nodeCount];
    key = new int[nodeCount];
    parent = new int[nodeCount];

    for (int i = 0; i < nodeCount; i++) {
      heapNodes[i] = MinHeap.HeapNode.create(i);
      parent[i] = -1; // 모든 노드는 부모가 없는 상태
      isIncludedHeap[i] = true; // 모든 노드가 힙에 들어간 상태
      key[i] = Integer.MAX_VALUE; // 선택된 간선이 최대값
    }
  }

}
