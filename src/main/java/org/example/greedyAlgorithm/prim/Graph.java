package org.example.greedyAlgorithm.prim;

import java.util.LinkedList;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class Graph {
  int nodeCount; // 정점의 개수
  LinkedList<Edge>[] adjacencylist; // 인접 리스트

  private Graph() {}

  public static Graph create(int noeCount) {
    Graph graph = new Graph();
    graph.nodeCount = noeCount;
    graph.adjacencylist = new LinkedList[noeCount];
    for (int i = 0; i < noeCount; i++) {
      graph.adjacencylist[i] = new LinkedList<>();
    }

    return graph;
  }

  public void addEdge(int source, int destination, int weight) {
    Edge edge = new Edge(source, destination, weight);
    adjacencylist[source].addFirst(edge);
    edge = new Edge(destination, source, weight);
    adjacencylist[destination].addFirst(edge); // for undirected graph
  }

}
