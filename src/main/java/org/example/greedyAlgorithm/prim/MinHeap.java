package org.example.greedyAlgorithm.prim;

import java.util.PriorityQueue;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class MinHeap {

  // 프림 알고리즘에서 최소 힙을 구성하는 노드
  public static class HeapNode {
    int vertex; // 그래프의 특정 정점
    int weight; // 해당 정점까지의 최소 가중치

    private HeapNode() {}

    public static HeapNode create(int vertex) {
      HeapNode heapNode = new HeapNode();
      heapNode.vertex = vertex;
      heapNode.weight = Integer.MAX_VALUE; // 가중치가 매우 큰 것으로 가정
      return heapNode;
    }
  }

  private PriorityQueue<HeapNode> pq;

  public MinHeap(int size) {
    pq = new PriorityQueue<HeapNode>(size, (o1, o2) -> o1.weight - o2.weight);
  }

  public void add(HeapNode node) {
    pq.offer(node); // 삽입
  }

  public HeapNode extractMin() {
    return pq.poll(); // 삭제
  }

  public boolean isEmpty() {
    return pq.isEmpty();
  }

  public void decreaseKey(int vertex, int newKey) {
    for (HeapNode node : pq) {
      if (node.vertex == vertex) {
        pq.remove(node);
        node.weight = newKey;
        pq.offer(node);
        break;
      }
    }
  }

}
