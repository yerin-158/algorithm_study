package org.example.greedyAlgorithm.prim;

/**
 * Created by robin on 6/27/24.
 *
 * @author robin
 * @version 6/27/24.
 * @implNote First created
 */
public class Edge implements Comparable<Edge> {
  int source;
  int destination;
  int weight;

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
